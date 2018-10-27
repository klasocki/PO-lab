package lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    final int width;
    final int height;
    private List<Car> carsOnMap;
    MapVisualizer mapVisualizer;


    public RectangularMap(int width, int height) {
        //TODO perform check on arguments
        this.width = width;
        this.height = height;
        carsOnMap = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.x >= 0 && position.x < width && position.y >= 0 && position.y < height && !isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if (!isOccupied(car.getPosition())) {
            carsOnMap.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            carsOnMap.get(i%carsOnMap.size()). //this is iterating through all the cars,
                    // giving them directions, and coming back to the first one when all cars have already moved
                    move(directions[i]);
            System.out.println(draw());
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        for (Car car : carsOnMap) {
            if(car.getPosition().equals(position)) return true;
        }
        return false;

    }

    @Override
    public Object objectAt(Position position) {
        for (Car car : carsOnMap) {
            if(car.getPosition().equals(position)) return car;
        }
        return null;
    }

    @Override
    public String toString() {
        return mapVisualizer.toString();
    }

    public String draw() {
       return mapVisualizer.draw(new Position(0,0), new Position(width-1, height-1));
    }
}
