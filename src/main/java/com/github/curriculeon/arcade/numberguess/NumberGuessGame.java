package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.DirectoryReference;
import com.github.curriculeon.utils.InputOutputSocket;
import com.github.curriculeon.utils.ReadWriteFacade;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class NumberGuessGame implements InputOutputSocket {
    private final NumberGuessEngine numberGuessEngine;
    private final List<NumberGuessPlayer> players;

    public NumberGuessGame(NumberGuessPlayer... players) {
        this(new NumberGuessEngine(), players);
    }

    public NumberGuessGame(NumberGuessEngine numberGuessEngine, NumberGuessPlayer... players) {
        this(numberGuessEngine, Arrays.asList(players));
    }

    public NumberGuessGame(NumberGuessEngine numberGuessEngine, List<NumberGuessPlayer> players) {
        this.numberGuessEngine = numberGuessEngine;
        this.players = players;
    }

    public void play() {
        for (NumberGuessPlayer player : players) {
            Integer numberOfGuesses = numberGuessEngine.play(player);
            getInputOutputFacade(AnsiColor.PURPLE).println("Number of Guesses: %s", numberOfGuesses);

            final File file = DirectoryReference.RESOURCES.getFile("/guesses.txt");
            final ReadWriteFacade rw = new ReadWriteFacade(file);
            rw.write(numberOfGuesses.toString(), false);
        }
    }
}
