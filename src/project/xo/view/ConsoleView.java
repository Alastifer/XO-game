package project.xo.view;

import project.xo.controller.CurrentMoveController;
import project.xo.controller.InputCoordinateController;
import project.xo.controller.MoveController;
import project.xo.controller.WinnerController;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.controller.exceptions.InvalidPointException;
import project.xo.model.*;

import java.io.IOException;
import java.util.InputMismatchException;

public class ConsoleView {

    public boolean gameView(final Game game) throws IOException, InterruptedException {

        Field field = game.getField();
        String gameName = game.getGameName();
        Player playerX = game.getPlayerX();
        Player playerO = game.getPlayerO();


        gameNameView(gameName);
        playersView(playerX, playerO);
        fieldView(field);
        Figure currentFigure = currentFigure(field, gameName);

        if (currentFigure == null) {
            return false;
        }

        Player currentPlayer = currentFigure == Figure.X ? playerX : playerO;
        Point point = coordinate(field.getSize(), currentPlayer);

        setFig(currentPlayer, point, field);

        clearConsole();

        boolean winFlag = winnerView(field, currentPlayer, gameName);

        if (winFlag) {
            return false;
        }

        return true;
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

    private boolean winnerView(final Field field, final Player currentPlayer, final String gameName) {
        WinnerController winnerController = new WinnerController();
        Figure winFigure = winnerController.getWinner(field);

        if (winFigure != null) {
            gameNameView(gameName);
            fieldView(field);
            System.out.printf("\n%s, you are WIN!!!\n\n", currentPlayer.getName());
            return true;
        }

        return false;

    }

    private void setFig(final Player currentPlayer, final Point point, final Field field) {
        MoveController moveController = new MoveController();

        try {
            moveController.applyFigure(field, point, currentPlayer.getPlayerFigure());
        } catch (AlreadyOccupiedException e) {
            System.out.println("Already occupied point!");
            Point newPoint = coordinate(field.getSize(), currentPlayer);
            setFig(currentPlayer, newPoint, field);
        }
    }

    private Figure currentFigure(final Field field, final String gameName) throws IOException, InterruptedException {
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure figure = currentMoveController.currentMove(field);

        if (figure == null) {
            clearConsole();
            gameNameView(gameName);
            fieldView(field);
            System.out.printf("NO WINNER!!!!\n\n");
            return null;
        }

        return figure;
    }

    private Point coordinate(final int fieldSize, final Player player) {
        InputCoordinateController inputCoordinateController = new InputCoordinateController();
        System.out.printf("%s, please enter the coordinate for figure %s\n", player.getName(), player.getPlayerFigure());
        int x, y;

        try {
            System.out.print("x: ");
            x = inputCoordinateController.enterCoordinate(fieldSize) - 1;
            System.out.print("y: ");
            y = inputCoordinateController.enterCoordinate(fieldSize) - 1;
        } catch (InvalidPointException e) {
            System.out.printf("Invalid coordinate! Range of values for your field is 1 - %d\n", fieldSize);
            return coordinate(fieldSize, player);
        } catch (InputMismatchException e) {
            System.out.printf("Invalid performance of coordinate! Coordinate is number from 1 to %d\n", fieldSize);
            return coordinate(fieldSize, player);
        }

        return new Point(x, y);
    }

    private void gameNameView(final String gameName) {
        System.out.println(gameName);
        System.out.println();
    }

    private void playersView(final Player playerX, final Player playerO) {
        playerView(playerX);
        playerView(playerO);
        System.out.println();
    }

    private void playerView(final Player player) {
        System.out.printf("Player %s is %s\n", player.getName(), player.getPlayerFigure());
    }

    private void fieldView(final Field field) {
        int fieldSize = field.getSize();
        Figure figure;
        String delimiter = "|";

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                figure = field.getFigure(new Point(j, i));
                System.out.print(" " + (figure == null ? " " : figure)  + " ");

                if (j < fieldSize - 1) {
                    System.out.print(delimiter);
                }
            }

            if (i < fieldSize - 1) {
                fieldLine(fieldSize);
            }
        }

        System.out.printf("\n\n");

    }

    private void fieldLine(final int fieldSize) {
        String line = "-";
        int numOfLine = fieldSize * 3 + (fieldSize - 1);

        System.out.println();

        for (int i = 0; i < numOfLine; i++) {
            System.out.print(line);
        }

        System.out.println();
    }

}
