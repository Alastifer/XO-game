package project.xo.controller;

import org.junit.Test;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Game;
import project.xo.model.Player;

import static org.junit.Assert.*;

public class GameCreateControllerTest {
    @Test
    public void gameCreate() throws Exception {
        final GameCreateController gameCreateController = new GameCreateController();

        final String nameX = "Alex";
        final String nameO = "Ira";
        final int expectedFieldSize = 3;
        final String expectedGameName = "XO-game";

        final Player expectedPlayerX = new Player(nameX, Figure.X);
        final Player expectedPlayerO = new Player(nameO, Figure.O);

        final Game actualGame = gameCreateController.gameCreate(expectedFieldSize, nameX, nameO);
        final Game expectedGame = new Game.Builder()
                .gameName(expectedGameName)
                .field(new Field(3))
                .playerX(expectedPlayerX)
                .playerO(expectedPlayerO)
                .build();

        assertEquals(expectedGame.getGameName(), actualGame.getGameName());
        assertEquals(expectedGame.getField().getSize(), actualGame.getField().getSize());
        assertEquals(expectedGame.getPlayerX().getName(), actualGame.getPlayerX().getName());
        assertEquals(expectedGame.getPlayerX().getPlayerFigure(), actualGame.getPlayerX().getPlayerFigure());
        assertEquals(expectedGame.getPlayerO().getName(), actualGame.getPlayerO().getName());
        assertEquals(expectedGame.getPlayerO().getPlayerFigure(), actualGame.getPlayerO().getPlayerFigure());

    }

}