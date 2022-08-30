package repository;

import model.*;
import repository.dataSource.BookDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class BookRepositoryImpl implements BookRepository {
    private final BookDataSource bookDataSource;

    public BookRepositoryImpl(BookDataSource dataSource) {
        this.bookDataSource = dataSource;
    }

    /**
     * get the book by id
     *
     * @param id book id
     * @return book
     */
    private Book getBookById(long id) {
        Book current = null;

        for (Book book : bookDataSource.getBooks()) {
            if (book.getId() == id) {
                current = book;
                break;
            }
        }
        return current;
    }

    /**
     * get the total count of sold books
     *
     * @return count of all sold books
     */
    public int getCountOfSoldBooks() {
        int count = 0;

        for (Order order : bookDataSource.getOrders()) {
            count += order.getBooks().length;
        }
        return count;
    }

    /**
     * get the total cost of one order
     *
     * @param order order
     * @return sum of one order
     */
    private double getPriceOfSoldBooksInOrder(Order order) {
        double price = 0;
        for (long bookId : order.getBooks()) {
            Book book = getBookById(bookId);
            if (book != null)
                price += book.getPrice();
        }
        return price;
    }

    public double getAllPriceOfSoldBooks() {
        double price = 0;
        for (Order order : bookDataSource.getOrders()) {
            price += getPriceOfSoldBooksInOrder(order);
        }
        return price;
    }

    /**
     * total count and price of books sold by one employee
     *
     * @param employeeId employee id
     * @return count and price
     */
    public Profit getProfitByEmployee(long employeeId) {
        int count = 0;
        double price = 0;

        for (Order order : bookDataSource.getOrders()) {
            if (order.getEmployeeId() == employeeId) {
                price += getPriceOfSoldBooksInOrder(order);
                count += order.getBooks().length;
            }
        }
        return new Profit(count, price);
    }

    private double getPriceOfSoldByGenre(Order order, BookGenre genre) {
        double price = 0;

        for (long bookId : order.getBooks()) {
            Book book = getBookById(bookId);
            if (book != null && book.getGenre() == genre)
                price += book.getPrice();
        }
        return price;
    }

    /**
     * total price of all books by genre
     *
     * @return total price
     */
    public HashMap<BookGenre, Double> getPriceOfSoldBooksByGenre() {
        HashMap<BookGenre, Double> result = new HashMap<>();

        double priceArt = 0;
        double pricePr = 0;
        double pricePs = 0;

        for (Order order : bookDataSource.getOrders()) {
            priceArt += getPriceOfSoldByGenre(order, BookGenre.Art);
            pricePr += getPriceOfSoldByGenre(order, BookGenre.Programming);
            pricePs += getPriceOfSoldByGenre(order, BookGenre.Psychology);
        }
        result.put(BookGenre.Art, priceArt);
        result.put(BookGenre.Programming, pricePr);
        result.put(BookGenre.Psychology, pricePs);
        return result;
    }

    private int getCountOfSoldByGenre(Order order, BookGenre genre) {
        int count = 0;
        for (long bookId : order.getBooks()) {
            Book book = getBookById(bookId);
            if (book != null && book.getGenre() == genre) {
                count++;
            }
        }
        return count;
    }

    /**
     * total count of sold books in all orders by genre
     *
     * @return total count
     */
    public ArrayList<BookAdditional> getCountOfSoldBooksByGenre() {
        ArrayList<BookAdditional> result = new ArrayList<>();
        int countArt = 0;
        int countPr = 0;
        int countPs = 0;

        for (Order order : bookDataSource.getOrders()) {
            countArt += getCountOfSoldByGenre(order, BookGenre.Art);
            countPr += getCountOfSoldByGenre(order, BookGenre.Programming);
            countPs += getCountOfSoldByGenre(order, BookGenre.Psychology);
        }
        result.add(new BookAdditional(BookGenre.Art, countArt));
        result.add(new BookAdditional(BookGenre.Programming, countPr));
        result.add(new BookAdditional(BookGenre.Psychology, countPs));
        return result;
    }

    /**
     * get the most popular books by genre
     *
     * @param customerIds customer id
     * @return most popular books by genre
     */
    private BookGenre getMostPopularBookGenre(ArrayList<Long> customerIds) {
        int countArt = 0;
        int countPr = 0;
        int countPs = 0;

        for (Order order : bookDataSource.getOrders()) {
            if (customerIds.contains(order.getCustomerId())) {
                countArt += getCountOfSoldByGenre(order, BookGenre.Art);
                countPr += getCountOfSoldByGenre(order, BookGenre.Programming);
                countPs += getCountOfSoldByGenre(order, BookGenre.Psychology);
            }
            ;
        }
        ;
        ArrayList<BookAdditional> result = new ArrayList<>();
        result.add(new BookAdditional(BookGenre.Art, countArt));
        result.add(new BookAdditional(BookGenre.Programming, countPr));
        result.add(new BookAdditional(BookGenre.Psychology, countPs));

        result.sort((left, right) -> right.getCount() - left.getCount());
        return result.get(0).getGenre();
    }

    public BookGenre getMostPopularGenreLessThanAge(int age) {
        ArrayList<Long> customerIds = new ArrayList<>();
        for (Customer customer : bookDataSource.getCustomers()) {
            if (customer.getAge() < age) {
                customerIds.add(customer.getId());
            }
        }
        return getMostPopularBookGenre(customerIds);
    }

    public BookGenre getMostPopularGenreMoreThenAge(int age) {
        ArrayList<Long> customerIds = new ArrayList<>();
        for (Customer customer : bookDataSource.getCustomers()) {
            if (customer.getAge() > age) {
                customerIds.add(customer.getId());
            }
        }
        return getMostPopularBookGenre(customerIds);
    }

}
