package no.hvl.dat108.oblig1.oppgave2abstract.models;

import java.util.ArrayDeque;
import java.util.Queue;

import static no.hvl.dat108.oblig1.oppgave2abstract.helpers.Utility.currentTime;


// singleton class
public class Track {

    private static class Loc {
        static final String EMPTY_TRACK = "[%s]  %s wants to take a hamburger, but the track is EMPTY. WAITING. \n";
        static final String FULL_TRACK = "[%s]  %s is ready with a hamburger, but the track is FULL. WAITING. \n";
        static final String ADD = "[%s] %s adds hamburger%s => %s\n";
        static final String REMOVE = "[%s] %s removes hamburger%s <= %s\n";
        static final String CLOSE = "[%s]  Shop is closing, no more orders. \n";
    }

    private final static Track instance = new Track();
    private final static int CAPACITY = 5;
    private boolean recieveOrder = true;

    private final Queue<Hamburger> hamburgers;

    private Track() {

        this.hamburgers = new ArrayDeque<>(CAPACITY);
    }

    public static Track getInstance() {

        return instance;
    }

    public synchronized void addHamburger(Chef chef, Hamburger hamburger) {
        while (isFull()) {
            System.out.printf(Loc.FULL_TRACK, currentTime(), chef);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf(Loc.ADD, currentTime(), chef, hamburger, hamburgers);
        hamburgers.add(hamburger);
        if (hamburgers.size() == 1) notify(); // vekker en tråd som venter (det legges kun til 1 burger)
    }

    public synchronized void removeHamburger(Waiter waiter) {
        while (hamburgers.isEmpty()) {
            if (!recieveOrder) return;
            System.out.printf(Loc.EMPTY_TRACK, currentTime(), waiter);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Hamburger hamburger = hamburgers.remove();

        System.out.printf(Loc.REMOVE, currentTime(), waiter, hamburger, hamburgers);
        if (hamburgers.size() == CAPACITY - 1) notify(); // vekker en tråd som venter (det fjernes kun 1 burger)
    }

    public void close() {
        System.out.printf(Loc.CLOSE, currentTime());
        recieveOrder = false;
    }

    public boolean recieveOrder() {
        return recieveOrder;
    }

    public boolean isEmpty() {
        return hamburgers.isEmpty();
    }

    public boolean isFull() {
        return hamburgers.size() == CAPACITY;
    }
}
