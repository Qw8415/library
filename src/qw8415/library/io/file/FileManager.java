package qw8415.library.io.file;

import qw8415.library.model.Library;

public interface FileManager {
    Library importData();
    void exportData(Library library);
}
