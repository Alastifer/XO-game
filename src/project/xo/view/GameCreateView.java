package project.xo.view;

import project.xo.controller.GameCreateController;
import project.xo.controller.exceptions.FieldSizeException;
import project.xo.model.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameCreateView {

    public Game createView() {
        helloMessage();
        int fieldSize = fieldSizeCreate();
        String playerXName = playerXCreate();
        String playerOName = playerOCreate();
        System.out.printf("\n\n");
        return new GameCreateController().gameCreate(fieldSize, playerXName, playerOName);

    }

    private void helloMessage() {
        System.out.println("Hello everybody!!! Now we will play in game \"XO\"");
    }

    private int fieldSizeCreate() {
        int fieldSize;

        System.out.print("Enter size of the game field: ");

        try {
            fieldSize = new Scanner(System.in).nextInt();
            sizeCheck(fieldSize);
        } catch (InputMismatchException e) {
            System.out.println("Invalid performance of field size! Size is number from 3 to 10");
            return fieldSizeCreate();
        } catch (FieldSizeException e) {
            System.out.println("Invalid size of field! Enter value from 3 to 10");
            return fieldSizeCreate();
        }

        return fieldSize;
    }

    private void sizeCheck(final int fieldSize) throws FieldSizeException {
        if (fieldSize < 3 || fieldSize > 10) {
            throw new FieldSizeException();
        }
    }

    private String playerXCreate() {
        System.out.print("Enter name for player, who will play figure X: ");
        return new Scanner(System.in).nextLine();
    }

    private String playerOCreate() {
        System.out.print("Enter name for player, who will play figure O: ");
        return new Scanner(System.in).nextLine();

    }

}
