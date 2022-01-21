package no.hvl.dat108.oblig1.oppgave2;

import java.util.Random;

public class Chef extends Thread {

    private final Track track;
    private Random random = new Random();
    private String name;

    public Chef(Track track, String name) {
        this.setName(name);
        this.track = track;
    }

    @Override
    public void run() {

        while(true) {

          //  Burger burger = makeBurger();

            try {
                Thread.sleep(random.nextInt(4000) + 2000);
                track.add(new Burger());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            track.printTrack();
            System.out.println();
        }

    }

    private Burger makeBurger() {
        return new Burger();
    }

}
