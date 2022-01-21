package no.hvl.dat108.oblig1.oppgave2;

public class Burger {

    private int typeNumber;
    private static int burgerNumber = 0;
    private int id;

    Burger() {
        this.typeNumber = (int)(Math.random() * 3);
        id = ++burgerNumber;
    }

    Burger(int typeNumber) {
        this.typeNumber = typeNumber;
    }

    public int getTypeNumber() {
        return typeNumber;
    }

    public int getId() {
        return id;
    }


    public String getType() {
        if (typeNumber == 0) {
            return "Burger with Cheese";
        }
        if (typeNumber == 1) {
            return "Burger Vanilla";
        }
        if (typeNumber == 2) {
            return "Burger with Bacon";
        }

        else return "Special Burger";
    }
}
