package no.hvl.dat108.oblig1.oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Chef extends Thread {

    private final BlockingQueue<Burger> bq;
    private Random random = new Random();
    private String name;

    public Chef(BlockingQueue<Burger> bq, String name) {
        this.bq = bq;
        this.setName(name);

    }

    @Override
    public void run() {

        while(true) {

            try {
                Thread.sleep(random.nextInt(4000) + 2000);
                Burger newBurger = new Burger();
                if(bq.remainingCapacity() == 0) {
                    System.out.println(this.getName() + " tries to add " + newBurger.getType() + ", but track is FULL");
                }
                bq.put(newBurger);
                System.out.print(this.getName() + " adds a  [" + newBurger.getId() + "]" + newBurger.getType() + " => " + bq + "\n");



            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
