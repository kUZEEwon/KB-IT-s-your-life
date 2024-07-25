package org.example.jsp_01;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet2() {
        System.out.println("===> LoginServlet2 생성");
    }

    public void init() throws ServletException {
        System.out.println("---> init() 호출");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("---> service() 호출");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("---> doGet() 호출");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("---> doPost() 호출");
    }

    public void destroy() {
        System.out.println("---> destroy() 호출");
    }
}
