package model;

public class BookAdditional {

    private BookGenre genre;
    private int count;

    public BookAdditional(BookGenre genre, int count) {
        this.genre = genre;
        this.count = count;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

}
