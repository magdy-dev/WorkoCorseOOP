package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {


    public boolean update(Book book) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE book SET author_id=?, cateGory_id=?,tittle=?, number_Of_Pages=? WHERE id=?")) {

            ps.setInt(1, book.getId());
            ps.setInt(2, book.getAuthorId());
            ps.setString(3, book.getName());
            ps.setInt(4, book.getNumberOfPages());
            ps.setInt(5, book.getCategoryId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Book selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM book u where u.id =" + id);
            Book book = null;
            if (resultSet.next()) {
                book = fetch(resultSet);
            }
            return book;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id" + id);
        }
    }

    public boolean insert(Book book) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("IINSERT INTO book(author_id,category_id,tittle,number_of_pages) VALUES (?,?,?,?);NSERT INTO book VALUES (NULL, ?, ?, ?)")) {

            preparedStatement.setInt(1, book.getAuthorId());
            preparedStatement.setInt(2, book.getCategoryId());
            preparedStatement.setString(3, "tittle");
            preparedStatement.setInt(4, book.getNumberOfPages());


            int i = preparedStatement.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            throw new DAOException("exception during insert basket");
        }
        return false;
    }

    public void delete(Book book) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM book");
            Book book1 = null;
            if (resultSet.next()) {
                book1 = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById(int id) throws DAOException {
        try (Statement stmt = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM book u WHERE u.id =" + id);
            Book book = null;
            if (resultSet.next()) {
                book = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Book fetch(ResultSet resultSet) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("tittle"));
        book.setAuthorId(resultSet.getInt("author_id"));
        book.setNumberOfPages(resultSet.getInt("number_of_pages"));
        book.setCategoryId(resultSet.getInt("category_id"));

        return book;
    }

    public Book selectByBookName(String bookName) throws DAOException {
        try (Statement stmt = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(
                    "SELECT * FROM book u WHERE u.bookName =" + bookName);
            Book book = null;
            if (resultSet.next()) {
                book = fetch(resultSet);
            }
            return book;
        } catch (SQLException e) {
            throw new DAOException("exception during de;ete by bookName" + bookName);
        }
    }

    public Book selectByCategoryId(int id) throws DAOException {
        try (Statement stmt = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM book u WHERE u.id =?");
            Book book = null;
            if (resultSet.next()) {
                book = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during de;ete by id" + id);
        }
        return null;
    }

    public Book selectByAuthorId(int id) throws DAOException {
        try (Statement statement=ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *from book where author_id=" + id);
           Book book = null;

            if (resultSet.next()) {
                book = fetch(resultSet);
            }
            return book;
        }catch (SQLException e){
            throw new DAOException("(\"exception during select by id\"+id");
        }
    }


    }

