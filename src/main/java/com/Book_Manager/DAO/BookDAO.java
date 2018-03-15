package com.Book_Manager.DAO;

import com.Book_Manager.Book.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO<E> {

    public void addBook(Book book) throws SQLException;
    public void removeBook(Book book) throws SQLException;
    public void editBook(Book book) throws SQLException;
    public void getAllBooks();
}
