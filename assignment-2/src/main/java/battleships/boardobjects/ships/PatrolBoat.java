package main.java.battleships.boardobjects.ships;

public class PatrolBoat extends Ship {

    public int getLength() {
        return 2;
    }

    @Override
    public String toString() {
        return "P";
    }

    public String getName() {
        return "Patrol boat";
    }
}
