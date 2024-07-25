package main;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MainClass {
    public static void main(String[] args) {

        // JDBC(JAVA DataBase Connectivity)

        // project에 jdbc.Driver가 추가되어 있는지?
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Driver loading Successful");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection con = null;
        // url, user, pw
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","1234");

            System.out.println("MySQL connection Successful"); // DB 연결 완료
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String id = "abc";
        String name = "melody";
        int age = 32;
        String joindate = "2024-07-22";


        // SQL 쿼리문
        String sql = "insert into user (id, name, age, joindate) values ('"
                + id + "', '"
                + name + "', "
                + age + ", "
                + "now())";

        int count = 0;

        // connection
        // Statement => preparedStatement
        Statement stmt = null;
        try {
            stmt= con.createStatement(); // 접속초기화

            // auto commit 종료
            // con.setAutoCommit(false);

            // 실행
            count = stmt.executeUpdate(sql);

            System.out.println("Inserted " + count + " records Successfully");
           // con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 후처리(close)
            // con.rollback();
            try {
                if (stmt != null) {
                        stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
