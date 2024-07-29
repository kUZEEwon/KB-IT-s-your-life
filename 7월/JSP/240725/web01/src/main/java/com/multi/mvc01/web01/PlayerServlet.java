package com.multi.mvc01.web01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {
    public PlayerServlet() {
        System.out.println("PlayerServlet 초기화");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PlayerServlet doPost 처리됨");
        request.setCharacterEncoding("UTF-8");
        String playerName = request.getParameter("playerName");
        String playerScore = request.getParameter("playerScore");

        response.setContentType("text/html;charset=UTF 8");
        response.getWriter().append("<h1>POST request received in PlayerServlet</h1>")
                        .append("<p>Player Name: ").append(playerName).append("</p>")
                        .append("<p>Player Score: ").append(playerScore).append("</p>");
        System.out.println("PlayerServlet doPost 처리됨");
        System.out.println("Player Name: " + playerName);
        System.out.println("Player Score: " + playerScore);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("PlayerServlet 소멸됨");
    }
}
