package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.add(new BishopBlack(Cell.D7));
            logic.add(new BishopBlack(Cell.C8));
            logic.move(Cell.C8, Cell.D7);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure occupied.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        ImpossibleMoveException  exception = assertThrows(ImpossibleMoveException .class, () -> {
            logic.add(new BishopBlack(Cell.C8));
            logic.move(Cell.C8, Cell.C6);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C8 to C6");
    }
}