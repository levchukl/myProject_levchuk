package model;

public class Book {
    private long id;
    private String title;
    private String author;
    private double price;
    private BookGenre genre;

    public Book(long id, String title, String author, double price, BookGenre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public BookGenre getGenre() {
        return genre;
    }

}
