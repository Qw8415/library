package qw8415.library.app;

import qw8415.library.model.Book;

class Library {
    public static void main(String[] args) {
        final String appName = "Biblioteka v0.4";

        Book book1 = new Book("W pustyni i puszczy", "Henryk Sienkiewicz", 2010, 296, "Greg", "9788393271890");
        Book book2 = new Book("Java. Efektywne programowanie. Wydanie II", "Joshua Bloch", 2009, 352, "Helion", "9788324620845");
        Book book3 = new Book("SCJP Sun Certified Programmer for Java 6 Study Guide", "Bert Bates, Katherine Sierra", 2008, 851, "McGraw-Hill Osborne Media");

        System.out.println(appName);
        System.out.println("Dostępne książki:");
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
