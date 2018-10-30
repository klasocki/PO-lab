package lab5;

import agh.cs.lab2.Position;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Position(-4, -4)));
        hayStacks.add(new HayStack(new Position(7, 7)));
        hayStacks.add(new HayStack(new Position(3, 6)));
        hayStacks.add(new HayStack(new Position(2, 0)));

        UnboundedMap map = new UnboundedMap(hayStacks);
        System.out.println(map.toString());

    }
}
