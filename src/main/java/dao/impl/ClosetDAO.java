package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Closet;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClosetDAO {

    public boolean update (Closet closet) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE closet SET shelfId=?, id+=?,\" +\n" +
                "                \" WHERE id=?")) {

            ps.setInt(1, closet.getShelfId());
            ps.setInt(2, closet.getId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Closet selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM closet u where u.id =" + id);
            Closet closet= null;
            if (resultSet.next())
            {
               closet= fetch(resultSet);
            }
            return closet;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }
    public boolean insert(Closet closet) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO closet(shelf_id) VALUES (?)")){

            preparedStatement.setInt(1,closet.getShelfId());

            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert closet");
        }
        return false;
    }

    public void delete(Closet closet) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM closet");
           Closet closet1 = null;
            if (resultSet.next()) {
              closet = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM closet u WHERE u.id =" + id);
           Closet closet = null;
            if (resultSet.next())
            {
              closet = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Closet fetch(ResultSet resultSet) throws SQLException {
       Closet closet = new Closet();

        closet.setId(resultSet.getInt("id"));
        closet.setShelfId(resultSet.getInt("ShelfId"));

        return closet;
    }
}
