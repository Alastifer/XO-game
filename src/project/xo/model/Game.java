package project.xo.model;

public class Game {

    private final String gameName;

    private final Field field;

    private final Player playerX;

    private final Player playerO;

    public Game(final String gameName, final Field field, final Player playerX, final Player playerO) {
        this.gameName = gameName;
        this.field = field;
        this.playerX = playerX;
        this.playerO = playerO;
    }

    public String getGameName() {

        return gameName;
    }

    public Field getField() {

        return field;
    }

    public Player getPlayerX() {

        return playerX;
    }

    public Player getPlayerO() {

        return playerO;
    }

}
