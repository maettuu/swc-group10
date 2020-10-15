package battleships.boardobjects.addbehavior;

import battleships.boardobjects.BoardField;
import battleships.Board;
import battleships.exceptions.InvalidInputException;
import java.util.List;

/**
 * Interface for determining how a ship can be added to a board.
 */
public interface AddBehavior {
    public void addToBoard(Board board, List<BoardField> fields, int[] start, int[] end) throws InvalidInputException;
}
