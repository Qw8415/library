package qw8415.library.model;


import static qw8415.library.io.file.CsvFileManager.CSV_SEPARATOR;

import java.util.Objects;

public class Magazine extends Publication {
    public static final String TYPE = "MAGAZINE";
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(year, title, publisher);
        this.language = language;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toCsv() {
        return TYPE + CSV_SEPARATOR +
                getTitle() + CSV_SEPARATOR +
                getPublisher() + CSV_SEPARATOR +
                getYear() + CSV_SEPARATOR +
                month + CSV_SEPARATOR +
                day + CSV_SEPARATOR +
                language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return month == magazine.month && day == magazine.day && Objects.equals(language, magazine.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), month, day, language);
    }

    @Override
    public String toString() {
        return super.toString() + "/" + month + "/" + day + "; " + language;
    }
}
