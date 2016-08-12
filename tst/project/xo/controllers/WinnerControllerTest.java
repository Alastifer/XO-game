package project.xo.controllers;

import org.junit.Test;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

import java.util.Random;

import static org.junit.Assert.*;

public class WinnerControllerTest {
    @Test
    public void getWinner() throws Exception {
        Field field = new Field(3);

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                field.setFigure(choice(), new Point(j, i));
                System.out.print(field.getFigure(new Point(j, i)) + " ");
            }

            System.out.println();
        }

        /*field.setFigure(Figure.X, new Point(0, 0));
        field.setFigure(Figure.O, new Point(1, 0));
        field.setFigure(Figure.O, new Point(2, 0));

        field.setFigure(Figure.X, new Point(0, 1));
        field.setFigure(Figure.O, new Point(1, 1));
        field.setFigure(Figure.X, new Point(2, 1));

        field.setFigure(Figure.O, new Point(0, 2));
        field.setFigure(Figure.X, new Point(1, 2));
        field.setFigure(Figure.O, new Point(2, 2));

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                System.out.print(field.getFigure(new Point(j, i)) + " ");
            }

            System.out.println();
        }*/

        WinnerController winnerController = new WinnerController();

        System.out.println(winnerController.getWinner(field));

    }

    private Figure choice() {
        int randInt = new Random().nextInt(2);

        if (randInt == 1) {
            return Figure.X;
        } else {
            return  Figure.O;
        }
    }

}