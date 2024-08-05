package com.multi.web04_mvc2.controller;

import com.multi.web04_mvc2.dao.ProductDAO;
import com.multi.web04_mvc2.dto.ProductDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductController {
    private ProductDAO productDAO = ProductDAO.getInstance();

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDto product = new ProductDto();
        product.setName(request.getParameter("name"));
        product.setId(request.getParameter("id"));

        try {
            int price = Integer.parseInt(request.getParameter("price"));
            product.setPrice(price);
        } catch (NumberFormatException e) {
            // 가격 파싱 중 오류 발생 시 처리
            request.setAttribute("error", "가격을 올바르게 입력해주세요.");
            RequestDispatcher rd = request.getRequestDispatcher("views/error.jsp");
            rd.forward(request, response);
            return;
        }

        boolean isInserted = productDAO.insertProduct(product);
        request.setAttribute("product", product);
        request.setAttribute("isInserted", isInserted);

        RequestDispatcher rd = request.getRequestDispatcher("views/product_result.jsp");
        rd.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");

        boolean isDeleted = productDAO.deleteProduct(id);
        request.setAttribute("product_id", id);
        request.setAttribute("isDeleted", isDeleted);

        RequestDispatcher rd = request.getRequestDispatcher("views/product_result.jsp");
        rd.forward(request, response);
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProductDto> products = productDAO.getAllProducts();
        request.setAttribute("products", products);

        RequestDispatcher rd = request.getRequestDispatcher("views/product_list.jsp");
        rd.forward(request, response);
    }
}
