package agh.cs.lab5;

import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    final Position[] carPositions = {
            //new Position(2, 2),
            new Position(0, 0),
            new Position(1, 3),
    };

    final Position[] hayPositions = {
            new Position(-1, 0),
            new Position(0, -1),
            new Position(-54, -1),
            new Position(6, 7),
            new Position(0, 23),
    };
    final Position[] untakenPositions = {
            new Position(-11, 0),
            new Position(0, -15),
            new Position(0, -8),
            new Position(58, 7),
            new Position(0, 22),
    };
    ArrayList<HayStack> hayStacks;

    public IWorldMap placeCars() throws IllegalArgumentException {
        hayStacks = new ArrayList<>();
        for (Position p : hayPositions) {
            hayStacks.add(new HayStack(p));
        }
        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map)); //default Position is (2,2)
        for (Position p : carPositions) {
            map.place(new Car(p, map));
        }
        return map;
    }

    @Test(expected = IllegalArgumentException.class)
    public void place() {
        IWorldMap map = placeCars();
        for (Position p : hayPositions) {
            //this loop should do nothing
            map.place(new Car(p, map));
        }
        System.out.println(map.toString());
    }

    @Test
    public void objectAt() {
        IWorldMap map = placeCars();

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
        IWorldMap map = placeCars();

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
        IWorldMap map = placeCars();

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

    @Test(expected = IllegalArgumentException.class)
    public void run() {

        IWorldMap map = placeCars();

        String[] dir = {
                "espfok,", "r", "b", "BACKWARD", "forward", "l", "l", "r", "f", "f", "l", "b", "b", "f", "f", "asf3"
        };
        map.run(OptionsParser.parse(dir));
    }

    @Test
    public void properRun() {
        IWorldMap mapForRun = placeCars();
        String[] dir = {
                "r", "b", "BACKWARD", "forward", "l", "l", "r", "f", "f", "l", "b", "b", "f", "f"
        };
        mapForRun.run(OptionsParser.parse(dir));
    }
}