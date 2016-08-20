package project.xo.view;

import project.xo.controller.CurrentMoveController;
import project.xo.controller.InputCoordinateController;
import project.xo.controller.MoveController;
import project.xo.controller.WinnerController;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.controller.exceptions.InvalidPointException;
import project.xo.model.*;

import java.util.InputMismatchException;

public class ConsoleView {

    public boolean gameView(final Game game) {

        final Field field = game.getField();
        final String gameName = game.getGameName();
        final Player playerX = game.getPlayerX();
        final Player playerO = game.getPlayerO();


        gameNameView(gameName);
        playersView(playerX, playerO);
        fieldView(field);
        final Figure currentFigure = currentFigure(field, gameName);

        if (currentFigure == null) {
            return false;
        }

        final Player currentPlayer = currentFigure == Figure.X ? playerX : playerO;
        final Point point = coordinate(field.getSize(), currentPlayer);

        setFig(currentPlayer, point, field);

        ClearConsoleView.clearConsole();

        return !winnerView(field, currentPlayer, gameName);
    }

    private boolean winnerView(final Field field, final Player currentPlayer, final String gameName) {
        final WinnerController winnerController = new WinnerController();
        final Figure winFigure = winnerController.getWinner(field);

        if (winFigure != null) {
            final String winMessage = String.format("\n%s, you are WIN!!!\n", currentPlayer.getName());
            gameNameView(gameName);
            fieldView(field);
            System.out.println(winMessage);
            return true;
        }

        return false;

    }

    private void setFig(final Player currentPlayer, final Point point, final Field field) {
        final MoveController moveController = new MoveController();

        try {
            moveController.applyFigure(field, point, currentPlayer.getPlayerFigure());
        } catch (final AlreadyOccupiedException e) {
            final String errorMessage = "Already occupied point!";
            System.out.println(errorMessage);
            final Point newPoint = coordinate(field.getSize(), currentPlayer);
            setFig(currentPlayer, newPoint, field);
        }
    }

    private Figure currentFigure(final Field field, final String gameName) {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Figure figure = currentMoveController.currentMove(field);

        if (figure == null) {
            final String noWinnerMessage = "NO WINNER!!!!\n";
            ClearConsoleView.clearConsole();
            gameNameView(gameName);
            fieldView(field);
            System.out.println(noWinnerMessage);
            return null;
        }

        return figure;
    }

    private Point coordinate(final int fieldSize, final Player player) {
        final int x, y;
        final String enterMessage = String.format("%s, please enter the coordinate for figure %s", player.getName(), player.getPlayerFigure());

        InputCoordinateController inputCoordinateController = new InputCoordinateController();
        System.out.println(enterMessage);

        try {
            System.out.print("x: ");
            x = inputCoordinateController.enterCoordinate(fieldSize) - 1;
            System.out.print("y: ");
            y = inputCoordinateController.enterCoordinate(fieldSize) - 1;
        } catch (final InvalidPointException e) {
            final String errorMessage = String.format("Invalid coordinate! Range of values for your field is 1 - %d", fieldSize);
            System.out.println(errorMessage);
            return coordinate(fieldSize, player);
        } catch (final InputMismatchException e) {
            final String errorMessage = String.format("Invalid performance of coordinate! Coordinate is number from 1 to %d", fieldSize);
            System.out.println(errorMessage);
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
        final String playerMessage = String.format("Player %s is %s", player.getName(), player.getPlayerFigure());
        System.out.println(playerMessage);
    }

    private void fieldView(final Field field) {
        final int fieldSize = field.getSize();
        Figure figure;
        final String delimiter = "|";
        final String noFigure = " ";

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                figure = field.getFigure(new Point(j, i));
                System.out.print(noFigure + (figure == null ? noFigure : figure)  + noFigure);

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
        final String line = "-";
        final int numOfLine = fieldSize * 3 + (fieldSize - 1);

        System.out.println();

        for (int i = 0; i < numOfLine; i++) {
            System.out.print(line);
        }

        System.out.println();
    }

}
