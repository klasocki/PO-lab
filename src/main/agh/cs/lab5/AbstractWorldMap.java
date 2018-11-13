package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab7.IPositionChangeObserver;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Position, IMapElement> mapElements = new LinkedHashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);

    @Override
    public Object objectAt(Position position) {
        return mapElements.get(position);
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
    public void place(Car car) throws IllegalArgumentException{
        if (canMoveTo(car.getPosition())) {
            mapElements.put(car.getPosition(), car);
            car.addObserver(this);
        } else throw new IllegalArgumentException("Cannot place car at " + car.getPosition()
                + ", position is already taken or invalid");
    }


    @Override
    public void run(MoveDirection[] directions) {
        ListFilter<Car, IMapElement> filter = new ListFilter<>();
        List<Car> carsOnMap = filter.filterToType(new ArrayList<>(mapElements.values()), o -> (o instanceof Car));
        for (int i = 0; i < directions.length; i++) {
            //this is iterating through all the cars,
            // giving them directions, and coming back to the first one when all cars have already moved
            Car car = carsOnMap.get(i%carsOnMap.size());
            car.move(directions[i]);
            System.out.println(toString());
        }
    }

    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        if (!newPosition.equals(oldPosition)) {
            mapElements.put(newPosition, mapElements.remove(oldPosition));
        }
    }

    /*private List<Car> filterToCars(List<IMapElement> mapElements, Predicate predicate) {
        Car[] result = (Car[]) Arrays.stream(mapElements.toArray())
                .filter(predicate)
                .toArray(Car[]::new);
        return new ArrayList<>(Arrays.asList(result));
    }*/

    private static class ListFilter<To,From> {
        List<To> filterToType(List<From> list, Predicate predicate) {
             return (List<To>)list.stream()
                    .filter(predicate)
                     .collect(Collectors.toList());
        }
    }

}
