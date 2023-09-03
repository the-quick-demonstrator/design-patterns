package com.github.curriculeon;

public enum AnsiCode {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    PURPLE(35),
    CYAN(36),
    WHITE(37);

    private final String value;

    AnsiCode(Integer ansiNumber) {
        this.value = "\u001B[" + ansiNumber + "m";
    }

    public String getValue() {
        return value;
    }
}
