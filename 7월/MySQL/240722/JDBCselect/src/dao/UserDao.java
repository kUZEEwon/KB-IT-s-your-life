package dao;

import db.*;
import dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // Data Access Object

    public int UserInsert(UserDto user){
        DBConnection.initConnection();

        // SQL 쿼리문
        String sql = "insert into user (id, name, age, joindate) values ('"
                + user.getId() + "', '"
                + user.getName() + "', "
                + user.getAge() + ", "
                + "now())";

        Connection con = DBConnection.getConnection();
        Statement stmt = null;
        int count = 0;

        try {
            stmt= con.createStatement(); // 접속초기화


            // 실행
            count = stmt.executeUpdate(sql);    // insert delete update

            System.out.println("Inserted " + count + " records Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 항상 닫아줘야 함
            DBClose.close(con, stmt, null);
        }
        return count;
    }

    public int UserUpdate(UserDto user){
        DBConnection.initConnection();

        // SQL 쿼리문
        String sql = "update user set name = ?, age = ? where id = ?";

        Connection con = null;

        PreparedStatement psmt = null;    // query문 실행


        int age = 44;
        String name = "James";
        int count = 0;

        try {
            con = DBConnection.getConnection();

            psmt = con.prepareStatement(sql);


            psmt.setString(1, name);
            psmt.setInt(2, age);
            psmt.setString(3, user.getId());
            count = psmt.executeUpdate();
            System.out.println("Updated " + count + " records Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 항상 닫아줘야 함
            DBClose.close(con, null, null);
        }
        return count;
    }

    public int UserDelete(UserDto user){
        DBConnection.initConnection();

        // SQL 쿼리문
        String sql = "DELETE FROM user WHERE id = ?";

        Connection con = null;
        PreparedStatement psmt = null;
        int count = 0;


        try {
            con = DBConnection.getConnection();

            psmt = con.prepareStatement(sql);

            // 파라미터 설정
            psmt.setString(1, user.getId());

            count = psmt.executeUpdate();
            System.out.println("Deleted " + count + " records Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 항상 닫아줘야 함
            DBClose.close(con, psmt, null);
        }
        return count;
    }

    // Select One - 1개만 조회
    public UserDto getUser(String id) {
        String sql = "select id, name, age, joindate"
                    + " from user"
                    + " where id = ? ";

        Connection conn = null;         // db와의 접속
        PreparedStatement psmt = null;    // query문 실행
        ResultSet rs = null;            // 결과를 추출

        UserDto user = null;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);

            rs = psmt.executeQuery();
            if (rs.next()) {
                 // 데이터가 있음
                //  String userid = rs.getString("id");
                String userid = rs.getString(1); // 1번째 열을 가져오기
                String username = rs.getString(2);
                int age = rs.getInt(3);
                String joindate = rs.getString(4);

                user = new UserDto(userid, username, age, joindate);
            }
            System.out.println("정상 처리 되었습니다.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBClose.close(conn, psmt, rs);
        }
        return user;
    }

    // Select List - 여러개 조회
    public List<UserDto> getAllUsers() {
        String sql = "select id, name, age, joindate"
                + " from user";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        List<UserDto> users = new ArrayList<UserDto>();

        try {
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                // 데이터가 있음

                String userid = rs.getString(1); // 1번째 열을 가져오기
                String username = rs.getString(2);
                int age = rs.getInt("age");
                String joindate = rs.getString("joindate");

               users.add(new UserDto(userid, username, age, joindate));
            }
            System.out.println("정상 처리 되었습니다.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBClose.close(conn, psmt, rs);
        }


        return users;
    }
}
