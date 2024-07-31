package com.multi.mvc02.web02;


import com.multi.mvc02.web02.co.CityVO;
import com.multi.mvc02.web02.dao.CityDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 정의하는 어노테이션
@WebServlet("/cityInsert")
public class CityInsertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 폼 데이터 가져오기
        String name = request.getParameter("name");
        String countryCode = request.getParameter("countryCode");
        String district = request.getParameter("district");
        int population = Integer.parseInt(request.getParameter("population"));

        // CityVO 객체 생성 및 데이터 설정
        CityVO city = new CityVO();
        city.setName(name);
        city.setCountryCode(countryCode);
        city.setDistrict(district);
        city.setPopulation(population);

        // CityDAO 객체 생성 및 데이터 삽입
        CityDAO dao = CityDAO.getInstance();
        String result = dao.insert(city);

        // 결과 출력
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='ko'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>도시 정보 삽입 결과</title>");
        out.println("</head>");
        out.println("<body>");

        if ("success".equals(result)) {
            out.println("<h1>데이터 삽입 성공</h1>");
            out.println("<p>삽입된 도시 정보:</p>");
            out.println("<p>도시 이름: " + city.getName() + "</p>");
            out.println("<p>국가 코드: " + city.getCountryCode() + "</p>");
            out.println("<p>지역: " + city.getDistrict() + "</p>");
            out.println("<p>인구: " + city.getPopulation() + "</p>");
        } else if ("failure".equals(result)) {
            out.println("<h1>데이터 삽입 실패</h1>");
        } else {
            out.println("<h1>데이터 삽입 중 오류 발생</h1>");
            out.println("<p>" + result + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
