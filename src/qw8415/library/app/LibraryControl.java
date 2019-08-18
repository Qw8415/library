package qw8415.library.app;

import qw8415.library.ecxeption.NoSuchOptionException;
import qw8415.library.io.ConsolePrinter;
import qw8415.library.io.DataReader;
import qw8415.library.model.Library;

import java.util.InputMismatchException;

class LibraryControl {
    private Library library = new Library();
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);

    public void controlLoop() {
        Option option;

        do {
            printOption();
            option = getOption();
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

    private Option getOption() {
        boolean optionOK = false;
        Option option = null;
        do {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOK = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + " Wybierz ponownie:");
            } catch (InputMismatchException e) {
                printer.printLine("Podaj nr opcji!");
            }
        } while (!optionOK);
        return option;
    }

    private void addBook() {
        try {
            library.addBook(dataReader.readAndCreateBook());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine(e.getMessage());
        } catch (InputMismatchException e) {
            printer.printLine("Wprowadzono niepoprawne dane. Nie udało się dodać książki.");
        }
    }

    private void addMagazine() {
        try {
            library.addMagazine(dataReader.readAndCreateMagazine());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine(e.getMessage());
        } catch (InputMismatchException e) {
            printer.printLine("Wprowadzono niepoprawne dane. Nie udało się dodać magazynu.");
        }
    }

    private void printBooks() { printer.printBooks(library.getPublications()); }

    private void printMagazines() {
        printer.printMagazines(library.getPublications());
    }

    private void printOption() {
        System.out.println("\n---=== MENU ===---");
        for (int i = 1; i < Option.values().length; i++) {
            System.out.println(Option.values()[i].toString());
        }
        System.out.println(Option.EXIT.toString());
    }
}
