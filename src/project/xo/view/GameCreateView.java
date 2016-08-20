package project.xo.view;

import project.xo.controller.GameCreateController;
import project.xo.controller.exceptions.FieldSizeException;
import project.xo.model.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameCreateView {

    private final int MIN = 3;
    private final int MAX = 10;

    public Game createView() {
        ClearConsoleView.clearConsole();
        helloMessage();
        final int fieldSize = fieldSizeCreate();
        final String playerXName = playerXCreate();
        final String playerOName = playerOCreate();
        ClearConsoleView.clearConsole();
        return new GameCreateController().gameCreate(fieldSize, playerXName, playerOName);

    }

    private void helloMessage() {
        final String helloMessage = "Hello everybody!!! Now we will play in game \"XO\"";
        System.out.println(helloMessage);
    }

    private int fieldSizeCreate() {
        final int fieldSize;
        final String enterMessage = "Enter size of the game field: ";

        System.out.print(enterMessage);

        try {
            fieldSize = new Scanner(System.in).nextInt();
            sizeCheck(fieldSize);
        } catch (InputMismatchException e) {
            final String errorMessage = String.format("Invalid performance of field size! Size is number from %d to %d", MIN, MAX);
            System.out.println(errorMessage);
            return fieldSizeCreate();
        } catch (FieldSizeException e) {
            final String errorMessage = String.format("Invalid size of field! Enter value from %d to %d", MIN, MAX);
            System.out.println(errorMessage);
            return fieldSizeCreate();
        }

        return fieldSize;
    }

    private void sizeCheck(final int fieldSize) throws FieldSizeException {
        if (fieldSize < MIN || fieldSize > MAX) {
            throw new FieldSizeException();
        }
    }

    private String playerXCreate() {
        final String enterMessage = "Enter name for player, who will play figure X: ";
        System.out.print(enterMessage);
        return new Scanner(System.in).nextLine();
    }

    private String playerOCreate() {
        final String enterMessage = "Enter name for player, who will play figure O: ";
        System.out.print(enterMessage);
        return new Scanner(System.in).nextLine();

    }

}
