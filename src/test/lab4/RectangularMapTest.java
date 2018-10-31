package lab4;

import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import javafx.geometry.Pos;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

// How to replace all the for loops? Lambdas? Do they work with asserts?

public class RectangularMapTest {
    static final int height = 4;
    static final int width = 5;
    static final IWorldMap map = new RectangularMap(width, height);

    final static Position[] properPositions = {
            new Position(2, 2),
            new Position(width - 1, height - 1),
            new Position(0, 0),
            new Position(1, 3),
    };

    final static Position[] improperPositions = {
            new Position(-1, 0),
            new Position(0, -1),
            new Position(-547, -1),
            new Position(467, 76),
            new Position(width, height),
            new Position(width - 1, height),
            new Position(width, height - 1),
            new Position(0, 235),
    };

    @BeforeClass
    public static void placeCars() {
        map.place(new Car(map)); //default Position is (2,2)
        for (Position p : properPositions) {
            map.place(new Car(p, map));
        }
        for (Position p : improperPositions) {
            map.place(new Car(p, map));
        }
    }
    @Test
    public void place() {
        //how to test this better? Reflection?
        System.out.println(map.toString());
    }

    @Test
    public void isOccupied() {
        for (Position p : properPositions) {
            assertTrue(map.isOccupied(p));
        }
        for (Position p : improperPositions) {
            assertFalse(map.isOccupied(p));
        }
        assertFalse(map.isOccupied(new Position(3, 1)));
        assertFalse(map.isOccupied(new Position(1, 2)));
    }

    @Test
    public void objectAt() {
        for (Position p : improperPositions) {
            assertEquals(map.objectAt(p), null);
        }
        for (Position p : properPositions) {
            assertEquals(map.objectAt(p), new Car(p, map));
        }
    }

    @Test
    public void canMoveTo() {
        for (Position p : properPositions) {
            assertFalse(map.canMoveTo(p));
        }
        for (Position p : improperPositions) {
            assertFalse(map.canMoveTo(p));
        }
        assertTrue(map.canMoveTo(new Position(0, 1)));
        assertTrue(map.canMoveTo(new Position(1, 1)));
        assertTrue(map.canMoveTo(new Position(1, 0)));
        assertTrue(map.canMoveTo(new Position(width - 1, height - 2)));
        assertTrue(map.canMoveTo(new Position(3, 3)));
    }

    @Test
    public void run() {
    }

}