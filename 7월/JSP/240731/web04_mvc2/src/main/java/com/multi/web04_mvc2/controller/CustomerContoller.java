package com.multi.web04_mvc2.controller;



import com.multi.web04_mvc2.dao.CustomerDAO;
import com.multi.web04_mvc2.dto.CustomerDto;
import com.multi.web04_mvc2.dto.ProductDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerContoller {
    private CustomerDAO customerDAO = CustomerDAO.getInstance();


    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        CustomerDto customer = new CustomerDto();
        customer.setId(request.getParameter("id"));
        customer.setName(request.getParameter("name"));
        customer.setEmail(request.getParameter("email"));

        boolean isInserted = customerDAO.insertCustomer(customer);
        request.setAttribute("customer", customer);
        request.setAttribute("isInserted", isInserted);

        RequestDispatcher rd = request.getRequestDispatcher("views/customer_result.jsp");
        rd.forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");

        boolean isDeleted = customerDAO.deleteCustomer(id);

        request.setAttribute("customer_id", id);
        request.setAttribute("isDeleted", isDeleted);

        RequestDispatcher rd = request.getRequestDispatcher("views/customer_result.jsp");
        rd.forward(request, response);
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CustomerDto> customers = customerDAO.getAllCustomers();
        request.setAttribute("customers", customers);

        RequestDispatcher rd = request.getRequestDispatcher("views/customer_list.jsp");
        rd.forward(request, response);
    }
}
