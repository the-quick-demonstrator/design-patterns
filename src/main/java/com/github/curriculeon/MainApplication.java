package com.github.curriculeon;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class MainApplication {
    public static void main(String[] args) {
        Integer numberOfGuesses = 0;
        final InputOutputFacade io = new InputOutputFacade();
        final Integer minInt = io.getIntegerInput("Enter a minimum value");
        final Integer maxInt = io.getIntegerInput("Enter a maximum value");
        final Integer randomValue = ThreadLocalRandom.current().nextInt(minInt, maxInt);
        while (true) {
            final Integer guessInt = io.getIntegerInput("Enter a guess between %s and %s", minInt, maxInt);
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
        io.println("Number of Guesses: %s", numberOfGuesses);

        final File file = DirectoryReference.RESOURCES.getFile("/guesses.txt");
        final ReadWriteFacade rw = new ReadWriteFacade(file);
        rw.write(numberOfGuesses.toString(), false);
    }
}
