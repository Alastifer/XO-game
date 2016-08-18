import project.xo.model.Game;
import project.xo.view.ConsoleView;
import project.xo.view.GameCreateView;

import java.io.IOException;

public class XO {

    public static void main(String[] args) throws IOException, InterruptedException {
        boolean gameController = true;
        Game newGame = new GameCreateView().createView();
        
        while (gameController) {
            gameController = new ConsoleView().gameView(newGame);
        }
    }

}
