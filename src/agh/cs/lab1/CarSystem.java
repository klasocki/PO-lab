package agh.cs.lab1;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");


        Direction[] runArguments = new Direction[args.length];
        for (int i=0; i<args.length; i++) {
            try {
                runArguments[i] = stringToDir(args[i]);
            } catch (Exception e) {
                System.out.println("Wrong argument type: " + args[i]);

            }
        }
        run(runArguments);


        System.out.println("System finish");
    }

    private static void run(Direction[] args) {
        for (Direction dir : args) {

            try {
                switch (dir) {
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
                }
            } catch (Exception e) { }
        }
    }

    private static Direction stringToDir(String dir) {
        Direction result;
        switch (dir) {
            case "f":
                result= Direction.FORWARD;
            break;
            case "b":
                result= Direction.BACKWARD;
            break;
            case "l":
                result= Direction.LEFT;
            break;
            case "r":
                result= Direction.BACKWARD;
            break;
            default:
                throw new RuntimeException("Wrong direction keyword");
        }
       return result;
    }
}