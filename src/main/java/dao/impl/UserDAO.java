package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.User;

import java.sql.*;


public class UserDAO{


    public boolean update(User user) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE users SET first_name=?, last_name=?,phone_number=?, status=?, address_id=? WHERE id=?")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhoneNumber());
            ps.setBoolean(4, user.getStatus());
            ps.setInt(5, user.getAddressId());
            ps.setInt(6, user.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public User selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users u where u.id =?");
            User user = null;
            if (resultSet.next())
            {
                user = fetch(resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(User user) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO users(first_name,last_name,phone_number,status,address_id) VALUES (?,?,?,?,?)")){
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setBoolean(4, true);
            preparedStatement.setInt(5, user.getAddressId());

            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert user");
        }
        return false;
    }

    public void delete(User user) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM users");
            User user1 = null;
            if (resultSet.next()) {
                user = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM users u WHERE u.id =?");
            User user = null;
            if (resultSet.next())
            {
                user = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private User fetch(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setPhoneNumber(resultSet.getString("phone_number"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setAddressId(resultSet.getInt("address_id"));
        user.setStatus(resultSet.getBoolean("status"));

        return user;
    }
}
