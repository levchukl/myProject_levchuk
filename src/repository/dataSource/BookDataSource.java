package repository.dataSource;

import model.Book;
import model.Customer;
import model.Employee;
import model.Order;

import java.util.List;

public interface BookDataSource {
    List<Book> getBooks();

    List<Customer> getCustomers();

    List<Employee> getEmployees();

    List<Order> getOrders();

}
