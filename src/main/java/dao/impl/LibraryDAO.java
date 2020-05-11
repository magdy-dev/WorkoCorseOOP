package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Library;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    public boolean update(Library library) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("Update Library SET closet_id=? where id=?\n" +
                "Id=?")) {
            ps.setInt(1, library.getClosetId());
            ps.setInt(2, library.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            throw new DAOException("Excepicton during update ");

        }
        return false;
    }

    public Library selectById(int id) throws DAOException {
        try (Statement statement=ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT *from Library where id=" + id);
            Library library = null;

            if (resultSet.next()) {
                library = fetch(resultSet);
            }
            return library;
        }catch (SQLException e){
            throw new DAOException("(\"exception during select by id\"+id");
        }
}

    public boolean insert(Library library) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO library(closet_id)VALUES (?)")){
            preparedStatement.setInt(1, library.getId());
            preparedStatement.setInt(2, library.getClosetId());


            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert user");
        }
        return false;
    }

    public void delete(Library library) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM library");
            Library library1 = null;
            if (resultSet.next()) {
                library = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM library u WHERE u.id =" + id);
            Library library= null;
            if (resultSet.next())
            {
                library = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Library fetch(ResultSet resultSet) throws SQLException {
        Library library= new Library();

        library.setId(resultSet.getInt("id"));
       library.setClosetId(resultSet.getInt("ClosetId"));
        return library;
    }
}



