package dao.impl;

import Exceptions.DAOException;
import dao.connection.ConnBuilder;
import entities.Account;
import entities.Author;
import entities.Category;
import entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public boolean update(Category category) throws DAOException {
        try (PreparedStatement ps = ConnBuilder.connection.prepareStatement("\n" +
                "UPDATE  category SET  category=? where id=?")) {
            ps.setString(1, category.getCategory());
            ps.setInt(5, category.getId());

            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("exception during update");
        }
        return false;
    }

    public Category selectById(int id) throws DAOException {
        try (Statement statement = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM category u where u.id =" + id);
            Category category = null;
            if (resultSet.next())
            {
                category = fetch(resultSet);
            }
            return category;
        } catch (SQLException e) {
            throw new DAOException("exception during select by id"+id);
        }
    }

    public boolean insert(Category category) throws DAOException {
        try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement("INSERT INTO category(category) VALUES ( ?)")){
            preparedStatement.setString(1,category.getCategory());


            int i = preparedStatement.executeUpdate();

            if (i==1){
                return true;
            }
        } catch (SQLException ex){
            throw new DAOException("exception during insert category");
        }
        return false;
    }

    public void delete(Category category) throws DAOException {
        try (Statement sp = ConnBuilder.connection.createStatement()) {
            ResultSet resultSet = sp.executeQuery("DELETE * FROM category");
           Category category1= null;
            if (resultSet.next()) {
                category = fetch(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("exception during deleting");
        }
    }

    public void deleteById ( int id) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM category u WHERE u.id =" + id);
          Category category= null;
            if (resultSet.next())
            {
            category = fetch(resultSet);
            }
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by id" + id);
        }
    }


    private Category fetch(ResultSet resultSet) throws SQLException {
        Category category = new Category();

        category.setId(resultSet.getInt("id"));
        category.setCategory(resultSet.getString("category"));


        return category;
    }

    public Category selectByCategory(String category) throws DAOException{
        try (Statement stmt = ConnBuilder.connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery(
                    "SELECT * FROM Category u WHERE u.Category =" +category);
            Category category1= null;
            if (resultSet.next())
            {
               category1= fetch(resultSet);
            }
            return null;
        } catch (SQLException e){
            throw new DAOException("exception during de;ete by firstname" + category);
        }
    }
}
