package main.java.battleships.exceptions;

public class NotInStraightLineException extends InvalidInputException {
    public NotInStraightLineException() {
        System.out.println("All boats must be either horizontal or vertical, please try again!");
    }
}
