package agh.cs.lab1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");

        Direction[] runArguments = Arrays.stream(args)
                .map(a -> Direction.stringToDir(a))
                .filter(a -> a != null)
                .toArray(Direction[]::new);

        run(runArguments);

        System.out.println("System finish");
    }

    private static void run(Direction[] args) {
        for (Direction direction : args) {
            switch (direction) {
                case FORWARD:
                    System.out.println("Moving forward");
                    break;
                case BACKWARD:
                    System.out.println("Moving backward");
                    break;
                case LEFT:
                    System.out.println("Moving left");
                    break;
                case RIGHT:
                    System.out.println("Moving right");
                    break;
                default:
                    System.out.println("Wrong direction");
            }
        }
    }

}
