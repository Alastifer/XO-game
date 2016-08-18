package project.xo.view;

import java.io.IOException;

class ClearConsoleView {

     static void clearConsole() {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (final InterruptedException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}
