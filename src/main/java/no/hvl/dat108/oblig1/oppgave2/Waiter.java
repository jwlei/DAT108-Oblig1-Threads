package no.hvl.dat108.oblig1.oppgave2;

import java.util.Random;

public class Waiter extends Thread {

    private final Track track;
    private Random random = new Random();
    String name;

    public Waiter(Track track, String name) {
        this.track = track;
        this.setName(name);
    }


    @Override
    public void run() {

        while(true) {

            try {
                this.sleep(random.nextInt(4000) + 2000);
                track.getBurger();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            track.printTrack();
            System.out.println();


        }
    }
}



