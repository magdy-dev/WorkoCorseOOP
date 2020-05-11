package dao.impl;


import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Author;
import entities.User;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {


    public boolean update(Author author) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE author SET first_name=?, last_name=?,id=? WHERE id=?")) {
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setInt(3, author.getId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Author selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author u where u.id =" + id);
            Author author = null;
            if (resultSet.next())
            {
               author = fetch(resultSet);
            }
            return author;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(Author author) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO author(first_name,last_name) VALUES ( ?, ?)")){
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());



            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert author");
        }
        return false;
    }

    public void delete(Author author) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM author");
            Author author1 = null;
            if (resultSet.next()) {
               author =fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM author u WHERE u.id =" + id);
            Author author= null;
            if (resultSet.next())
            {
               author= fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Author fetch(ResultSet resultSet) throws SQLException {
        Author author = new Author();

        author.setId(resultSet.getInt("id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));


        return author;
    }
//

    public Author selectByAuthorName(String firstName, String lastName) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery(
                    "SELECT * FROM author u WHERE u.first_name ='" + firstName + "' and last_name = '"+ lastName + "'");
            Author author= null;
            if (resultSet.next())
            {
                author= fetch(resultSet);
            }
            return author;
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by firstname" + firstName);
        }
    }
}