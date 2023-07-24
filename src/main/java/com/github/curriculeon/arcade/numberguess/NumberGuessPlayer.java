package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.InputOutputSocket;

public class NumberGuessPlayer implements InputOutputSocket {
    public Integer getMinimum() {
        return getInputOutputFacade().getIntegerInput("Enter a minimum value");
    }

    public Integer getMaximum() {
        return getInputOutputFacade().getIntegerInput("Enter a maximum value");
    }

    public Integer getGuess(int min, int max) {
        return getInputOutputFacade().getIntegerInput("Enter a guess between %s and %s", min, max);
    }
}
