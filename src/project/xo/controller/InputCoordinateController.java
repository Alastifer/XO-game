package project.xo.controller;

import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.controller.exceptions.InvalidPointException;
import project.xo.model.Field;
import project.xo.model.Point;

import java.util.Scanner;

public class InputCoordinateController {

    public Point enterCoordinate(final Field field) throws InvalidPointException {
        int fieldSize = field.getSize();
        Point point = new Point(validCoordinate(fieldSize), validCoordinate(fieldSize));
        return point;
    }

    private int validCoordinate(final int fieldSize) throws InvalidPointException{
        int n = new Scanner(System.in).nextInt();

        if (n < 0 || n >= fieldSize) {
            throw new InvalidPointException();
        }

        return n;
    }

}
