package project.xo.view;

import project.xo.controller.exceptions.MenuOptionException;
import project.xo.model.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private final int minOption = 1;
    private final int maxOption = Options.values().length;

    public void menu() {
        ClearConsoleView.clearConsole();

        helloMessage();

        final int option = menuOption();
        switch (option) {
            case 1:
                chooseOption(Options.NEW_GAME);
                break;

            case 2:
                chooseOption(Options.EXIT);
                break;
        }
    }

    private void helloMessage() {
        final String helloMessage = "Hello everybody!!! Now we will play in game \"XO\"";
        System.out.println(helloMessage);
    }

    private void chooseOption(final Options option) {
        switch (option) {
            case NEW_GAME:
                boolean gameController = true;
                final Game newGame = new GameCreateView().createView();
                while (gameController) {
                    gameController = new ConsoleView().gameView(newGame);
                }
                break;

            case EXIT:
                break;
        }
    }

    private int menuOption() {
        final int value;

        chooseView();
        final String enterMessage = "\nChoose your option: ";
        System.out.print(enterMessage);

        try {
            value = new Scanner(System.in).nextInt();
            checkOption(value);
        } catch (InputMismatchException e) {
            ClearConsoleView.clearConsole();
            final String errorMessage = String.format("Invalid performance of menu option! Option is number from %d to %d\n", minOption, maxOption);
            System.out.println(errorMessage);
            return menuOption();
        } catch (MenuOptionException e) {
            ClearConsoleView.clearConsole();
            final String errorMessage = String.format("Invalid menu option! Enter value from %d to %d\n", minOption, maxOption);
            System.out.println(errorMessage);
            return menuOption();
        }

        return value;
    }

    private void chooseView() {
        final String[] choose = {"New game", "Exit"};
        int index = minOption;

        for (String out : choose) {
            System.out.printf("%d. %s\n", index++, out);
        }
    }

    private void checkOption(final int value) throws MenuOptionException{
        if (value < minOption || value > maxOption) {
            throw new MenuOptionException();
        }
    }

    private enum Options {
        NEW_GAME, EXIT
    }

}
