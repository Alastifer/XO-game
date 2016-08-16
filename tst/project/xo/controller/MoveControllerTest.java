package project.xo.controller;

import org.junit.Test;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

import static org.junit.Assert.*;

public class MoveControllerTest {
    @Test
    public void applyFigure() throws Exception {
        MoveController moveController = new MoveController();

        for (int i = 0; i < 10000; i++) {
            int fieldSize = 10;
            Field field = new Field(fieldSize);
            Point point = new Point(randPoint(fieldSize), randPoint(fieldSize));
            Figure trueFigure = Figure.X;

            initField(field);

            try {
                moveController.applyFigure(field, point, trueFigure);
            } catch (AlreadyOccupiedException e) {
                continue;
            }

            assertEquals(trueFigure, field.getFigure(point));
        }
    }

    private int randPoint(final int fieldSize) {

        return new Random().nextInt(fieldSize);
    }

    private void initField(final Field field) {
        int fieldSize = field.getSize();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < rand(fieldSize); i++) {
            for (int j = 0; j < rand(fieldSize); j++) {
                field.setFigure(currentMoveController.currentMove(field), new Point(j, i));
            }
        }
    }

    private int rand(final int fieldSize) {

        return new Random().nextInt(fieldSize - 1) + 1;
    }

}