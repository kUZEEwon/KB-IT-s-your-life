package com.multi.web04_mvc2.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private ProductController productController = new ProductController();
    private CustomerContoller customerController = new CustomerContoller();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 호출");
        doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 호출");
        doProc(req, resp);
    }


    public void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String uri = request.getRequestURI();
        System.out.println("Request URI: " + uri);


        if (uri.equals("/customer_insert")) {
            customerController.insert(request, response);
        } else if (uri.equals("/customer_delete")) {
            customerController.delete(request, response);
        } else if (uri.equals("/product_insert")) {
            productController.insert(request, response);
        } else if (uri.equals("/product_delete")) {
            productController.delete(request, response);
        } else if (uri.equals("/product_list")) {
            productController.list(request, response);
        } else if (uri.equals("/customer_list")) {
            customerController.list(request, response);
        }
    }
}
