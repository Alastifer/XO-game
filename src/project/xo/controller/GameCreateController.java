package project.xo.controller;

import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Game;
import project.xo.model.Player;

public class GameCreateController {

    public Game gameCreate(final int fieldSize, final String nameX, final String nameO) {
        final Field field = new Field(fieldSize);
        final Player playerX = new Player(nameX, Figure.X);
        final Player playerO = new Player(nameO, Figure.O);
        final String gameName = "XO-game";

        return new Game.Builder().gameName(gameName)
                .field(field)
                .playerX(playerX)
                .playerO(playerO)
                .build();
    }

}
