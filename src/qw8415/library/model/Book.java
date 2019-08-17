package qw8415.library.model;

import java.util.Objects;

public class Book extends Publication{
    private String author;
    private int pages;
    private String isbn;

    public Book(String title, String author, int releaseDate, int pages, String publisher, String isbn) {
        this(title, author, releaseDate, pages, publisher);
        this.isbn = isbn;
    }

    public Book(String title, String author, int year, int pages, String publisher) {
        super(year, title, publisher);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }

    @Override
    public String toString() {
        return super.toString() + "; " + author + "; " + pages + "; " + isbn;
    }
}
