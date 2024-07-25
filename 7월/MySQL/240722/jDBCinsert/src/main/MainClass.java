package main;

import db.*;
import java.sql.*;

public class MainClass {

    public static void main(String[] args) {
        DBConnection.initConnection();
        // insert
        String id = "bsc";
        String name = "hello";
        int age = 20;


        // SQL 쿼리문
        String sql = "insert into user (id, name, age, joindate) values ('"
                + id + "', '"
                + name + "', "
                + age + ", "
                + "now())";

        Connection con = DBConnection.getConnection();
        Statement stmt = null;
        int count = 0;

        try {
            stmt= con.createStatement(); // 접속초기화

            // auto commit 종료
            // con.setAutoCommit(false);

            // 실행
            count = stmt.executeUpdate(sql);    // insert delete update

            System.out.println("Inserted " + count + " records Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 항상 닫아줘야 함
            DBClose.close(con, stmt, null);
        }
    }
}
