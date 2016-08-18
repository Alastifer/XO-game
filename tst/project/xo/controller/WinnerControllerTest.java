package project.xo.controller;

import org.junit.Test;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

public class WinnerControllerTest {
    @Test
    public void getWinner() throws Exception {
        Field field = new Field(3);
        Figure figure = choice(field);
        Random random = new Random();
        WinnerController winnerController = new WinnerController();
        Figure winFigure;
        int x, y;
        int fieldSize = field.getSize();

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
                fieldView(field);
                System.out.printf("\nWinner is figure: %s\n", winFigure);
                return;
            }
        }

        fieldView(field);
        System.out.printf("\nNO WINNER!\n");



    }

    private void fieldView(final Field field) {
        int fieldSize = field.getSize();
        Figure figure;
        String delimiter = "|";

        System.out.println();

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

    private Figure choice(final Field field) {

        return new CurrentMoveController().currentMove(field);
    }

}