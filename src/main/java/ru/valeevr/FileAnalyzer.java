package ru.valeevr;

import java.io.*;

public class FileAnalyzer {

    public FileStatistics analyze(File file, String encoding) throws IOException {
        int totalLines = 0;
        int nonEmptyLines = 0;
        long totalChars = 0;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), encoding))) {

            String line;
            while ((line = reader.readLine()) != null) {
                totalLines++;
                if (!line.isBlank()) {
                    nonEmptyLines++;
                }
                totalChars += line.length();
            }
        }
        return new FileStatistics(totalLines, nonEmptyLines, totalChars);
    }

    public int countOccurrences(File file, String encoding, String target) throws IOException {
        if (target == null || target.isEmpty()) {
            return 0;
        }

        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), encoding))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int index = 0;
                while ((index = line.indexOf(target, index)) != -1) {
                    count++;
                    index += target.length();
                }
            }
        }
        return count;
    }
}