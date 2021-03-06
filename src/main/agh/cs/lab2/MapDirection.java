package agh.cs.lab2;

public enum MapDirection {
    NORTH, EAST, SOUTH, WEST;
    private final int numberOfDirections=4;

    @Override
    public String toString() {
        switch (this) {
            case EAST:
                return ">";
            case WEST:
                return "<";
            case NORTH:
                return "^";
            case SOUTH:
                return "v";
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
        if(index==0) index=numberOfDirections-1;
        else index-=1;
        return MapDirection.values()[index];
    }
}
