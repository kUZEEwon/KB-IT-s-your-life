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

public class ProductDAO {
    private static ProductDAO productDAO = new ProductDAO();

    private ProductDAO() {
        DBConnection.initConnection();
    }

    public static ProductDAO getInstance() {
        return productDAO;
    }

    public boolean insertProduct(ProductDto productDto) {
        String sql = "insert into product values(?,?,?)";
        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;
        System.out.println("insertProduct>> ");

        try {
            conn = DBConnection.getConnection();

            psmt = conn.prepareStatement(sql);
            psmt.setString(1, productDto.getId());
            psmt.setString(2, productDto.getName());
            psmt.setInt(3, productDto.getPrice());

            count = psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBClose.close(conn, psmt, null);
        }

        return count>0?true:false;
    }

    public boolean deleteProduct(String id) {
        String sql = "DELETE FROM product WHERE id = ?";
        Connection conn = null;
        PreparedStatement psmt = null;
        int count = 0;
        System.out.println("deleteProduct>> ");
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

    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = new ArrayList<>();
        String sql = "SELECT * FROM product";  // 상품 테이블의 이름이 'product'로 가정

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psmt = conn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                ProductDto product = new ProductDto();
                product.setId(rs.getString("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
