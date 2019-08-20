package qw8415.library.io.file;

import qw8415.library.ecxeption.NoSuchFileTypeException;
import qw8415.library.io.ConsolePrinter;
import qw8415.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build() {
        printer.printLine("Wybierz format danych: ");
        FileType fileType = getFileType();
        switch (fileType) {
            case CSV:
                return new CsvFileManager();
            case SERIAL:
                return new SerializableFileManager();
            default:
                throw new NoSuchFileTypeException("Nieobsługiwany format danych");
        }
    }

    private FileType getFileType() {
        boolean fileTypeOk = false;
        FileType fileType = null;
        do {
            printTypes();
            String inputType = reader.getString().toUpperCase();
            try {
                fileType = FileType.valueOf(inputType);
                fileTypeOk = true;
            } catch (IllegalArgumentException e) {
                printer.printLine("Nieobsługiwany format danych! Wybierz ponownie:");
            }
        } while (!fileTypeOk);
        return fileType;
    }

    private void printTypes() {
        for (FileType fileType : FileType.values()) {
            printer.printLine(fileType.name());
        }
    }
}
