package project.xo.model;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void getX() throws Exception {
        Random random = new Random();
        final int trueX = random.nextInt();
        Point point = new Point(trueX, 0);

        assertEquals(trueX, point.getX());

    }

    @Test
    public void getY() throws Exception {
        Random random = new Random();
        final int trueY = random.nextInt();
        Point point = new Point(0, trueY);

        assertEquals(trueY, point.getY());
    }

}