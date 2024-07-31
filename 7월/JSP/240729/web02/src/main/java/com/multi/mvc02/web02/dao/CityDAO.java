package com.multi.mvc02.web02.dao;

import com.multi.mvc02.web02.co.CityVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "1234";

    // 싱글톤 인스턴스
    private static CityDAO instance;

    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하도록 합니다.
    private CityDAO() {
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 싱글톤 인스턴스를 얻는 메서드
    public static synchronized CityDAO getInstance() {
        if (instance == null) {
            instance = new CityDAO();
        }
        return instance;
    }

    // 도시 정보를 삽입하는 메서드
    public String insert(CityVO city) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 데이터베이스 연결
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                return "success";
            } else {
                return "failure";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<CityVO> getAllCities() {
        List<CityVO> cities = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            // SQL 쿼리 준비
            String sql = "SELECT ID, Name, CountryCode, District, Population FROM city";
            pstmt = conn.prepareStatement(sql);

            // 쿼리 실행
            rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                CityVO city = new CityVO();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("Name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(rs.getInt("Population"));
                cities.add(city);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return cities;
    }
}
