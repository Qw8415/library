package qw8415.library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication>, CsvConvertible {

    private int year;
    private String title;
    private String publisher;

    Publication(int year, String title, String publisher) {
        this.year = year;
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        Publication that = (Publication) p;
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

    @Override
    public int compareTo(Publication o) {
        return title.compareToIgnoreCase(o.title);
    }

    public int getYear() { return year; }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
