package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // project에 jdbc.Driver가 추가되어 있는지?
    public static void initConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loading Successful");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        // url, user, pw
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","1234");

            System.out.println("MySQL connection Successful"); // DB 연결 완료
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}
