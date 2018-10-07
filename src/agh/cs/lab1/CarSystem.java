package agh.cs.lab1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");

        Stream<Direction> runArguments = Arrays.stream(args)
                .map(a -> Direction.stringToDir(a))
                .filter(a -> a != null);

        run(runArguments);

        System.out.println("System finish");
    }

    private static void run(Stream<Direction> args) {
        for (Iterator<Direction> i = args.iterator(); i.hasNext(); ) {
            switch (i.next()) {
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
