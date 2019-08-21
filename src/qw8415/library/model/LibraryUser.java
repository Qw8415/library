package qw8415.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static qw8415.library.io.file.CsvFileManager.CSV_SEPARATOR;

public class LibraryUser extends User {
    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    public void borrowPublication(Publication publication) {
        borrowedPublications.add(publication);
    }

    public boolean returnPublication(Publication publication) {
        if (borrowedPublications.remove(publication)) {
            addPublicationToHistory(publication);
            return true;
        }
        return false;
    }

    @Override
    public String toCsv() {
        return getFirstName() + CSV_SEPARATOR +
                getLastName() + CSV_SEPARATOR +
                getPesel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(publicationHistory, that.publicationHistory) && Objects.equals(borrowedPublications, that.borrowedPublications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationHistory, borrowedPublications);
    }

    private void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }
}
