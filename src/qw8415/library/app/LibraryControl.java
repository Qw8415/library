package qw8415.library.app;

import qw8415.library.io.DataReader;
import qw8415.library.model.Library;

class LibraryControl {
    private static final int EXIT_CODE = 0;
    private static final int ADD_BOOK_CODE = 1;
    private static final int ADD_MAGAZINE_CODE = 2;
    private static final int PRINT_BOOKS_CODE = 3;
    private static final int PRINT_MAGAZINES_CODE = 4;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOption();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK_CODE:
                    addBook();
                    break;
                case ADD_MAGAZINE_CODE:
                    addMagazine();
                    break;
                case PRINT_BOOKS_CODE:
                    printBooks();
                    break;
                case PRINT_MAGAZINES_CODE:
                    printMagazines();
                    break;
                case EXIT_CODE:
                    exit();
                    break;
                default:
                    System.out.println("Błędna opcja!");
            }
        } while (option != EXIT_CODE);
    }

    private void exit() {
        dataReader.close();
        System.out.println("Do widzenia!");
    }


    private void addBook() {
        library.addBook(dataReader.readAndCreteBook());
    }

    private void addMagazine() {
        library.addMagazine(dataReader.readAndCreateMagazine());
    }

    private void printBooks() {
        library.printBooks();
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void printOption() {
        System.out.println("\n---=== MENU ===---");
        System.out.println(ADD_BOOK_CODE + " - dodaj ksążkę");
        System.out.println(ADD_MAGAZINE_CODE + " - dodaj magazyn");
        System.out.println(PRINT_BOOKS_CODE + " - spis książek");
        System.out.println(PRINT_MAGAZINES_CODE + " - spis magazynów");
        System.out.println(EXIT_CODE + " - wyjście");
    }
}
