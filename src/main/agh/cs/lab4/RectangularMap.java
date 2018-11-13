package agh.cs.lab4;

import agh.cs.lab2.Position;
import agh.cs.lab5.AbstractWorldMap;

public class RectangularMap extends AbstractWorldMap {
    final int width;
    final int height;
    final Position lowerLeft;
    final Position upperRight;


    public RectangularMap(int width, int height) {
        //TODO perform check on arguments
        this.width = width;
        this.height = height;
        upperRight = new Position(width-1, height-1);
        lowerLeft = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return lowerLeft.larger(position) && upperRight.smaller(position) && super.canMoveTo(position);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
