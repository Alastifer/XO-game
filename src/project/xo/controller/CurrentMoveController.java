package project.xo.controller;

import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        final int DIFF = 2;
        final int numberOfFigure = moveRow(field);

        if (numberOfFigure == field.getSize() * field.getSize()) {
            return null;
        } else if (numberOfFigure % DIFF == 0) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }

    private int moveRow(final Field field) {
        int numberOfFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            numberOfFigure = moveColumn(field, i, numberOfFigure);
        }

        return numberOfFigure;
    }

    private int moveColumn(final Field field, final int row, int numberOfFigure) {
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(i, row)) != null) {
                numberOfFigure++;
            }
        }

        return numberOfFigure;
    }

}
