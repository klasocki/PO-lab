package lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    final int width;
    final int height;
    private List<Car> carsOnMap;
    MapVisualizer mapVisualizer;
    final Position lowerLeft;
    final Position upperRight;


    public RectangularMap(int width, int height) {
        //TODO perform check on arguments
        this.width = width;
        this.height = height;
        carsOnMap = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);
        upperRight = new Position(width-1, height-1);
        lowerLeft = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return upperRight.smaller(position) && lowerLeft.larger(position);
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
        return draw();
    }

    public String draw() {
        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
