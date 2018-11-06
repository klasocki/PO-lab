package agh.cs.lab2;

public enum MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static MoveDirection stringToDir(String dir) throws IllegalArgumentException {
        MoveDirection result;
        dir=dir.toLowerCase().trim();
        switch (dir) {
            case "f":
            case "forward":
                result = FORWARD;
                break;
            case "b":
            case "backward":
                result = BACKWARD;
                break;
            case "l":
            case "left":
                result = LEFT;
                break;
            case "r":
            case "right":
                result = RIGHT;
                break;
            default:
                throw new IllegalArgumentException(dir + " is not legal move specification");
        }
        return result;
    }
}
