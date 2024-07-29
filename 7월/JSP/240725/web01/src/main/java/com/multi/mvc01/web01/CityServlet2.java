package com.multi.mvc01.web01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CityServlet2 extends HttpServlet {


    @Override
    public void init()throws ServletException {
        super.init();
        System.out.println("CityServlet2 초기화");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CityServlet2() GET요청 처리됨.");

        String cityName = request.getParameter("cityName");
        String cityPopulation = request.getParameter("cityPopulation");
        response.setContentType("text/html;charset=UTF 8");
        response.getWriter()
                        .append("<h1>GET request received</h1>")
                        .append("<p>City Name: ").append(cityName).append("</p>")
                        .append("<p>City Population: ").append(cityPopulation).append("</p>");
        System.out.println("doGet method called");
        System.out.println("City Name: " + cityName);
        System.out.println("City Population: " + cityPopulation);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityName = request.getParameter("cityName");
        String cityPopulation = request.getParameter("cityPopulation");
        response.setContentType("text/html;charset=UTF 8");

        response.getWriter()
                        .append("<h1>POST request received</h1>")
                        .append("<p>City Name: ").append(cityName).append("</p>")
                        .append("<p>City Population: ").append(cityPopulation).append("</p>");
        System.out.println("doPost method called");
        System.out.println("City Name: " + cityName);
        System.out.println("City Population: " + cityPopulation);
    }
}
