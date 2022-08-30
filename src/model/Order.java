package model;

public class Order {
    private long id;
    private long customerId;
    private long employeeId;
    private long[] books;

    public Order(long id, long employeeId, long customerId, long[] books) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public long[] getBooks() {
        return books;
    }

}
