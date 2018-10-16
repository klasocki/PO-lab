package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.toString());
        car.move(MoveDirection.RIGHT);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        car.move(MoveDirection.FORWARD);
        System.out.println(car.toString());

    }
}
