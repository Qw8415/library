package qw8415.library.app;

import qw8415.library.ecxeption.DataExportException;
import qw8415.library.ecxeption.DataImportException;
import qw8415.library.ecxeption.NoSuchOptionException;
import qw8415.library.io.ConsolePrinter;
import qw8415.library.io.DataReader;
import qw8415.library.io.file.FileManager;
import qw8415.library.io.file.FileManagerBuilder;
import qw8415.library.model.Library;

import java.util.InputMismatchException;

class LibraryControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader reader = new DataReader(printer);
    private FileManager fileManager;
    private Library library;

    LibraryControl() {
        fileManager = new FileManagerBuilder(printer, reader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Wczytano dane.");
        } catch (DataImportException e) {
            printer.printLine(e.getMessage());
            library = new Library();
            printer.printLine("Zainicjowano nową bazę danych.");
        }
    }

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
        try {
            fileManager.exportData(library);
            printer.printLine("Zapisano bazę.");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());
        }
        reader.close();
        System.out.println("Do widzenia!");
    }

    private Option getOption() {
        boolean optionOK = false;
        Option option = null;
        do {
            try {
                option = Option.createFromInt(reader.getInt());
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
            library.addBook(reader.readAndCreateBook());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine(e.getMessage());
        } catch (InputMismatchException e) {
            printer.printLine("Wprowadzono niepoprawne dane. Nie udało się dodać książki.");
        }
    }

    private void addMagazine() {
        try {
            library.addMagazine(reader.readAndCreateMagazine());
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

    private enum Option {
        EXIT(0, "Wyjdź"),
        ADD_BOOK(1, "Dodaj książkę"),
        ADD_MAGAZINE(2, "Dodaj magazyn"),
        PRINT_BOOKS(3, "Dostępne książki"),
        PRINT_MAGAZINES(4, "Dostępne magazyny");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji " + option);
            }
        }
    }
}
