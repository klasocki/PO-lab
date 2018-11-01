package lab5;

import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import javafx.geometry.Pos;
import lab4.IWorldMap;
import lab4.RectangularMap;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnboundedMapTest {
//TODO report mapVisualizer's problem with negative numbers

    final static Position[] carPositions = {
            new Position(2, 2),
            new Position(0, 0),
            new Position(1, 3),
    };

    final static Position[] hayPositions = {
            new Position(-1, 0),
            new Position(0, -1),
            new Position(-54, -1),
            new Position(6, 7),
            new Position(0, 23),
    };
    final static Position[] untakenPositions = {
            new Position(-11, 0),
            new Position(0, -15),
            new Position(0, -8),
            new Position(58, 7),
            new Position(0, 22),
    };
    static ArrayList<HayStack> hayStacks;
    static IWorldMap map;

    @BeforeClass
    public static void placeCars() {
        hayStacks = new ArrayList<>();
        for (Position p : hayPositions) {
            hayStacks.add(new HayStack(p));
        }
        map = new UnboundedMap(hayStacks);
        map.place(new Car(map)); //default Position is (2,2)
        for (Position p : carPositions) {
            map.place(new Car(p, map));
        }
    }

    @Test
    public void place() {
        for (Position p : hayPositions) {
            //this loop should do nothing
            map.place(new Car(p, map));
        }
        System.out.println(map.toString());
    }

    @Test
    public void objectAt() {
        for (HayStack s : hayStacks) {
            assertEquals(s, map.objectAt(s.getPosition()));
        }
        for (Position p : carPositions) {
            assertEquals(new Car(p, map), map.objectAt(p));
        }
        for (Position p : untakenPositions) {
            assertEquals(null, map.objectAt(p));
        }
    }

    @Test
    public void isOccupied() {
        for (HayStack s : hayStacks) {
            assertTrue(map.isOccupied(s.getPosition()));
        }
        for (Position p : carPositions) {
            assertTrue(map.isOccupied(p));
        }
        for (Position p : untakenPositions) {
            assertFalse(map.isOccupied(p));
        }
    }

    @Test
    public void canMoveTo() {
        for (Position p : untakenPositions) {
            assertTrue(map.canMoveTo(p));
        }
        for (Position p : hayPositions) {
            assertFalse(map.canMoveTo(p));
        }
        for (Position p : carPositions) {
            assertFalse(map.canMoveTo(p));
        }
    }

    @Test
    public void run() {
    }
}