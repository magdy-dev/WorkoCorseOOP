package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Transaction;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    private Object Transaction;

    public boolean update(Transaction transaction) throws DAOException {
            try (PreparedStatement ps = ConnBuilder.connection.prepareStatement
                    ("UPDATE  transaction SET bookId=?, UserId+=?," +
                   "price =?,  data =?,  WHERE UserId=?")) {
                ps.setString(1, transaction.getDate());
                ps.setInt(2,transaction.getUserId());
                ps.setDouble(3, transaction.getPrice());
                ps.setInt(4, transaction.getBookId());

                int i = ps.executeUpdate();

                if (i == 1) {
                    return true;
                }
            } catch (SQLException e) {
                throw new DAOException("exception during update");
            }
            return false;
        }

        public Transaction selectById(int id) throws DAOException {
            try (Statement statement = ConnBuilder.connection.createStatement()){
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users u where u.id =" + id);
                User user = null;
                if (resultSet.next())
                {
                    Transaction = fetch(resultSet);
                }
                return (entities.Transaction) Transaction;
            } catch (SQLException e) {
                throw new DAOException("exception during select by id"+id);
            }
        }

        public boolean insert(Transaction  transaction ) throws DAOException {
            try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement
                    ("INSERT INTO transaction VALUES (NULL, ?, ?, ?)")){
                preparedStatement.setString(1,  transaction.getDate());
                preparedStatement.setInt(2, transaction.getUserId());
                preparedStatement.setDouble(3,transaction.getPrice());
                preparedStatement.setInt(4, transaction.getBookId());
                preparedStatement.setInt(5,transaction.getId());


                int i = preparedStatement.executeUpdate();

                if (i==1){
                    return true;
                }
            } catch (SQLException ex){
                throw new DAOException("exception during insert user");
            }
            return false;
        }

        public void delete(Transaction transaction) throws DAOException {
            if (transaction .contains(transaction)) {
                transaction.remove(transaction);
            } else {
                throw new DAOException("cant delete because user doesnt exist");
            }
        }

        public void deleteById ( int id) throws DAOException{
            try (Statement stmt = ConnBuilder.connection.createStatement()){
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM Transactions u WHERE u.id =?");
                Transaction transaction = null;
                if (resultSet.next())
                {
                    Transaction= fetch(resultSet);
                }
            } catch (SQLException e){
                throw new DAOException("exception during de;ete by id" + id);
            }
        }


        private  Transaction fetch(ResultSet resultSet) throws SQLException {
            Transaction transaction = new  Transaction();
            transaction.setPrice(resultSet.getDouble("price"));
            transaction.setUserId(resultSet.getInt("userId"));
            transaction.setBookId(resultSet.getInt("bookId"));
            transaction.setDate(resultSet.getString("data"));


            return  transaction;
        }
    }
