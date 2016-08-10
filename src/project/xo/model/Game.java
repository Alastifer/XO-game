package project.xo.model;

public class Game {

    private final String gameName;

    private final Field field;

    private final Player playerX;

    private final Player playerY;

    public Game(final String gameName, final Field field, final Player playerX, final Player playerY) {
        this.gameName = gameName;
        this.field = field;
        this.playerX = playerX;
        this.playerY = playerY;
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

    public Player getPlayerY() {
        return playerY;
    }

}
