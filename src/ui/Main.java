package ui;

import repository.BookRepository;

import repository.BookRepositoryImpl;
import repository.dataSource.BookDataSource;
import repository.dataSource.BookDataSourceImpl;

public class Main {

    public static void main(String[] args) {
        BookDataSource bookDataSource = new BookDataSourceImpl();
        BookRepository bookRepository = new BookRepositoryImpl(bookDataSource);
        BookAdapter adapter = new BookAdapter(bookRepository, bookDataSource);
        adapter.show();
    }
}
