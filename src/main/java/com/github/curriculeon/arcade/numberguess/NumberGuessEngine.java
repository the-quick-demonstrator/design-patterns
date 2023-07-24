package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.InputOutputFacade;
import com.github.curriculeon.utils.InputOutputSocket;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessEngine implements InputOutputSocket {
    public Integer play(NumberGuessPlayer player) {
        Integer numberOfGuesses = 0;
        final InputOutputFacade io = getInputOutputFacade(AnsiColor.BLUE);
        final int minInt = player.getMinimum();
        final int maxInt = player.getMaximum();
        final Integer randomValue = ThreadLocalRandom.current().nextInt(minInt, maxInt);
        while (true) {
            final Integer guessInt = player.getGuess(minInt, maxInt);
            numberOfGuesses++;
            if (guessInt > randomValue) {
                io.println("Guess a lower value");
            } else if (guessInt < randomValue) {
                io.println("Guess a higher value");
            } else {
                io.println("You guessed the correct value");
                break;
            }
        }
        return numberOfGuesses;
    }
}
