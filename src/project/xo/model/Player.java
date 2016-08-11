package project.xo.model;

public class Player {

    private final String name;

    private final Figure playerFigure;

    public Player(final String name, final Figure playerFigure) {
        this.name = name;
        this.playerFigure = playerFigure;
    }

    public String getName() {

        return name;
    }

    public Figure getPlayerFigure() {

        return playerFigure;
    }
}
