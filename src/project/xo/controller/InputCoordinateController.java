package project.xo.controller;

import project.xo.controller.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCoordinateController {

    public int enterCoordinate(final int fieldSize) throws InvalidPointException, InputMismatchException {
        final int n = new Scanner(System.in).nextInt();

        validCoordinate(n, fieldSize);

        return n;
    }

    private void validCoordinate(final int n, final int fieldSize) throws InvalidPointException {
        final int MIN = 1;

        if (n < MIN || n > fieldSize) {
            throw new InvalidPointException();
        }
    }

}
