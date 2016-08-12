package project.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void getGameName() throws Exception {
        final String trueGameName = "XO";
        final Game game = new Game(trueGameName, null, null, null);

        assertEquals(trueGameName, game.getGameName());
    }

    @Test
    public void getField() throws Exception {
        final Field trueField = new Field(4);
        final Game game = new Game(null, trueField, null, null);

        assertEquals(trueField, game.getField());
    }

    @Test
    public void getPlayerX() throws Exception {
        final Player truePlayer = new Player("Alex", Figure.X);
        final Game game = new Game(null, null, truePlayer, null);

        assertEquals(truePlayer, game.getPlayerX());
    }

    @Test
    public void getPlayerO() throws Exception {
        final Player truePlayer = new Player("Alex", Figure.O);
        final Game game = new Game(null, null, null, truePlayer);

        assertEquals(truePlayer, game.getPlayerO());
    }

}