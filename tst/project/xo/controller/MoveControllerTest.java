package project.xo.controller;

import org.junit.Test;
import project.xo.controller.exceptions.AlreadyOccupiedException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

import static org.junit.Assert.*;

public class MoveControllerTest {

    private int fieldSize;

    @Test
    public void applyFigure() throws Exception {
        final MoveController moveController = new MoveController();
        final int LOOP = 10000;

        for (int i = 0; i < LOOP; i++) {
            fieldSize = 10;
            final Field field = new Field(fieldSize);
            final Point point = new Point(randPoint(), randPoint());
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

    private int randPoint() {
        return new Random().nextInt(fieldSize);
    }

    private void initField(final Field field) {
        final CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < rand(); i++) {
            for (int j = 0; j < rand(); j++) {
                field.setFigure(currentMoveController.currentMove(field), new Point(j, i));
            }
        }
    }

    private int rand() {
        return new Random().nextInt(fieldSize - 1) + 1;
    }

}