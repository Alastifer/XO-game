package project.xo.controllers;

import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) {
        if (field.getFigure(point) != null) {
            //throw exception
        }

        field.setFigure(figure, point);
    }

}
