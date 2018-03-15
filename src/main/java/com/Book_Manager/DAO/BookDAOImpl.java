package com.Book_Manager.DAO;
import com.Book_Manager.Book.Book;
import com.Book_Manager.DBConnection.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDAOImpl implements BookDAO {


    private static ConnectionFactory connectionFactory = new ConnectionFactory();


    @Override
    public void addBook(Book book) throws SQLException {
        Statement stmt = null;
        String add = "INSERT INTO book(book_name, author_name) VALUES ('" + book.getBook_name() + "','" + book.getAuthor_name() +"') ";
        try {
            stmt = connectionFactory.getConnection().createStatement();
            stmt.execute(add);
            System.out.println("Book "+book.getBook_name() +", "+ book.getAuthor_name()+" was added");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){
            stmt.close();
            }
        }
    }

    @Override
    public void removeBook(Book book) throws SQLException {
        Statement stmt = null;
        String delete = "DELETE FROM book WHERE id = '" + book.getId() + "'";
        try {
            stmt = connectionFactory.getConnection().createStatement();
            stmt.execute(delete);
            System.out.println("Book was removed");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null){
            stmt.close();
            }
        }
    }

    @Override
    public void editBook(Book book ) throws SQLException {
        Statement stmt = null;
        String update = "UPDATE book SET book_name = '"+book.getNew_name()+"' WHERE id = '" + book.getId() + "'";
        try {
             stmt = connectionFactory.getConnection().createStatement();
             stmt.execute(update);
            System.out.println("Book was edited");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt != null){
            stmt.close();
            }
        }
    }


    @Override
    public void getAllBooks() {
        String allBooks = "SELECT * FROM book.book";
        try {
            Statement statement = connectionFactory.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(allBooks);

            while (resultSet.next()){
                System.out.println("Id:"+ resultSet.getInt("id") +" "+ resultSet.getString("author_name")+" "
                        + resultSet.getString("book_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
