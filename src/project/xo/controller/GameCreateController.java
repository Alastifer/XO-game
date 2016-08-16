package project.xo.controller;

import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Game;
import project.xo.model.Player;

public class GameCreateController {

    public Game gameCreate(final String fieldSize, final String nameX, final String nameO) throws NumberFormatException {
        Field field = new Field(Integer.parseInt(fieldSize));
        Player playerX = new Player(nameX, Figure.X);
        Player playerO = new Player(nameO, Figure.O);
        String gameName = "XO-game";

        return new Game(gameName, field, playerX, playerO);
    }

}
