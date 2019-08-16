package qw8415.library.app;

import qw8415.library.io.DataReader;
import qw8415.library.model.Library;

class LibraryControl {
    private final int exitCode = 0;
    private final int addBookCode = 1;
    private final int printBooksCode = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOption();
            option = dataReader.getInt();
            switch (option) {
                case addBookCode:
                    addBook();
                    break;
                case printBooksCode:
                    printBooks();
                    break;
                case exitCode:
                    exit();
                    break;
                default:
                    System.out.println("Błędna opcja!");
            }
        } while (option != exitCode);
    }

    private void exit() {
        dataReader.close();
        System.out.println("Do widzenia!");
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        library.addBook(dataReader.readAndCreteBook());
    }

    private void printOption() {
        System.out.println("\n---=== MENU ===---");
        System.out.println(addBookCode + " - dodaj ksążkę");
        System.out.println(printBooksCode + " - spis książek");
        System.out.println(exitCode + " - wyjście");
    }
}
