package com.github.curriculeon;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutputFacade {
    private final InputStream in;
    private final PrintStream out;

    private final AnsiColor ansiColor;

    public InputOutputFacade() {
        this(System.in, System.out);
    }

    public InputOutputFacade(InputStream in, PrintStream out) {
        this(in, out, AnsiColor.BLACK);
    }

    public InputOutputFacade(InputStream in, PrintStream out, AnsiColor ansiColor) {
        this.in = in;
        this.out = out;
        this.ansiColor = ansiColor;
    }

    public void print(String valueToBePrinted, Object... optionalStringFormatters) {
        out.printf(this.ansiColor.getColor() + valueToBePrinted, optionalStringFormatters);
    }

    public void println(String valueToBePrinted, Object... optionalStringFormatters) {
        this.print(valueToBePrinted + "\n", optionalStringFormatters);
    }

    public String getStringInput(String prompt, Object... optionalStringFormatters) {
        final Scanner scanner = new Scanner(this.in);
        this.println(prompt, optionalStringFormatters);
        final String userInput = scanner.nextLine();
        return userInput;
    }

    public Double getDoubleInput(String prompt, Object... optionalStringFormatters) {
        final String stringInput = this.getStringInput(prompt, optionalStringFormatters);
        try {
            return Double.parseDouble(stringInput);
        } catch(NumberFormatException nfe) { // non-numeric value
            this.println("[ %s ] is an invalid input!", stringInput);
            this.println("Try inputting a numeric value!");
            return getDoubleInput(prompt, optionalStringFormatters); // prompt user again
        }
    }

    public Long getLongInput(String prompt, Object... optionalStringFormatters) {
        final String stringInput = this.getStringInput(prompt, optionalStringFormatters);
        try {
            return Long.parseLong(stringInput);
        } catch(NumberFormatException nfe) { // non-numeric value
            this.println("[ %s ] is an invalid input!", stringInput);
            this.println("Try inputting a integer value!");
            return getLongInput(prompt, optionalStringFormatters); // prompt user again
        }
    }

    public Integer getIntegerInput(String prompt, Object... optionalStringFormatters) {
        return getLongInput(prompt, optionalStringFormatters).intValue();
    }
}
