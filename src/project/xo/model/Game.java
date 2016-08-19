package project.xo.model;

public class Game {

    private final String gameName;

    private final Field field;

    private final Player playerX;

    private final Player playerO;

    private Game(final Builder builder) {
        this.gameName = builder.getGameName();
        this.field = builder.getField();
        this.playerX = builder.getPlayerX();
        this.playerO = builder.getPlayerO();
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

    public static class Builder {

        private String gameName;

        private Field field;

        private Player playerX;

        private Player playerO;

        String getGameName() {

            return gameName;
        }

        Field getField() {

            return field;
        }

        Player getPlayerX() {

            return playerX;
        }

        Player getPlayerO() {

            return playerO;
        }

        public Builder gameName(final String gameName) {
            this.gameName = gameName;
            return this;
        }

        public Builder field(final Field field) {
            this.field = field;
            return this;
        }

        public Builder playerX(final Player playerX) {
            this.playerX = playerX;
            return this;
        }

        public Builder playerO(final Player playerO) {
            this.playerO = playerO;
            return this;
        }

        public Game build() {

            return new Game(this);
        }
    }

}
