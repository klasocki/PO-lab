package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import javafx.geometry.Pos;

public class Car {
    private MapDirection orientation = MapDirection.NORTH;
    private Position position = new Position(2, 2);
    final int mapSize = 5;

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

    @Override
    public String toString() {
        return "Position: " + position.toString() + "\nOrientation: " + orientation.toString();
    }


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

    private void tryToMove(MoveDirection direction) {
        Position result;
        if (direction.equals(MoveDirection.FORWARD)) {
            result = position.add(this.getUnitVector(true));
        } else {
            result = position.add(this.getUnitVector(false));
        }
        if (isValidMove(result)) {
            this.position = result;
        }
    }

    private boolean isValidMove(Position position) {
        return position.x >= 0 && position.x < mapSize && position.y >= 0 && position.y < mapSize;
    }
}
