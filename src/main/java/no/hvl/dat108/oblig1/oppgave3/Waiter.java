package no.hvl.dat108.oblig1.oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Waiter extends Thread {

    private final BlockingQueue<Burger> bq;
    private Random random = new Random();
    private String name;


    public Waiter(BlockingQueue<Burger> bq, String name) {
        this.bq = bq;
        this.setName(name);

    }

    @Override
    public void run() {


        while (true) {

            try {

                Thread.sleep(random.nextInt(4000) + 2000);
                if(bq.isEmpty()) {
                    System.out.print(this.getName() + " waits to collect, but the track is EMPTY. WAITING! \n");
                }
                Burger collectedBurger = bq.take();
                System.out.print(this.getName() + " collects [" + collectedBurger.getId() + "]" +collectedBurger.getType() + " <= " + bq + "\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }
}