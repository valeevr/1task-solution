package ru.valeevr.model;

public sealed interface ValidateFileResult permits ValidateFileResult.Error, ValidateFileResult.Valid {
    public final class Valid implements ValidateFileResult {
    }

    public record Error(String message) implements ValidateFileResult {
    }
}
