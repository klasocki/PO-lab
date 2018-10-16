package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTestCar {
    @Test
    public void moveTest() {
        String[] testCommands = {"forward", "r", "wepto3twq", "backward", "b", "l", "left", "f", "f", "f"};
        MoveDirection[] commands = OptionsParser.parse(testCommands);
        Car car = new Car();
        for (MoveDirection dir : commands) {
            car.move(dir);
        }
        assertEquals("Position: (0,3)\nOrientation: Zachód", car.toString());
    }
}
