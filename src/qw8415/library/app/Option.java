package qw8415.library.app;

import qw8415.library.ecxeption.NoSuchOptionException;

enum Option {
    EXIT(0, "Wyjdź"),
    ADD_BOOK(1, "Dodaj książkę"),
    ADD_MAGAZINE(2, "Dodaj magazyn"),
    PRINT_BOOKS(3, "Dostępne książki"),
    PRINT_MAGAZINES(4, "Dostępne magazyny");

    private int value;
    private String description;

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private Option(int value, String description) {
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
