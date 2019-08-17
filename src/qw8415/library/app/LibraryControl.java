package qw8415.library.app;

import qw8415.library.io.DataReader;
import qw8415.library.model.Library;

class LibraryControl {
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOption();
            option = Option.createFromInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Błędna opcja!");
            }
        } while (option != Option.EXIT);
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
        for (int i = 1; i < Option.values().length; i++) {
            System.out.println(Option.values()[i].toString());
        }
        System.out.println(Option.EXIT.toString());
    }
}
