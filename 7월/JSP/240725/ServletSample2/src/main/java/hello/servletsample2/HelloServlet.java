package hello.servletsample2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet( "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        // servlet == java(html)
        // jsp == html(java)
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String fruit = request.getParameter("fruit");


        // 응답용 html
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("<body>");
        out.println("<h1> hello servlet </h1>");

        out.println("<h2>Name: " + name + "</h2>");
        out.println("<h2>Age: " + age + "</h2>");
        out.println("<h2>Fruit: " + fruit + "</h2>");

        out.println("</body>");
        out.println("</head>");
        out.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // servlet == java(html)
        // jsp == html(java)
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String fruit = request.getParameter("fruit");


        // 응답용 html
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("<body>");
        out.println("<h1> hello servlet </h1>");

        out.println("<h2>Name: " + name + "</h2>");
        out.println("<h2>Age: " + age + "</h2>");
        out.println("<h2>Fruit: " + fruit + "</h2>");

        out.println("</body>");
        out.println("</head>");
        out.println("</body>");
    }
}