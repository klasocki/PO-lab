package lab5;

import agh.cs.lab2.Position;

import java.util.ArrayList;
public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(ArrayList<HayStack> hayStacks) {
        for (HayStack hs : hayStacks) {
            this.mapElements.put(hs.getPosition(), hs);
        }
    }

    @Override
    public String toString() {
        Position lowerLeft = mapElements.get(0).getPosition();
        Position upperRight = lowerLeft;
        for (int i = 1; i < mapElements.size(); i++) {
            lowerLeft = mapElements.get(i).getPosition().lowerLeft(lowerLeft);
            upperRight = mapElements.get(i).getPosition().upperRight(upperRight);
        }
        return mapVisualizer.draw(lowerLeft,upperRight);
    }
}
