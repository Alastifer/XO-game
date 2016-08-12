package project.xo.controllers;

import project.xo.controllers.exceptions.AlreadyOccupiedException;
import project.xo.model.Field;
import project.xo.model.Figure;
import project.xo.model.Point;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(figure, point);
    }

}
