package project.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getName() throws Exception {
        String trueName = "Alex";
        Player player = new Player(trueName, null);

        assertEquals(trueName, player.getName());
    }

    @Test
    public void getPlayerFigure() throws Exception {
        Figure trueFigure = Figure.O;
        Player player = new Player(null, trueFigure);

        assertEquals(trueFigure, player.getPlayerFigure());
    }

}