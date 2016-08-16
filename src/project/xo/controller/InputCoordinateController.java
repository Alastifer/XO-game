package project.xo.controller;

import project.xo.controller.exceptions.InvalidPointException;
import project.xo.model.Point;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCoordinateController {

    public Point enterCoordinate(final int fieldSize) throws InvalidPointException, InputMismatchException {
        Point point = new Point(validCoordinate(fieldSize), validCoordinate(fieldSize));
        return point;
    }

    private int validCoordinate(final int fieldSize) throws InvalidPointException, InputMismatchException {
        int n = new Scanner(System.in).nextInt();

        if (n < 0 || n >= fieldSize) {
            throw new InvalidPointException();
        }

        return n;
    }

}
