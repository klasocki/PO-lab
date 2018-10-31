package lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import lab4.IWorldMap;
import lab4.MapVisualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class UnboundedMap implements IWorldMap {
    private List<IMapElement> mapElements ;
    MapVisualizer mapVisualizer;

    public UnboundedMap(ArrayList<HayStack> hayStacks) {
        mapElements = new ArrayList<>();
        this.mapElements.addAll(hayStacks);
        mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if (!isOccupied(car.getPosition())) {
            mapElements.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        List<Car> carsOnMap = filterToCars(mapElements, o -> (o instanceof Car) );
        for (int i = 0; i < directions.length; i++) {
            carsOnMap.get(i%carsOnMap.size()). //this is iterating through all the cars,
                    // giving them directions, and coming back to the first one when all cars have already moved
                            move(directions[i]);
            System.out.println(toString());
        }
    }

    private List<Car> filterToCars(List<IMapElement> mapElements, Predicate predicate) {
        Car[] result = (Car[])Arrays.stream(mapElements.toArray())
                .filter(predicate)
                .toArray(Car[]::new);
        return new ArrayList<>(Arrays.asList(result));
    }
    @Override
    public Object objectAt(Position position) {
        for (IMapElement mapElement : mapElements) {
            if(mapElement.getPosition().equals(position)) return mapElement;
        }
        return null;
    }
    @Override
    public boolean isOccupied(Position position) {
        if(objectAt(position)==null) return false;
        return true;
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
