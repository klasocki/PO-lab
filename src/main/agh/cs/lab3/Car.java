package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.Position;

public class Car {
    private MapDirection orientation = MapDirection.NORTH;
    private Position position = new Position(2, 2);

    @Override
    public String toString() {
        return "Position: " + position.toString() + "\nOrientation: " + orientation.toString();
    }
}
