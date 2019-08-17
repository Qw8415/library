package qw8415.library.model;

public class Library {
    private static final int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publicationsNumber;

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < publicationsNumber; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    private void addPublication(Publication publication) {
        if (publicationsNumber >= MAX_PUBLICATIONS)
            throw new ArrayIndexOutOfBoundsException("Limit publikacji w bibliotece: " + publicationsNumber + "/" + MAX_PUBLICATIONS);
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}
