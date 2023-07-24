package com.github.curriculeon.utils;

public interface InputOutputSocket {
    default InputOutputFacade getInputOutputFacade() {
        return this.getInputOutputFacade(AnsiColor.AUTO);
    }

    default InputOutputFacade getInputOutputFacade(AnsiColor color) {
        return new InputOutputFacade(color);
    }
}
