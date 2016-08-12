package project.xo.model;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void getSize() throws Exception {
        final int trueSize = new Random().nextInt(10000);
        final Field field = new Field(trueSize);

        assertEquals(trueSize, field.getSize());
    }

    @Test
    public void getAndSetFigure() throws Exception {
        final Field field = new Field(6);
        final int x = 4;
        final int y = 4;
        final Figure trueFigure = Figure.X;
        final Point point = new Point(x, y);
        field.setFigure(trueFigure, point);

        assertEquals(trueFigure, field.getFigure(point));
    }

}