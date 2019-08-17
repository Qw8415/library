package qw8415.library.model;

import java.util.Objects;

public class Magazine extends Publication {
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
