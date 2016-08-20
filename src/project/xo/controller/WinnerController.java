package project.xo.controller;

import project.xo.controller.exceptions.InvalidPointException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class WinnerController {

    private int fieldSize;

    public Figure getWinner(final Field field) {
        fieldSize = field.getSize();

        final int START = 0;
        final int FINISH = fieldSize - 1;
        final int OFFSET = 1;

        //column
        for (int i = 0; i < fieldSize; i++) {
            if (checkWinner(field, new Point(i, START), p -> new Point(p.getX(), p.getY() + OFFSET))) {
                return field.getFigure(new Point(i, START));
            }
        }

        //row
        for (int i = 0; i < fieldSize; i++) {
            if (checkWinner(field, new Point(START, i), p -> new Point(p.getX() + OFFSET, p.getY()))) {
                return field.getFigure(new Point(START, i));
            }
        }

        //main diagonal
        if (checkWinner(field, new Point(START, START), p -> new Point(p.getX() + OFFSET, p.getY() + OFFSET))) {
            return field.getFigure(new Point(START, START));
        }

        //diagonal
        if (checkWinner(field, new Point(START, FINISH), p -> new Point(p.getX() + OFFSET, p.getY() - OFFSET))) {
            return field.getFigure(new Point(START, FINISH));
        }

        return null;
    }

    private boolean checkWinner(final Field field, final Point nowPoint, final IPointGenerator pointGenerator){
        final Figure nowFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.nextPoint(nowPoint);

        try {
            invalidPoint(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        nowFigure = field.getFigure(nowPoint);

        if (nowFigure == null) {
            return false;
        }

        nextFigure = field.getFigure(nextPoint);

        return nowFigure == nextFigure && checkWinner(field, nextPoint, pointGenerator);
    }

    private void invalidPoint(final Point point) throws InvalidPointException{
        if (!checkXOrY(point.getX()) || !checkXOrY(point.getY())) {
            throw new InvalidPointException();
        }
    }

    private boolean checkXOrY(final int cor) {
        final int MIN = 0;

        return !(cor < MIN || cor >= fieldSize);
    }

    private interface IPointGenerator {

        Point nextPoint(final Point point);
    }

}
