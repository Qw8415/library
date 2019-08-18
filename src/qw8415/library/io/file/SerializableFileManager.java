package qw8415.library.io.file;

import qw8415.library.ecxeption.DataExportException;
import qw8415.library.ecxeption.DataImportException;
import qw8415.library.model.Library;

import java.io.*;
import java.nio.file.NoSuchFileException;

class SerializableFileManager implements FileManager{
    private static final String FILE_NAME = "Library.io";

    @Override
    public Library importData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Library)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }

    @Override
    public void exportData(Library library) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            objectOutputStream.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
