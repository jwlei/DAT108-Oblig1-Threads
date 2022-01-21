package no.hvl.dat108.oblig1.oppgave3;

public class Burger {

    private int TypeNumber;
    private static int BurgerNumber = 0;
    private int id;

    Burger() {
        this.TypeNumber = (int)(Math.random() * 3);
        id = ++BurgerNumber;
    }

    Burger(int TypeNumber) {
        this.TypeNumber = TypeNumber;
    }

    public int getTypeNumber() {
        return TypeNumber;
    }

    public int getId() {
        return id;
    }


    public String getType() {
        if (TypeNumber == 0) {
            return "Cheese";
        }
        if (TypeNumber == 1) {
            return "Bacon";
        }
        if (TypeNumber == 2) {
            return "Royale";
        }

        else return "Speciality";
    }
    @Override
    public String toString() {
        return ("[" + id + "]" + this.getType());
    }
}
