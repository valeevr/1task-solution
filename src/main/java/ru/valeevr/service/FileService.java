package ru.valeevr.service;

import ru.valeevr.model.ValidateFileResult;

import java.io.File;

public class FileService {
    public ValidateFileResult validateFile(File file) {
        if (!file.exists()) {
            return new ValidateFileResult.Error("Файл не найден.");
        }
        if (!file.isFile()) {
            return new ValidateFileResult.Error("Это не файл, а директория.");
        }
        return new ValidateFileResult.Valid();
    }
}
