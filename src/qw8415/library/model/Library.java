package qw8415.library.model;

import qw8415.library.ecxeption.PublicationAlreadyExistsException;
import qw8415.library.ecxeption.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public void addUser(LibraryUser user) {
        if (users.containsKey(user.getPesel())) {
            throw new UserAlreadyExistsException("Użytkownik o tym PESELu już istnieje. Pesel: " + user.getPesel());
        }
        users.put(user.getPesel(), user);
    }

    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {
            throw new PublicationAlreadyExistsException(
                    "Publikacja o tym tytule znajduje się już w bazie: " + publication.getTitle());
        }
        publications.put(publication.getTitle(), publication);
    }

    public boolean removePublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {
            publications.remove(publication.getTitle());
            return true;
        }
        return false;
    }
}
