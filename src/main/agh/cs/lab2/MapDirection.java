package agh.cs.lab2;

public enum MapDirection {
    NORTH, EAST, SOUTH, WEST;
    private final int numberOfDirections=4;

    @Override
    public String toString() {
        switch (this) {
            case EAST:
                return "Wschód";
            case WEST:
                return "Zachód";
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            default:
                return "";
        }
    }

    public MapDirection next() {
        int index = this.ordinal();
        return MapDirection.values()[(index+1)%numberOfDirections];
    }
    public MapDirection previous() {
        int index = this.ordinal();
        return MapDirection.values()[(index-1)%numberOfDirections];
    }
}
