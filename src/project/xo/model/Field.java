package project.xo.model;

public class Field {

    private final int size = 3;

    private Figure[][] points = new Figure[size][size];

    public int getSize() {
        return size;
    }

    public Figure getFigure(final Point point) {
        return points[point.getX()][point.getY()];
    }

    public void setFigure(final Figure figure, final Point point) {
        points[point.getX()][point.getY()] = figure;
    }

}
