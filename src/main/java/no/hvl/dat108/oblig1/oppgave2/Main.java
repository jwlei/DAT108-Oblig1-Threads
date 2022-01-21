package no.hvl.dat108.oblig1.oppgave2;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        Track track = new Track();

        Chef chef1 = new Chef(track, "Chef1");
        Chef chef2 = new Chef(track, "Chef2");
        Chef chef3 = new Chef(track, "Chef3");
        Waiter serv1 = new Waiter(track, "Waiter1");
        Waiter serv2 = new Waiter(track, "Waiter2");

        chef1.start();
        chef2.start();
        chef3.start();
        serv1.start();
        serv2.start();





    }
}
