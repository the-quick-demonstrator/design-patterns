package com.github.curriculeon;

import java.util.concurrent.ThreadLocalRandom;

public class MainApplication {
    public static void main(String[] args) {
        final InputOutputFacade io = new InputOutputFacade();
        final Integer minInt = io.getIntegerInput("Enter a minimum value");
        final Integer maxInt = io.getIntegerInput("Enter a maximum value");
        final Integer randomValue = ThreadLocalRandom.current().nextInt(minInt, maxInt);
        while (true) {
            final Integer guessInt = io.getIntegerInput("Enter a guess between %s and %s", minInt, maxInt);
            if (guessInt > randomValue) {
                io.println("Guess a lower value");
            } else if (guessInt < randomValue) {
                io.println("Guess a higher value");
            } else {
                io.println("You guessed the correct value");
                break;
            }
        }
    }
}
