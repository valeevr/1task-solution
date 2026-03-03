package ru.valeevr;

public class FileStatistics {
    private final int totalLines;
    private final int nonEmptyLines;
    private final long totalChars;
    private int occurrences; //для результата поиска слова

    public FileStatistics(int totalLines, int nonEmptyLines, long totalChars) {
        this.totalLines = totalLines;
        this.nonEmptyLines = nonEmptyLines;
        this.totalChars = totalChars;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public String toString() {
        return String.format(
                "Статистика:\n- Всего строк: %d\n- Непустых строк: %d\n- Всего символов: %d\n- Вхождений искомого слова: %d",
                totalLines, nonEmptyLines, totalChars, occurrences
        );
    }
}