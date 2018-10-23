package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegrationTestCar {
   /*
   These tests are for the older version of Car class. Kept here for future reference

   @Test
    public void moveTest() {
        String[] testCommands = {"forward", "r", "wepto3twq", "backward", "b", "l", "left", "f", "f", "f"};
        MoveDirection[] commands = OptionsParser.parse(testCommands);
        Car car = new Car();
        moveFollowingCommands(car, commands);
        assertEquals("Position: (0,3)\nOrientation: Zachód", car.toString());
        String [] testCommandsTwo = {"","right", "r", "f", "l", "b", "b", "b", "b", "b", "", "f", "r","f",""};
        moveFollowingCommands(car, OptionsParser.parse(testCommandsTwo));
        assertEquals("Position: (2,1)\nOrientation: Wschód", car.toString());


    }

    private void moveFollowingCommands(Car car, MoveDirection[] commands) {
        for (MoveDirection dir : commands) {
            car.move(dir);
        }
    }*/
}
