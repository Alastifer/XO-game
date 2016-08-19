package project.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void getGameName() throws Exception {
        final String trueGameName = "XO";
        final Game game = new Game.Builder()
                .gameName(trueGameName)
                .field(null)
                .playerX(null)
                .playerO(null)
                .build();

        assertEquals(trueGameName, game.getGameName());
    }

    @Test
    public void getField() throws Exception {
        final Field trueField = new Field(4);
        final Game game = new Game.Builder()
                .gameName(null)
                .field(trueField)
                .playerX(null)
                .playerO(null)
                .build();

        assertEquals(trueField, game.getField());
    }

    @Test
    public void getPlayerX() throws Exception {
        final Player truePlayer = new Player("Alex", Figure.X);
        final Game game = new Game.Builder()
                .gameName(null)
                .field(null)
                .playerX(truePlayer)
                .playerO(null)
                .build();

        assertEquals(truePlayer, game.getPlayerX());
    }

    @Test
    public void getPlayerO() throws Exception {
        final Player truePlayer = new Player("Alex", Figure.O);
        final Game game = new Game.Builder()
                .gameName(null)
                .field(null)
                .playerX(null)
                .playerO(truePlayer)
                .build();

        assertEquals(truePlayer, game.getPlayerO());
    }

}