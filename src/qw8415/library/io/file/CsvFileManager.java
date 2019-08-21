package qw8415.library.io.file;

import qw8415.library.ecxeption.DataExportException;
import qw8415.library.ecxeption.DataImportException;
import qw8415.library.ecxeption.InvalidDataException;
import qw8415.library.model.*;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String PUBLICATIONS_FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME = "Users.csv";
    public static final String CSV_SEPARATOR = ";";

    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);
        return library;
    }

    @Override
    public void exportData(Library library) {
        exportPublications(library);
        exportUsers(library);
    }

    private void importPublications(Library library) {
        try (Scanner fileScanner = new Scanner(new File(PUBLICATIONS_FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                Publication publication = createPublicationFromString(fileScanner.nextLine());
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Nie znaleziono pliku " + PUBLICATIONS_FILE_NAME);
        }
    }

    private void importUsers(Library library) {
        try (Scanner fileScanner = new Scanner(new File(USERS_FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                LibraryUser user = createUserFromString(fileScanner.nextLine());
                library.addUser(user);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Nie znaleziono pliku: " + USERS_FILE_NAME);
        }
    }

    private void exportPublications(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PUBLICATIONS_FILE_NAME))) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu do pliku: " + PUBLICATIONS_FILE_NAME);
        }
    }

    private void exportUsers(Library library) {
        Collection<LibraryUser> users = library.getUsers().values();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE_NAME))) {
            for (LibraryUser user : users) {
                writer.write(user.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu do pliku: " + USERS_FILE_NAME);
        }
    }

    private Publication createPublicationFromString(String line) {
        String[] splitLine = line.split(CSV_SEPARATOR);
        String type = splitLine[0];
        if (type.equals(Book.TYPE)) {
            return createBook(splitLine);
        } else if (type.equals(Magazine.TYPE)) {
            return createMagazine(splitLine);
        }
        throw new InvalidDataException("Nieznany typ publikacji: " + type);
    }

    private LibraryUser createUserFromString(String line) {
        String[] splitLine = line.split(CSV_SEPARATOR);
        String firstName = splitLine[0];
        String lastName = splitLine[1];
        String pesel = splitLine[2];
        return new LibraryUser(firstName, lastName, pesel);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int month = Integer.valueOf(data[4]);
        int day = Integer.valueOf(data[5]);
        String language = data[6];
        return new Magazine(title, publisher, language, year, month, day);
    }
}
