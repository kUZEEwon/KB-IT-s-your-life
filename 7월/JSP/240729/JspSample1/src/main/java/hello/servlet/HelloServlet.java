package hello.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doProcess(request, response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String fruit = request.getParameter("fruits");
        String[] hobby = request.getParameterValues("hobby");

        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter(); // 사용을 잘 하지 않음
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet HelloServlet</h1>");
        out.println("Name: " + name + "<br/>");
        out.println("Age: " + age + "<br/>");
        out.println("Fruits: " + fruit + "<br/>");
        for (int i = 0; i < hobby.length; i++) {
            out.println("hobby: " + hobby[i] + "<br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
