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

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<IMapElement> mapElements;
    protected MapVisualizer mapVisualizer;

    public AbstractWorldMap() {
        mapElements = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);
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
        return objectAt(position)!=null;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if (canMoveTo(car.getPosition())) {
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
        Car[] result = (Car[]) Arrays.stream(mapElements.toArray())
                .filter(predicate)
                .toArray(Car[]::new);
        return new ArrayList<>(Arrays.asList(result));
    }

}
