package no.hvl.dat108.oblig1.oppgave2abstract.models;

public class Waiter extends Employee implements Runnable {

    public Waiter(int id) {
        super(id);
    }

    @Override
    public void run() {

        while (track.recieveOrder() || !track.isEmpty()) {
            work();
            track.removeHamburger(this);
        }
    }
}
