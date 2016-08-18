// Copyright 2016 Alexandr
// Licensed under the Apache License, Version 2.0

import project.xo.model.Game;
import project.xo.view.ConsoleView;
import project.xo.view.GameCreateView;

public class XO {

    public static void main(String[] args) {
        boolean gameController = true;
        Game newGame = new GameCreateView().createView();
        
        while (gameController) {
            gameController = new ConsoleView().gameView(newGame);
        }
    }

}
