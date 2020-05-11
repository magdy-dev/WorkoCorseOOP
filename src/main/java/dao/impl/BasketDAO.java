package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Address;
import entities.Basket;
import entities.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BasketDAO{

    public boolean update( Basket  basket) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("\n" +
                "update basket SET book_id=? where id=?\n")) {

            ps.setInt(1, basket.getBookId());
            ps.setInt(2,basket.getId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Basket selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM basket u where u.id =" + id);
           Basket basket= null;
            if (resultSet.next())
            {
               basket = fetch(resultSet);
            }
            return basket;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(Basket basket) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO basket (id,book_id)VALUES ( ?,?)")){
            preparedStatement.setInt(1,basket.getId());
            preparedStatement.setInt(2, basket.getBookId());


            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert basket");
        }
        return false;
    }

    public void delete(Basket basket) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM basket");
           Basket basket1 = null;
            if (resultSet.next()) {
              basket1 = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM basket u WHERE u.id =" + id);
            Basket basket = null;
            if (resultSet.next())
            {
               basket = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Basket fetch(ResultSet resultSet) throws SQLException {
       Basket basket= new Basket();

       basket.setId(resultSet.getInt("id"));
        basket.setBookId(resultSet.getInt("bookId"));

        return basket;
    }

}
