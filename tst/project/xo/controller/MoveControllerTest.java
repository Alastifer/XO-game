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
        final MoveController moveController = new MoveController();
        final int LOOP = 10000;

        for (int i = 0; i < LOOP; i++) {
            final int fieldSize = 10;
            final Field field = new Field(fieldSize);
            final Point point = new Point(randPoint(fieldSize), randPoint(fieldSize));
            final Figure trueFigure = Figure.X;

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
        final int fieldSize = field.getSize();
        final CurrentMoveController currentMoveController = new CurrentMoveController();

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