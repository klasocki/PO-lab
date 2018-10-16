package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Car car = new Car();
        MoveDirection[] commands = OptionsParser.parse(args);
        for (MoveDirection dir : commands) {
            car.move(dir);
        }
        System.out.println(car.toString());
    }
}
