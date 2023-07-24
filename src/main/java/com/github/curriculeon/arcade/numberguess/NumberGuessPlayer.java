package com.github.curriculeon.arcade.numberguess;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.InputOutputFacade;
import com.github.curriculeon.utils.InputOutputSocket;

public class NumberGuessPlayer implements InputOutputSocket {
    @Override
    public InputOutputFacade getInputOutputFacade() {
        return InputOutputSocket.super.getInputOutputFacade(AnsiColor.CYAN);
    }

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
