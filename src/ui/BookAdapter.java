package ui;

import model.BookAdditional;
import model.BookGenre;
import model.Employee;
import repository.BookRepository;
import repository.dataSource.BookDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class BookAdapter {
    private final BookRepository repository;
    private final BookDataSource bookDataSource;

    public BookAdapter(BookRepository repository, BookDataSource bookDataSource) {
        this.repository = repository;
        this.bookDataSource = bookDataSource;
    }

    public void show() {
        /**
         * get the total count and price of sold books
         */
        String booksInfo =
                String.format("Total sum of sold books: %d, total price: %.2f", repository.getCountOfSoldBooks(), repository.getAllPriceOfSoldBooks());
        System.out.println(booksInfo);

        /**
         * get the count and price of sold books by employees
         */
        for (Employee employee : bookDataSource.getEmployees()) {
            System.out.println(employee.getName() + "sold " + repository.getProfitByEmployee(employee.getId()));
        }
        /**
        * get the count and price of sold books by genre
         */
        ArrayList<BookAdditional> soldBooksCount = repository.getCountOfSoldBooksByGenre();
        HashMap<BookGenre, Double> soldBooksPrice = repository.getPriceOfSoldBooksByGenre();
        String soldBooks = "By genre sold books: %s: %d books, total price: %.2f";

        for (BookAdditional bookAdditional : soldBooksCount) {
            double price = soldBooksPrice.get(bookAdditional.getGenre());
            System.out.println(String.format(soldBooks, bookAdditional.getGenre().name(), bookAdditional.getCount(), price));
        }
        /**
        * the most popular genre by age less or more
        */
        int age = 30;
        String analyzeGenreStr = "Customs under %d choose the %s";
        System.out.println(String.format(analyzeGenreStr, 30, repository.getMostPopularGenreLessThanAge(30)));

        String analyzeGenreStr2 = "Customs over %d choose the %s";
        System.out.println(String.format(analyzeGenreStr2, 30, repository.getMostPopularGenreMoreThenAge(30)));

    }
}
