package qw8415.library.app;

class LibraryApp {
    final static String APP_NAME = "Biblioteka v2.2";

    public static void main(String[] args) {
        LibraryControl controller = new LibraryControl();

        System.out.println(APP_NAME);
        controller.controlLoop();
    }
}
