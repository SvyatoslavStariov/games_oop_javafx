package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack black = new BishopBlack(Cell.A1);
        assertEquals(black.position(), Cell.A1);
    }

    @Test
    public void testCopy() {
        BishopBlack black = new BishopBlack(Cell.A1);
        Figure copy = black.copy(Cell.A2);
        assertEquals(copy.position(), Cell.A2);
    }

    @Test
    public void testWay() {
        BishopBlack black = new BishopBlack(Cell.C1);
        Cell[] way = black.way(Cell.G5);
        assertArrayEquals(way, new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }
}