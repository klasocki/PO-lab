package lab4;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Position;
import agh.cs.lab3.Car;
import agh.cs.lab3.OptionsParser;

public class CarSystem {
    public static void main(String[] args) {
        try {
            //MoveDirection[] directions =  OptionsParser.parse(args);
            IWorldMap map = new RectangularMap(10, 5);
            map.place(new Car(map));
            map.place(new Car(map));
            map.place(new Car(new Position(3,4), map));
            //map.run(directions);
            System.out.println( map.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

    }
}
