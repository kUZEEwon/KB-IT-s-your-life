package com.multi.web04_mvc2.dao;

import com.multi.web04_mvc2.db.DBClose;
import com.multi.web04_mvc2.db.DBConnection;
import com.multi.web04_mvc2.dto.CustomerDto;
import com.multi.web04_mvc2.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    private static CustomerDAO customerDAO = new CustomerDAO();

    private CustomerDAO() {
        DBConnection.initConnection();
    }
    public static CustomerDAO getInstance() { return customerDAO; }

    public boolean insertCustomer(CustomerDto customer) {
        String sql = "insert into customer values(?,?,?)";
        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, customer.getId());
            psmt.setString(2, customer.getName());
            psmt.setString(3, customer.getEmail());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count>0?true:false;
    }

    public boolean deleteCustomer(String id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;

        try {
            conn = DBConnection.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);

            count = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count > 0;
    }


    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";  // 상품 테이블의 이름이 'product'로 가정

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                CustomerDto customer = new CustomerDto();
                customer.setId(rs.getString("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

}
