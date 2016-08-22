package project.xo.view;

import project.xo.controller.exceptions.FieldSizeException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Game;
import project.xo.model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameCreateView {

    private final int MIN = 3;
    private final int MAX = 10;

    public Game createView() {
        ClearConsoleView.clearConsole();
        helloMessage();
        final String gameName = "XO-game";
        final Field field = fieldCreate();
        final Player playerX = playerXCreate();
        final Player playerO = playerOCreate();
        ClearConsoleView.clearConsole();
        return new Game.Builder()
                .gameName(gameName)
                .field(field)
                .playerX(playerX)
                .playerO(playerO)
                .build();
    }

    private void helloMessage() {
        final String helloMessage = "Hello everybody!!! Now we will play in game \"XO\"";
        System.out.println(helloMessage);
    }

    private Field fieldCreate() {
        final int fieldSize;
        final String enterMessage = "Enter size of the game field: ";

        System.out.print(enterMessage);

        try {
            fieldSize = new Scanner(System.in).nextInt();
            sizeCheck(fieldSize);
        } catch (InputMismatchException e) {
            final String errorMessage = String.format("Invalid performance of field size! Size is number from %d to %d", MIN, MAX);
            System.out.println(errorMessage);
            return fieldCreate();
        } catch (FieldSizeException e) {
            final String errorMessage = String.format("Invalid size of field! Enter value from %d to %d", MIN, MAX);
            System.out.println(errorMessage);
            return fieldCreate();
        }

        return new Field(fieldSize);
    }

    private void sizeCheck(final int fieldSize) throws FieldSizeException {
        if (fieldSize < MIN || fieldSize > MAX) {
            throw new FieldSizeException();
        }
    }

    private Player playerXCreate() {
        final String enterMessage = "Enter name for player, who will play figure X: ";
        System.out.print(enterMessage);
        final String name = new Scanner(System.in).nextLine();
        return new Player(name, Figure.X);
    }

    private Player playerOCreate() {
        final String enterMessage = "Enter name for player, who will play figure O: ";
        System.out.print(enterMessage);
        final String name = new Scanner(System.in).nextLine();
        return new Player(name, Figure.O);
    }

}
