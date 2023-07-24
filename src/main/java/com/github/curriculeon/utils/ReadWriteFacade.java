package com.github.curriculeon.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFacade {
    private final File file;

    public ReadWriteFacade(String fileName) {
        this(new File(fileName));
    }

    public ReadWriteFacade(File file) {
        this.file = file;
    }

    public void write(String content, boolean append) {
        final FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file, append);
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read() {
        final StringBuilder contents = new StringBuilder();
        try {
            final Scanner scanner = new Scanner(this.file);
            while (scanner.hasNextLine()) {
                final String currentLine = scanner.nextLine();
                contents.append(currentLine);
                contents.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contents.toString();
    }

    public List<String> toLines() {
        return Arrays.asList(read().split("\n"));
    }

    public String read(int lineNumber) {
        return toLines().get(lineNumber);
    }

    public void replaceLine(int lineNumber, String contentToBeWritten) {
        final StringBuilder result = new StringBuilder();
        final List<String> lines = this.toLines();
        lines.set(lineNumber, contentToBeWritten);
        lines.forEach(line -> result.append(line).append("\n"));
        this.write(result.toString().replaceAll("$\n", ""), false);
    }

    public void replaceAllOccurrences(String stringToReplace, String replacementString) {
        final String contentToWrite = read().replaceAll(stringToReplace, replacementString);
        this.write(contentToWrite, false);
    }
}
