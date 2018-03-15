package com.Book_Manager;

import com.Book_Manager.Book.Book;
import com.Book_Manager.DAO.BookDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws SQLException {
        BookDAOImpl bookDAO = new BookDAOImpl();
        Book book = new Book();
        Scanner in = new Scanner(System.in);

        bookDAO.getAllBooks();
        book.setBook_name("Sword");
        book.setAuthor_name(" John Truman");
        bookDAO.addBook(book);

    }
}
