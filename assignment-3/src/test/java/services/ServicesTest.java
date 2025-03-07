package services;

import battleships.Board;
import battleships.coordinates.Coordinate;
import battleships.boardobjects.ships.Battleship;
import battleships.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class ServicesTest {

    @Test
    public void emptyBoardTest() throws InvalidInputException {

        Board board = new Board(10,10);

        Assertions.assertEquals(
                board.isOccupied(5,3), false
        );
    }

    @Test
    public void addShipTest() throws InvalidInputException {

        Board board = new Board(10,10);

        Battleship battleship = new Battleship();

        battleship.addToBoard(board,new Coordinate(board,0,0), new Coordinate(board, 0, 3));

        Assertions.assertEquals(
                true, board.isOccupied(0,0)
        );
        Assertions.assertEquals(
                true, board.isOccupied(0,1)
        );
        Assertions.assertEquals(
                true, board.isOccupied(0,2)
        );
        Assertions.assertEquals(
               true,  board.isOccupied(0,3)
        );
    }

    @Test
    public void sinkShipTest() throws InvalidInputException {

        Board board = new Board(10,10);

        Battleship battleship = new Battleship();

        battleship.addToBoard(board,new Coordinate(board,0,0), new Coordinate(board, 0, 3));

        board.hit(new Coordinate(board, 0, 1));

        Assertions.assertEquals(true, battleship.isIntact());

        board.hit(new Coordinate(board, 0, 0));
        board.hit(new Coordinate(board, 0, 2));
        board.hit(new Coordinate(board, 0, 3));

        Assertions.assertEquals(false, battleship.isIntact());
    }

}
