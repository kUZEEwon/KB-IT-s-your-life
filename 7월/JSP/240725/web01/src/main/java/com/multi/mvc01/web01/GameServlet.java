package com.multi.mvc01.web01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/game")
public class GameServlet extends HttpServlet {
    @Override
    public void init()throws ServletException {
        super.init();
        System.out.println("GameServlet 초기화");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GameServlet doGet 처리됨");
        request.setCharacterEncoding("UTF-8");

        String gameName = request.getParameter("gameName");
        String gameType = request.getParameter("gameType");

        response.setContentType("text/html;charset=UTF 8");
        response.getWriter().append("<h1>POST request received in GameServlet</h1>")
                .append("<p>Game Name: ").append(gameName).append("</p>")
                .append("<p>Game Score: ").append(gameType).append("</p>");
        System.out.println("GameServlet doPost 처리됨");
        System.out.println("Game Name: " + gameName);
        System.out.println("Game Score: " + gameType);


    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("GameServlet 소멸됨");
    }
}
