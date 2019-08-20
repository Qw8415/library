package qw8415.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable {
    public static final String CsvSeparator = ";";
    private int year;
    private String title;
    private String publisher;

    public abstract String toCsv();

    Publication(int year, String title, String publisher) {
        this.year = year;
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && title.equals(that.title) && publisher.equals(that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, title, publisher);
    }

    @Override
    public String toString() {
        return title + "; " + publisher + "; " + year;
    }

    int getYear() {
        return year;
    }

    void setYear(int year) {
        this.year = year;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getPublisher() {
        return publisher;
    }

    void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
