package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Shelf;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShelfDAO{
    public boolean update( Shelf shelf) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement
                ("UPDATE  Shelf SET id=?, bookId+=?," +
                " WHERE id=?")) {
            ps.setInt(1, shelf.getId());
            ps.setInt(2, shelf.getBookId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Shelf selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Shelf u where u.id = ?");
            Shelf shelf = null;
            if (resultSet.next())
            {
          shelf = fetch(resultSet);
            }
            return  shelf;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert( Shelf  shelf) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement
                ("INSERT INTO  shelf (book_id) VALUES (?)")){
            preparedStatement.setInt(1,  shelf.getId());
            preparedStatement.setInt(2,  shelf.getId());


            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert user");
        }
        return false;
    }

    public void delete(Shelf shelf) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM shelf");
            Shelf shelf1 = null;
            if (resultSet.next()) {
                shelf = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM shelf u WHERE u.id =?");
          Shelf shelf = null;
            if (resultSet.next())
            {
                shelf = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Shelf fetch(ResultSet resultSet) throws SQLException {
        Shelf shelf = new Shelf();

        shelf.setId(resultSet.getInt("id"));
        shelf.setBookId(resultSet.getInt("bookId"));


        return shelf;
    }

}
