package com.multi.mvc02.web02;


import com.multi.mvc02.web02.co.CityVO;
import com.multi.mvc02.web02.dao.CityDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 정의하는 어노테이션
@WebServlet("/cityList")
public class CityListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DAO 객체 생성 및 데이터 조회
        CityDAO dao = CityDAO.getInstance();
        List<CityVO> cities = dao.getAllCities();

        // 응답 콘텐츠 타입 설정
        response.setContentType("text/html; charset=UTF-8");

        // 출력 스트림을 얻어 HTML 출력
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='ko'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>City 전체 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>City 전체 목록</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>도시 이름</th>");
        out.println("<th>국가 코드</th>");
        out.println("<th>지역</th>");
        out.println("<th>인구</th>");
        out.println("</tr>");

        // 도시 데이터 출력
        for (CityVO city : cities) {
            out.println("<tr>");
            out.println("<td>" + city.getId() + "</td>");
            out.println("<td>" + city.getName() + "</td>");
            out.println("<td>" + city.getCountryCode() + "</td>");
            out.println("<td>" + city.getDistrict() + "</td>");
            out.println("<td>" + city.getPopulation() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        // 자원 해제
        out.close();
    }
}
