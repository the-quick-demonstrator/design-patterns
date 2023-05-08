package com.github.curriculeon;

import java.io.File;
import java.io.IOException;

public enum DirectoryReference {
    RESOURCES("/src/main/resources");

    private final String directoryPath;

    DirectoryReference(String localDirectoryPath) {
        final String currentProjectDirectory = System.getProperty("user.dir");
        this.directoryPath = currentProjectDirectory + localDirectoryPath;
    }

    public File getFile(String fileName) {
        final File file = new File(this.directoryPath + fileName);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

    public ReadWriteFacade getReadWriteFacade(String fileName) {
        return new ReadWriteFacade(getFile(fileName));
    }
}
