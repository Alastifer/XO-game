package project.xo.view;

import project.xo.controller.GameCreateController;
import project.xo.controller.exceptions.FieldSizeException;
import project.xo.model.Game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameCreateView {

    public Game createView() throws IOException, InterruptedException {
        clearConsole();
        helloMessage();
        int fieldSize = fieldSizeCreate();
        String playerXName = playerXCreate();
        String playerOName = playerOCreate();
        clearConsole();
        return new GameCreateController().gameCreate(fieldSize, playerXName, playerOName);

    }

    private void clearConsole() throws IOException, InterruptedException {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
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
