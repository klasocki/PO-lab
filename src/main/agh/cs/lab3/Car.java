package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.IMapElement;
import agh.cs.lab7.IPositionChangeObserver;
import javafx.geometry.Pos;

import java.util.LinkedList;
import java.util.List;

public class Car implements IMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Position position = new Position(2, 2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;

    public Car(IWorldMap map) {
        this.map = map;
    }

    public Car(Position position, IWorldMap map) {
        this.position = position;
        this.map = map;
        observers = new LinkedList<>();
    }

    Car() {} //This is here for Main from lab3 to compile

    @Override
    public String toString() {
        return orientation.toString();
    }

    public void addObserver(IPositionChangeObserver observer) { observers.add(observer); }

    public void removeObserver(IPositionChangeObserver observer) { observers.remove(observer); }

    public void move(MoveDirection direction) {
        if(direction==null) return;
        switch (direction) {
            case LEFT:
                orientation = orientation.previous();
                break;
            case RIGHT:
                orientation = orientation.next();
                break;
            case FORWARD:
                tryToMove(MoveDirection.FORWARD);
                break;
            case BACKWARD:
                tryToMove(MoveDirection.BACKWARD);
                break;
            default:
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean equals(Object other) {
        //Warning, this does not check if maps are equal
        if(this==other) return true;
        if(!(other instanceof Car)) return false;
        Car another = (Car) other;
        return another.getPosition().equals(this.getPosition()) && another.orientation.equals(this.orientation);
    }
    private void tryToMove(MoveDirection direction) {
        Position result;
        if (direction.equals(MoveDirection.FORWARD)) {
            result = position.add(this.getUnitVector(true));
        } else {
            result = position.add(this.getUnitVector(false));
        }
        if (map.canMoveTo(result)) {
            positionChanged(this.getPosition(), result);
            this.position = result;
        }
    }

    private Position getUnitVector(boolean movingForward) {
        Position result;
        switch (this.orientation) {
            case SOUTH:
                result = new Position(0, -1);
                break;
            case NORTH:
                result = new Position(0, 1);
                break;
            case WEST:
                result = new Position(-1, 0);
                break;
            case EAST:
                result = new Position(1, 0);
                break;
            default:
                result = null;
        }
        if (!movingForward && result != null)
            result = result.opposite();
        return result;
    }

    private void positionChanged(Position oldPosition, Position newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
