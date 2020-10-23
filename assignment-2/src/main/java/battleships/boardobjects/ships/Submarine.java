package main.java.battleships.boardobjects.ships;

public class Submarine extends Ship {

    public int getLength() {
        return 3;
    }

    @Override
    public String toString() {
        return "S";
    }

    public String getName() {
        return "Submarine";
    }
}
