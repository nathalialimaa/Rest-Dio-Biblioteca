package me.dio.biblioteca.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LocalDate parse(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        return LocalDate.parse(data, FORMATTER);
    }

    public String format(LocalDate data) {
        if (data == null) {
            return null;
        }
        return data.format(FORMATTER);
    }
}