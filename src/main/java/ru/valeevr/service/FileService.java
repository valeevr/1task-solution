package ru.valeevr.service;

import java.io.File;

public class FileService {
    public boolean validateFile(File file) {
        if (!file.exists()) {
            System.err.println("Файл не найден.");
            return false;
        }
        if (!file.isFile()) {
            System.err.println("Это не файл, а директория.");
            return false;
        }
        return true;
    }
}
