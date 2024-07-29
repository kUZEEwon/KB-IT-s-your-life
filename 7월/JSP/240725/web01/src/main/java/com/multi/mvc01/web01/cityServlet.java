package com.multi.mvc01.web01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class cityServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("서블릿 초기화");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("servlet run");
        System.out.println("GET 요청 처리됨");
    }
}
