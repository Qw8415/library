package qw8415.library.model;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    private static final int INITIAL_CAPACITY = 1;
    private Publication[] publications = new Publication[INITIAL_CAPACITY];
    private int publicationsNumber;

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i = 0; i < publicationsNumber; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addPublication(Publication publication) {
        if (publicationsNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length + 10);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

    public boolean removePublication(Publication publication) {
        for (int i = 0; i < publicationsNumber; i++) {
            if (publications[i].equals(publication)) {
                System.arraycopy(publications, i + 1, publications, i, publications.length - i - 1);
                publicationsNumber--;
                return true;
            }
        }
        return false;
    }
}
