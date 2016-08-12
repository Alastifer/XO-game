package project.xo.model;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void getX() throws Exception {
        final int trueX = new Random().nextInt();
        final Point point = new Point(trueX, 0);

        assertEquals(trueX, point.getX());

    }

    @Test
    public void getY() throws Exception {
        final int trueY = new Random().nextInt();
        final Point point = new Point(0, trueY);

        assertEquals(trueY, point.getY());
    }

}