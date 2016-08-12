package project.xo.controllers;

import project.xo.controllers.exceptions.InvalidPointException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class WinnerController {

    public Figure getWinner(final Field field) {
        final int fieldSize = field.getSize();

        //column
        for (int i = 0; i < fieldSize; i++) {
            if (checkWinner(field, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1))) {
                return field.getFigure(new Point(i, 0));
            }
        }

        //row
        for (int i = 0; i < fieldSize; i++) {
            if (checkWinner(field, new Point(0, i), p -> new Point(p.getX() + 1, p.getY()))) {
                return field.getFigure(new Point(0, i));
            }
        }

        //main diagonal
        if (checkWinner(field, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1))) {
            return field.getFigure(new Point(0, 0));
        }

        //diagonal
        if (checkWinner(field, new Point(0, fieldSize - 1), p -> new Point(p.getX() + 1, p.getY() - 1))) {
            return field.getFigure(new Point(0, fieldSize - 1));
        }

        return null;
    }

    private boolean checkWinner(final Field field, final Point nowPoint, final IPointGenerator pointGenerator){
        final Figure nowFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.nextPoint(nowPoint);

        try {
            invalidPoint(nextPoint, field);
        } catch (InvalidPointException e) {
            return true;
        }

        nowFigure = field.getFigure(nowPoint);

        if (nowFigure == null) {
            return false;
        }

        nextFigure = field.getFigure(nextPoint);

        if (nowFigure != nextFigure) {
            return false;
        }

        return checkWinner(field, nextPoint, pointGenerator);
    }

    private void invalidPoint(final Point point, final Field field) throws InvalidPointException{
        final int fieldSize = field.getSize();

        if (!checkXOrY(point.getX(), fieldSize) || !checkXOrY(point.getY(), fieldSize)) {
            throw new InvalidPointException();
        }
    }

    private boolean checkXOrY(final int cor, final int fieldSize) {
        if (cor < 0 || cor >= fieldSize) {
            return false;
        } else {
            return true;
        }
    }

    private interface IPointGenerator {

        Point nextPoint(final Point point);
    }

}
