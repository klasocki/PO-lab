package lab5;

import agh.cs.lab2.Position;

public class HayStack implements IMapElement{
    private Position position;

    public HayStack(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "s";
    }
}
