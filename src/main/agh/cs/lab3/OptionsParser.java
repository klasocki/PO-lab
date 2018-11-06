package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) throws IllegalArgumentException{
        return Arrays.stream(args)
                .map(a -> MoveDirection.stringToDir(a) )
                .filter(a -> a != null)
                .toArray(MoveDirection[]::new);
    }
}
