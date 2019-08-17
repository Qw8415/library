package qw8415.library.io;

import qw8415.library.model.Book;
import qw8415.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
     Scanner scanner = new Scanner(System.in);

     public void close() {
         scanner.close();
     }

     public Book readAndCreteBook() {
         System.out.println("Tytuł: ");
         String title = scanner.nextLine();
         System.out.println("Autor: ");
         String author = scanner.nextLine();
         System.out.println("Wydawnictwo: ");
         String publisher = scanner.nextLine();
         System.out.println("ISBN: ");
         String isbn = scanner.nextLine();
         System.out.println("Rok wydania: ");
         int releaseDate = getInt();
         System.out.println("Ilość stron: ");
         int pages = getInt();

         return new Book(title, author, releaseDate, pages, publisher, isbn);
     }

     public Magazine readAndCreateMagazine() {
         System.out.println("Tytuł:");
         String title = scanner.nextLine();
         System.out.println("Wydawnictwo:");
         String publisher = scanner.nextLine();
         System.out.println("Język:");
         String language = scanner.nextLine();
         System.out.println("Rok wydania:");
         int year = getInt();
         System.out.println("Miesiąc:");
         int month = getInt();
         System.out.println("Dzień:");
         int day = getInt();

         return new Magazine(title, publisher, language, year, month, day);
     }

     public int getInt() {
         int number = scanner.nextInt();
         scanner.nextLine();
         return number;
     }
}
