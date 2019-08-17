package qw8415.library.model;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        setTitle(title);
        setPublisher(publisher);
        setYear(year);
        this.language = language;
        this.month = month;
        this.day = day;
    }

    public void printInfo() {
        String info = getTitle() + "; " + getPublisher() + "; " + getYear() + "/" + month + "/" + day + "; " + language;
        System.out.println(info);
    }
}
