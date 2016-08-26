package project.xo.controller;

import org.junit.Test;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

public class WinnerControllerTest {

    private int fieldSize;

    @Test
    public void getWinner() throws Exception {
        final Field field = new Field(3);
        final Random random = new Random();
        final WinnerController winnerController = new WinnerController();
        int x, y;
        Figure winFigure;
        Figure figure = choice(field);

        fieldSize = field.getSize();

        while (figure != null) {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);

            try {
                new MoveController().applyFigure(field, new Point(x, y), figure);
            } catch (AlreadyOccupiedException e) {
                continue;
            }

            figure = choice(field);

            winFigure = winnerController.getWinner(field);

            if (winFigure != null) {
                final String winMessage = String.format("\nWinner is figure: %s", winFigure);
                fieldView(field);
                System.out.println(winMessage);
                return;
            }
        }

        final String noWinnerMessage = "\nNO WINNER!";
        fieldView(field);
        System.out.println(noWinnerMessage);
    }

    private void fieldView(final Field field) {
        Figure figure;
        final String delimiter = "|";
        final String noFigure = " ";
        final int FINISH = fieldSize - 1;

        System.out.println();

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                figure = field.getFigure(new Point(j, i));
                System.out.print(noFigure + (figure == null ? noFigure : figure)  + noFigure);

                if (j < FINISH) {
                    System.out.print(delimiter);
                }
            }

            if (i < FINISH) {
                fieldLine();
            }
        }

        System.out.printf("\n\n");

    }

    private void fieldLine() {
        final String line = "-";
        final int numOfLine = fieldSize * 3 + (fieldSize - 1);

        System.out.println();

        for (int i = 0; i < numOfLine; i++) {
            System.out.print(line);
        }

        System.out.println();
    }

    private Figure choice(final Field field) {
        return new CurrentMoveController().currentMove(field);
    }

}