package agh.cs.lab1;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");

        String[] runArguments = {"Very", "Very", "Fast"};

        run(runArguments);
        run(args);

        System.out.println("System finish");
    }

    private static void run(String[] args) {
        for (String dir : args) {
            switch (dir) {
                case "f":
                    System.out.println("Moving forward");
                    break;
                case "b":
                    System.out.println("Moving backward");
                    break;
                case "l":
                    System.out.println("Moving left");
                    break;
                case "r":
                    System.out.println("Moving right");
                    break;
            }
        }
    }
}
