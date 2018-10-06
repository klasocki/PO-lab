package agh.cs.lab1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");

        Stream<Direction> runArguments = Arrays.stream(args)
                .map(a -> stringToDir(a))
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

    private static Direction stringToDir(String dir) {
        Direction result;
        switch (dir) {
            case "f":
                result = Direction.FORWARD;
                break;
            case "b":
                result = Direction.BACKWARD;
                break;
            case "l":
                result = Direction.LEFT;
                break;
            case "r":
                result = Direction.RIGHT;
                break;
            default:
                result = null;
        }
        return result;
    }
}
