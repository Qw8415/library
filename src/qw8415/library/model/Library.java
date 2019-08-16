package qw8415.library.model;

public class Library {
    private final int maxBooks = 1000;
    private Book books[] = new Book[maxBooks];
    private int booksNumber;

    public void addBook(Book book){
        if (booksNumber < maxBooks) {
            books[booksNumber] = book;
            booksNumber++;
        } else {
            System.out.println("Brak miejsca na półkach!");
        }
    }

    public void printBooks() {
        if (booksNumber == 0) System.out.println("Brak książek w bibliotece!");
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }

}
