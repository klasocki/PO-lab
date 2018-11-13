package agh.cs.lab5;

import agh.cs.lab2.Position;

import java.util.ArrayList;
import java.util.Iterator;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(ArrayList<HayStack> hayStacks) {
        for (HayStack hs : hayStacks) {
            this.mapElements.put(hs.getPosition(), hs);
        }
    }

    @Override
    public String toString() {
        if(mapElements.isEmpty()) return "";
        MapBoundaries mapBoundaries = new MapBoundaries().invoke();
        Position lowerLeft = mapBoundaries.getLowerLeft();
        Position upperRight = mapBoundaries.getUpperRight();
        return mapVisualizer.draw(lowerLeft,upperRight);
    }

    private class MapBoundaries {
        private Position lowerLeft;
        private Position upperRight;

        public Position getLowerLeft() {
            return lowerLeft;
        }

        public Position getUpperRight() {
            return upperRight;
        }

        public MapBoundaries invoke() {
            Iterator<Position> iterator = mapElements.keySet().iterator();
            lowerLeft = iterator.next();
            upperRight = lowerLeft;
            while (iterator.hasNext()){
                Position position = iterator.next();
                lowerLeft = position.lowerLeft(lowerLeft);
                upperRight = position.upperRight(upperRight);
            }
            return this;
        }
    }
}
