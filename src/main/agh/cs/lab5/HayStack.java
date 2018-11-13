package agh.cs.lab5;

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

    public boolean equals(Object other) {
        //Warning, this does not check if maps are equal
        if(this==other) return true;
        if(!(other instanceof HayStack)) return false;
        HayStack another = (HayStack) other;
        return another.getPosition().equals(this.getPosition());
    }
}
