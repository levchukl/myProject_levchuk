package repository.dataSource;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class BookDataSourceImpl implements BookDataSource {
    private List<Book> books = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public BookDataSourceImpl() {
        initDate();
    }

    private void initDate() {
        employees.add(new Employee(11111, "Maxim Petrov", 36));
        employees.add(new Employee(11112, "Anna Ivanova", 26));
        employees.add(new Employee(11113, "Anton Zykh", 31));

        customers.add(new Customer(21111, "Inna", 20));
        customers.add(new Customer(21112, "Anna", 55));
        customers.add(new Customer(21113, "Ivan", 16));
        customers.add(new Customer(21114, "Nazar", 38));
        customers.add(new Customer(21115, "Tania", 42));

        books.add(new Book(1254, "The Woman in White", "Collins W.", 290, BookGenre.Art));
        books.add(new Book(1258, "1984", "Orwell G.", 160, BookGenre.Art));
        books.add(new Book(2587, "The Gold-bug - Edgar Allan Poe", "Edgar Allan Poe", 130, BookGenre.Art));
        books.add(new Book(3554, "Pride and Prejudice ", "Jane Austen", 130, BookGenre.Art));
        books.add(new Book(9542, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 110, BookGenre.Art));

        books.add(new Book(9572, "Exercises in Psychological Testing", "Kaplan R., Saccuzzo D.", 150, BookGenre.Psychology));
        books.add(new Book(872, "The intelligence testdesk reference (ITDR) Gf-Gc Cross-battery Assessmen", "McGrew K., Flanagan D.", 210, BookGenre.Psychology));
        books.add(new Book(42, "Psychological testing. Principles, applications and Issues", "Condon M., Hollis-Sawyer L., Thotnton G.", 320, BookGenre.Psychology));

        books.add(new Book(427, "Continuous Delivery", "Jez Humble, David Farley", 520, BookGenre.Programming));
        books.add(new Book(8527, "Rapid Development", "Steve McConnell", 320, BookGenre.Programming));
        books.add(new Book(4207, "Applied Virtualization Technology", "Sean Campbell and Michael Jeronimo", 155, BookGenre.Programming));
        books.add(new Book(9427, "MySQL and JSP Web Applicatios", "Turner James", 160, BookGenre.Programming));

        orders.add(new Order(1, 11111, 21112, new long[]{42, 1254}));
        orders.add(new Order(2, 11112, 21111, new long[]{427}));
        orders.add(new Order(3, 11111, 21113, new long[]{8527, 9427, 4207}));
        orders.add(new Order(4, 11113, 21114, new long[]{3554, 2587}));
        orders.add(new Order(5, 11113, 21115, new long[]{1258, 3554}));

    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

}
