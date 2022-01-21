package no.hvl.dat108.oblig1.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Burger> bq = new LinkedBlockingQueue<Burger>(5);

        Chef chef1 = new Chef(bq,"Chef1");
        Chef chef2 = new Chef(bq,"Chef2");
        Chef chef3 = new Chef(bq, "Chef3");
        Waiter s1 = new Waiter(bq, "Waiter1");
        Waiter s2 = new Waiter(bq, "Waiter2");

        s1.start();
        s2.start();
        chef1.start();
        chef2.start();
        chef3.start();

    }
}
