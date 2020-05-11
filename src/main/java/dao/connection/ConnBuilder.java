package dao.connection;


import java.sql.*;

public class ConnBuilder {

    public static Connection connection;
    public static final String url = "jdbc:mysql://localhost:3306/info";
    public static final String username = "root";
    public static final String password = "123456";

    static {
        try {
            connection =DriverManager.getConnection(url,username,password);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
