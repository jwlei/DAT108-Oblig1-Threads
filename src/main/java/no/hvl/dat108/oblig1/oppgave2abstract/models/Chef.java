package no.hvl.dat108.oblig1.oppgave2abstract.models;

public class Chef extends Employee implements Runnable {

    public Chef(int id) {
        super(id);
    }

    @Override
    public void run() {
        while (track.recieveOrder()) {
            work();
            track.addHamburger(this, new Hamburger());
        }
    }
}
