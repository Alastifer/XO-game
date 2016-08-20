package project.xo.controller;

import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class CurrentMoveController {

    private int numberOfFigure = 0;

    public Figure currentMove(final Field field) {
        final int DIFF = 2;
        moveRow(field);

        if (numberOfFigure == field.getSize() * field.getSize()) {
            return null;
        } else if (numberOfFigure % DIFF == 0) {
            return Figure.X;
        } else {
            return Figure.O;
        }
    }

    private void moveRow(final Field field) {
        for (int i = 0; i < field.getSize(); i++) {
            moveColumn(field, i);
        }
    }

    private void moveColumn(final Field field, final int row) {
        for (int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(i, row)) != null) {
                numberOfFigure++;
            }
        }
    }

}
