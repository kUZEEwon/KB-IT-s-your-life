package com.multi.web04.controller;

import com.multi.web04.dao.ProductDAO;
import com.multi.web04.vo.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController {
   private ProductDAO productDAO = new ProductDAO();

    public void insert(HttpServletRequest request, HttpServletResponse response)  throws IOException, ServletException {
        ProductVO product = new ProductVO();
        product.setName(request.getParameter("name"));
        product.setId(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        product.setPrice(price);

        productDAO.insertProduct(product);
        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("views/product_result.jsp");
        rd.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String id = request.getParameter("id");
        productDAO.deleteProduct(id);
        request.setAttribute("product_id", id);
        RequestDispatcher rd = request.getRequestDispatcher("views/product_result.jsp");
        rd.forward(request, response);
    }
}
