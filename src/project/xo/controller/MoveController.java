// Copyright 2016 Alexandr
// Licensed under the Apache License, Version 2.0

package project.xo.controller;

import project.xo.controller.exceptions.AlreadyOccupiedException;
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
