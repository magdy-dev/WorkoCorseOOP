package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Address;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {


    public boolean update(Address address) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("UPDATE address SET country=?,region=?,street=?, apartment=? WHERE id=?")) {
            ps.setString(1,address.getCountry());
            ps.setString(2, address.getRegion());
            ps.setString(3, address.getStreet());
            ps.setInt(4, address.getApartment());
            ps.setInt(5,address.getId());


            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Address selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address u where u.id =" + id);
            Address address= null;
            if (resultSet.next())
            {
                address = fetch(resultSet);
            }
            return address;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(Address address) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO address (country ,region,street,apartment) VALUES(?,?,?,?)")){
            preparedStatement.setString(1,address.getCountry());
            preparedStatement.setString(2, address.getRegion());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getApartment());


            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert address");
        }
        return false;
    }

    public void delete(Address address) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM address");
          Address address1 = null;
            if (resultSet.next()) {
                address1 = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM address u WHERE u.id =" + id);
            Address address = null;
            if (resultSet.next())
            {
             address = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Address fetch(ResultSet resultSet) throws SQLException {
      Address address= new Address();

        address.setId(resultSet.getInt("id"));
       address.setApartment(resultSet.getInt("apartment"));
       address.setCountry(resultSet.getString("country"));
       address.setRegion(resultSet.getString("region") );
       address.setStreet(resultSet.getString("street"));
        return address;
    }
}