package qw8415.library.io;

import qw8415.library.model.Book;
import qw8415.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
     Scanner scanner = new Scanner(System.in);
     ConsolePrinter printer;

     public DataReader(ConsolePrinter printer) {
         this.printer = printer;
     }

     public void close() {
         scanner.close();
     }

     public Book readAndCreateBook() {
         printer.printLine("Tytuł: ");
         String title = scanner.nextLine();
         printer.printLine("Autor: ");
         String author = scanner.nextLine();
         printer.printLine("Wydawnictwo: ");
         String publisher = scanner.nextLine();
         printer.printLine("ISBN: ");
         String isbn = scanner.nextLine();
         printer.printLine("Rok wydania: ");
         int releaseDate = getInt();
         printer.printLine("Ilość stron: ");
         int pages = getInt();

         return new Book(title, author, releaseDate, pages, publisher, isbn);
     }

     public Magazine readAndCreateMagazine() {
         printer.printLine("Tytuł:");
         String title = scanner.nextLine();
         printer.printLine("Wydawnictwo:");
         String publisher = scanner.nextLine();
         printer.printLine("Język:");
         String language = scanner.nextLine();
         printer.printLine("Rok wydania:");
         int year = getInt();
         printer.printLine("Miesiąc:");
         int month = getInt();
         printer.printLine("Dzień:");
         int day = getInt();

         return new Magazine(title, publisher, language, year, month, day);
     }

     public int getInt() {
         try {
             return scanner.nextInt();
         } finally {
             scanner.nextLine();
         }
     }
}
