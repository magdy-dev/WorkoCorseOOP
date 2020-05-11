package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Order;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO{


    public boolean update(Order order) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE orders SET  transactions_id =? , book_id=?  WHERE id=?")) {

            ps.setInt(1, order.getBookId());
            ps.setInt(2, order.getId());
            ps.setInt(3,order.getTransactionId());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Order selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders u where u.id =?");
          Order order = null;
            if (resultSet.next())
            {
                order = fetch(resultSet);
            }
            return order;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(Order order) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO orders (transactions_id,book_id) VALUES (?,?)")){

            preparedStatement.setInt(1, order.getId());
            preparedStatement.setInt(2,order.getBookId());
            preparedStatement.setInt(3,order.getTransactionId());

            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert order");
        }
        return false;
    }

    public void delete(Order order) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM orders");
           Order order1 = null;
            if (resultSet.next()) {
                order = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM orders u WHERE u.id =?");
           Order order= null;
            if (resultSet.next())
            {
            order = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Order fetch(ResultSet resultSet) throws SQLException {
        Order order= new Order();


        order.setId(resultSet.getInt("id"));
  order.setBookId(resultSet.getInt("Book_Id"));
       order.setTransactionId(resultSet.getInt("ransaction_Id"));


        return order;
    }
}