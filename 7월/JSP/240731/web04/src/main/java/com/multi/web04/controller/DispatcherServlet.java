package com.multi.web04.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private ProductController productController = new ProductController();
    private CustomerController customerController = new CustomerController();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/product_insert")) {
            productController.insert(request, response);
        } else if (uri.equals("/product_delete")) {
            productController.delete(request, response);
        } else if (uri.equals("/customer_insert")) {
            customerController.insert(request, response);
        } else if (uri.equals("/customer_delete")) {
            customerController.delete(request, response);
        }
    }
}
