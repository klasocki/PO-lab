package agh.cs.lab1;

public class CarSystem {
    public static void main(String[] args) {
        System.out.println("System start");

        String[] runArguments = {"Very", "Very", "Fast"};

        run(runArguments);

        System.out.println("System finish");
    }

    private static void run(String[] args) {
        System.out.println("Car is moving forward");
        System.out.println(String.join(", ", args));
    }
}
