    package dao.impl;

    import Exceptions.DAOException;
    import dao.connection.ConnBuilder;
    import entities.Account;
    import entities.Transaction;
    import entities.User;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;

    public class AccountDAO {

        public boolean update(Account account) throws DAOException {
            try (PreparedStatement ps = ConnBuilder.connection.prepareStatement
                    ("UPDATE  Account SET  username=?,password =?,  role =?  WHERE user_id=?")) {


                ps.setString(1, account.getUserName());
                ps.setString(2, account.getPassword());
                ps.setString(3, account.getRole());
                ps.setInt(4, account.getUserId());

                int i = ps.executeUpdate();

                if (i == 1) {
                    return true;
                }
            } catch (SQLException e) {
                throw new DAOException("exception during update");
            }
            return false;
        }

        public Account selectById(int id) throws DAOException {
            try (Statement statement = ConnBuilder.connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM account u where u.id =" + id);
                Account account = null;
                if (resultSet.next()) {
                    account = fetch(resultSet);
                }
                return account;
            } catch (SQLException e) {
                throw new DAOException("exception during select by id" + id);
            }
        }

        public boolean insert(Account account) throws DAOException {
            try (PreparedStatement preparedStatement = ConnBuilder.connection.prepareStatement
                    ("INSERT INTO account(username,password,role,user_id) VALUES ( ?, ?, ?,?)")) {

                preparedStatement.setString(1, account.getUserName());
                preparedStatement.setString(2, account.getPassword());
                preparedStatement.setString(3, "user");
                preparedStatement.setInt(4, account.getUserId());


                int i = preparedStatement.executeUpdate();

                if (i == 1) {
                    return true;
                }
            } catch (SQLException ex) {
                throw new DAOException("exception during insert user");
            }
            return false;
        }


        private Account fetch(ResultSet resultSet) throws SQLException {
            Account account = new Account();
            account.setPassword(resultSet.getString("password"));
            account.setRole(resultSet.getString("role"));
            account.setUserId(resultSet.getInt("id"));
            account.setUserName(resultSet.getString("username"));
            account.setUserId(resultSet.getInt("user_id"));


            return account;
        }

        public Account selectByUsernameAndPassword(String username, String password) throws DAOException {
            try (Statement statement = ConnBuilder.connection.createStatement()) {
                String sql = "SELECT * FROM account u where u.username ='" + username + "' and u.password ='" + password+"'";
                ResultSet resultSet = statement.executeQuery(
                        sql);
                Account account = null;
                if (resultSet.next()) {
                    account = fetch(resultSet);
                }
                System.out.println(username+password);
                return account;
            } catch (SQLException e) {
                throw new DAOException("exception during select by username" + username);
            }
        }
    }