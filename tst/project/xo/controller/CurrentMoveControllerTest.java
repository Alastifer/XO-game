package project.xo.controller;

import org.junit.Test;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMove() throws Exception {

        int numF;

        final int DIFF = 2;
        final int LOOP = 1_000_000;

        for (int k = 0; k < LOOP; k++) {
            numF = 0;

            final Field field = new Field(3);
            boolean flag = true;
            for (int i = 0; i < choice(field); i++) {
                for (int j = 0; j < choice(field); j++) {
                    if (flag) {
                        field.setFigure(Figure.X, new Point(j, i));
                        flag = false;
                        numF++;
                    } else {
                        field.setFigure(Figure.O, new Point(j, i));
                        flag = true;
                        numF++;
                    }
                }
            }

            final CurrentMoveController currentMoveController = new CurrentMoveController();

            final Figure trueFigure = numF % DIFF == 0 ? Figure.X : Figure.O;

            assertEquals(trueFigure, currentMoveController.currentMove(field));
        }
    }

    private int choice(final Field field) {

        return new Random().nextInt(field.getSize() - 1) + 1 ;
    }

}