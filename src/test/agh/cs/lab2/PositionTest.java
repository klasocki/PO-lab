package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void toStringTest() {
        assertEquals("(2,3)", new Position(2, 3).toString());
        assertEquals("(-124,8488)", new Position(-124, 8488).toString());
        assertEquals("(135,-235)", new Position(135, -235).toString());
        assertEquals("(-44,-444)", new Position(-44, -444).toString());
    }

    @Test
    public void smallerTest() {
        assertTrue(new Position(2, 3).smaller(new Position(-1, 2)));
        assertFalse(new Position(5, 3).smaller(new Position(4, 6)));
        assertFalse(new Position(5, 3).smaller(new Position(43, -6)));
        assertFalse(new Position(5, 3).smaller(new Position(2354, 6)));
    }

    @Test
    public void largerTest() {
        assertTrue(new Position(-2, -3).larger(new Position(-1, 2)));
        assertFalse(new Position(5, 3).larger(new Position(4, 6)));
        assertFalse(new Position(5, 3).larger(new Position(43, -6)));
        assertFalse(new Position(5, 3).larger(new Position(-2354, -6)));
    }

    @Test
    public void upperRightTest() {
        assertEquals(new Position(3, 4).upperRight(new Position(7, 8)), new Position(7, 8));
        assertEquals(new Position(3, 4).upperRight(new Position(-2, 8)), new Position(3, 8));

    }

    @Test
    public void lowerLeftTest() {
        assertEquals(new Position(135, 35).lowerLeft(new Position(7, 8)), new Position(7, 8));
        assertEquals(new Position(-3, 4).lowerLeft(new Position(-2, -8)), new Position(-3, -8));
    }

    @Test
    public void addTest() {
        assertEquals(new Position(2, 3).add(new Position(1, 2)), new Position(3, 5));
        assertEquals(new Position(-2, 3).add(new Position(1, -2)), new Position(-1, 1));
    }


}