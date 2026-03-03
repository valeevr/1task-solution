package ru.valeevr;

import ru.valeevr.model.ValidateFileResult;
import ru.valeevr.service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        FileAnalyzer analyzer = new FileAnalyzer();
        FileService fileService = new FileService();

        System.out.print("Путь к файлу: ");
        File file = new File(console.nextLine());

        ValidateFileResult validateFileResult = fileService.validateFile(file);
        if (validateFileResult instanceof ValidateFileResult.Error validateFileResultError) {
            System.err.println(validateFileResultError.message());
            return;
        }

        System.out.print("Кодировка: ");
        String encoding = console.nextLine();

        try {
            FileStatistics stats = analyzer.analyze(file, encoding);

            System.out.print("Введите слово для поиска: ");
            String target = console.nextLine();

            int foundCount = analyzer.countOccurrences(file, encoding, target);
            stats.setOccurrences(foundCount);

            System.out.println("\n" + stats);

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}