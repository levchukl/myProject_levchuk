package repository;

import model.BookAdditional;
import model.BookGenre;
import model.Profit;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookRepository {
    int getCountOfSoldBooks();

    double getAllPriceOfSoldBooks();

    //отримати вартість проданих книжок по жанрам
    HashMap<BookGenre, Double> getPriceOfSoldBooksByGenre();

    Profit getProfitByEmployee(long employeeId);

    ArrayList<BookAdditional> getCountOfSoldBooksByGenre();

    BookGenre getMostPopularGenreLessThanAge(int age);

    BookGenre getMostPopularGenreMoreThenAge(int age);

}
