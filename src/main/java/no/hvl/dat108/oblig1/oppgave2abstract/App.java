package no.hvl.dat108.oblig1.oppgave2abstract;

import no.hvl.dat108.oblig1.oppgave2abstract.models.Chef;
import no.hvl.dat108.oblig1.oppgave2abstract.models.Track;
import no.hvl.dat108.oblig1.oppgave2abstract.models.Waiter;

import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat108.oblig1.oppgave2abstract.helpers.Utility.currentTime;

public class App {

    private static final int NUM_CHEFS = 3;
    private static final int NUM_WAITERS = 2;
    private static final int SHOP_IS_OPEN_SECONDS = 30;

    private static final List<Thread> threads = new ArrayList<>(NUM_CHEFS + NUM_WAITERS);


    public static void main(String[] args) {

        initalizeChefs();

        initalizeWaiters();

        waitUntilClose();
        finishOrders();
    }

    private static void initalizeChefs() {
        for (int id = 1; id <= NUM_CHEFS; id++) {
            var thread = new Thread(new Chef(id));
            threads.add(thread);
            thread.start();
        }
    }

    private static void initalizeWaiters() {
        for (int id = 1; id <= NUM_WAITERS; id++) {
            var thread = new Thread(new Waiter(id));
            threads.add(thread);
            thread.start();
        }
    }

    private static void waitUntilClose() {
        try {
            Thread.sleep(SHOP_IS_OPEN_SECONDS * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Track.getInstance().close();
    }

    private static void finishOrders() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("[%s] ### The Shop is closed! \n", currentTime());
    }
}
