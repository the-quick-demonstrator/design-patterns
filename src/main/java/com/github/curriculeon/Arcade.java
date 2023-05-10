package com.github.curriculeon;

import java.util.Locale;

public class Arcade {
    public void run() {
        final InputOutputFacade io = new InputOutputFacade();
        String userInput;
        do {
            io.println("Welcome to the Arcade Simulation!");
            io.println("From here you can select any of the following options");
            userInput = io.getStringInput("[ login ], [ manage-account ], [ quit ]").toLowerCase(Locale.ROOT);
            if ("login".equals(userInput)) {
                final AccountEntity account = AccountServiceCommand.READ.perform().get(0);
                GuessGamePlayer guessGamePlayer = GuessGamePlayerServiceCommand.getUserInput().perform(account).get(0);
                new GuessGame(guessGamePlayer).play();
            } else if ("manage-account".equals(userInput)) {
                AccountServiceCommand.getUserInput().perform();
            } else {
                io.println("[ %s ] is not a valid userinput!", userInput);
            }
        } while (!"quit".equals(userInput));

    }
}
