package agh.cs.lab1;

public enum Direction {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static Direction stringToDir(String dir) {
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
