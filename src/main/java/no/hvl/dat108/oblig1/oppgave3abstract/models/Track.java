package no.hvl.dat108.oblig1.oppgave3abstract.models;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static no.hvl.dat108.oblig1.oppgave3abstract.helpers.Utility.currentTime;


// singleton class
public class Track {

    private static class Loc {
        static final String ADD = "[%s] %s adds hamburger%s => %s\n";
        static final String REMOVE = "[%s] %s removes hamburger%s <= %s\n";
        static final String CLOSE = "[%s] Shop closing, no more orders.\n";
    }

    private final static Track instance = new Track();
    private final static int CAPACITY = 5;
    private boolean recieveOrder = true;

    private final BlockingQueue<Hamburger> hamburgere;

    private Track() {
        this.hamburgere = new LinkedBlockingQueue<>(CAPACITY);
    }

    public static Track getInstance() {
        return instance;
    }

    public void addBurger(Chef chef, Hamburger hamburger) {
        try {
            hamburgere.put(hamburger);
            System.out.printf(Loc.ADD, currentTime(), chef, hamburger, hamburgere);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeBurger(Waiter waiter) {
        try {
            Hamburger hamburger = hamburgere.take();
            System.out.printf(Loc.REMOVE, currentTime(), waiter, hamburger, hamburgere);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        System.out.printf(Loc.CLOSE, currentTime());
        recieveOrder = false;
    }

    public boolean recieveOrder() {
        return recieveOrder;
    }

    public boolean isEmpty() {
        return hamburgere.isEmpty();
    }
}
