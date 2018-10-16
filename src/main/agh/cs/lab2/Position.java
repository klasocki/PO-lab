package agh.cs.lab2;

import javafx.geometry.Pos;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position other) { return other.x<=this.x && other.y<=this.y; }
    public boolean larger(Position other) { return other.x>=this.x && other.y>=this.y; }

    public Position upperRight(Position other) {
        int newX = Math.max(this.x, other.x);
        int newY = Math.max(this.y, other.y);
        return new Position(newX, newY);
    }

    public Position lowerLeft(Position other) {
        int newX = Math.min(this.x, other.x);
        int newY = Math.min(this.y, other.y);
        return new Position(newX, newY);
    }

    public Position add(Position other) {
        return new Position(this.x + other.x, this.y + other.y);
    }
    public Position opposite(){
        return new Position(-this.x, -this.y);
    }
    public boolean equals(Object other) {
        if(this==other) return true;
        if(!(other instanceof Position)) return false;
        Position another = (Position) other;
        return another.x == this.x && another.y == this.y;
    }
}
