package qw8415.library.io;

import qw8415.library.model.Book;
import qw8415.library.model.LibraryUser;
import qw8415.library.model.Magazine;
import qw8415.library.model.Publication;

import java.util.Collection;

public class ConsolePrinter {
    public void printBooks(Collection<Publication> publications) {
        int countBooks = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.toString());
                countBooks++;
            }
        }
        if (countBooks == 0) printLine("Brak książek w bibliotece!");
    }

    public void printMagazines(Collection<Publication> publications) {
        int countMagazines = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.toString());
                countMagazines++;
            }
        }
        if (countMagazines == 0) printLine("Brak magazynów w bibliotece!");
    }

    public void printUsers(Collection<LibraryUser> users) {
        for (LibraryUser user : users) {
            printLine(user.toString());
        }
    }

    public void printLine(String text) {
        System.out.println(text);
    }
}
