package no.hvl.dat108.oblig1.oppgave2abstract.models;


import java.util.Random;

import static no.hvl.dat108.oblig1.oppgave2abstract.helpers.Utility.getNextColor;
import static no.hvl.dat108.oblig1.oppgave2abstract.helpers.Utility.resetColor;


public abstract class Employee {

    protected static final Random random = new Random();
    protected static final Track track = Track.getInstance();

    private final int id;
    private final String employeeRole;

    public Employee(int id) {
        this.id = id;
        this.employeeRole = getNextColor() + (this instanceof Chef ? "Chef" : "Waiter") + resetColor();
    }

    public void work() {
        try {
            Thread.sleep(random.nextInt(4000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", employeeRole, id);
    }
}