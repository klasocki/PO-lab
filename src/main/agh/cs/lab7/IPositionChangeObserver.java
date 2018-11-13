package agh.cs.lab7;

import agh.cs.lab2.Position;

public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition, Position newPosition);
}
