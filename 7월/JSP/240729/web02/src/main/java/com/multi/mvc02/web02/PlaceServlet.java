package com.multi.mvc02.web02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/place")
public class PlaceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 폼 데이터 가져오기
        String place1 = request.getParameter("place1");
        String place2 = request.getParameter("place2");
        String place3 = request.getParameter("place3");

        // 출력하기
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ko\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>입력한 장소</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>입력한 가고 싶은 곳</h1>");
        out.println("<p>장소 1: " + place1 + "</p>");
        out.println("<p>장소 2: " + place2 + "</p>");
        out.println("<p>장소 3: " + place3 + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
