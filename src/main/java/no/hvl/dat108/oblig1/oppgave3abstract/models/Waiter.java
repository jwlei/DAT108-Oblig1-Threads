package no.hvl.dat108.oblig1.oppgave3abstract.models;

public class Waiter extends Employee implements Runnable {

    public Waiter(int id) {
        super(id);
    }

    @Override
    public void run() {
        while (track.recieveOrder()) {
            work();
            if (!track.isEmpty()) {
                track.removeBurger(this);
            }

        }
    }
}
