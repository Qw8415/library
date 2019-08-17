package qw8415.library.model;

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

    public void printInfo() {
        String info = getTitle() + "; " + author + "; " + getYear() + "; " + pages + "; " + getPublisher();
        if (isbn != null) {
            info += "; " + isbn;
        }
        System.out.println(info);
    }
}
