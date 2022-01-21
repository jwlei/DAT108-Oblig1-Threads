package no.hvl.dat108.oblig1.oppgave2;

public class Track {

    private int lastInQue;
    private Burger[] track;
    private Burger burger;

    public Track() {
        track = new Burger[5];
        lastInQue = 0;
    }

    public synchronized void add(Burger burger) throws InterruptedException {

        while (isFull()) {
            System.out.println(Thread.currentThread().getName() + " waiting to deliver hamburger");
            wait();
        }
        track[lastInQue] = burger;
        lastInQue++;
        System.out.print(Thread.currentThread().getName() + " adds a [" +burger.getId()+"]" + burger.getType() + " => ");
        if (lastInQue == 1)
            notify();

    }

    public synchronized Burger getBurger() throws InterruptedException {

        while (isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " waiting to collect a hamburger");
            wait();
        }
        Burger ut = track[0];
        lastInQue--;

        for(int i = 0; i < lastInQue; i++) {
            track[i] = track[i+1];
        }
        track[lastInQue] = null;
        System.out.print(Thread.currentThread().getName() + " collects [" + ut.getId() + "]" + ut.getType() + " <= ");
        if (lastInQue == 4)
            notify();
        return ut;
    }

    public String peek() {
        return track[0].getType();
    }

    public synchronized boolean isFull() {
        return lastInQue == 5;
    }

    public synchronized boolean isEmpty() { return track[0] == null; }

    public synchronized void printTrack() {

        System.out.print("Hamburgers on the track: ");

        for(int i = 0; i < lastInQue; i++) {

            System.out.print("[" + track[i].getId() + "]" +track[i].getType() + " ");
        }
    }

}