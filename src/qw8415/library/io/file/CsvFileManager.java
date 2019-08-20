package qw8415.library.io.file;

import qw8415.library.ecxeption.DataExportException;
import qw8415.library.ecxeption.InvalidDataException;
import qw8415.library.model.Book;
import qw8415.library.model.Library;
import qw8415.library.model.Magazine;
import qw8415.library.model.Publication;

import java.io.*;
import java.util.Scanner;

class CsvFileManager implements FileManager {
    public static final String FILE_NAME = "Library.csv";
    @Override
    public Library importData() {
        Library library = new Library();
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                Publication publication = createObjectFromString(fileScanner.nextLine());
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }

    private Publication createObjectFromString(String line) {
        String[] splitLine = line.split(Publication.CsvSeparator);
        String type = splitLine[0];
        if (type.equals(Book.TYPE)) {
            return createBook(splitLine);
        } else if (type.equals(Magazine.TYPE)) {
            return createMagazine(splitLine);
        }
        throw new InvalidDataException("Nieznany typ publikacji: " + type);
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



    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu do pliku: " + FILE_NAME);
        }
    }
}
