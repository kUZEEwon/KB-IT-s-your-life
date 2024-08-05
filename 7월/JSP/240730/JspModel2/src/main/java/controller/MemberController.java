package controller;

import dao.MemberDao;
import dto.MemberDto;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Member")
public class MemberController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        MemberDao dao = MemberDao.getInstance();
        String param = request.getParameter("param");

        if (param.equals("login")) {
            response.sendRedirect("login.jsp"); // login.jsp로 이동
        }
        else if (param.equals("account")) {
            response.sendRedirect("account.jsp"); // login.jsp로 이동
        }
        else if (param.equals("idcheck")) {
           String id= request.getParameter("id");


            boolean isS = dao.getId(id);

            String msg = "YES";
            if (isS) {
                msg = "NO";
            }
            System.out.println(msg);
            // Ajax로 보낼때
            JSONObject obj = new JSONObject();
            obj.put("msg", msg);        // 짐 싸

            response.setContentType("application/x-json; charset=UTF-8");
            response.getWriter().print(obj);
        }
        else if (param.equals("accountAf")) {
            String id= request.getParameter("id");
            String pw = request.getParameter("pw");
            String name =request.getParameter("name");
            String email =request.getParameter("email");

//            MemberDao dao = MemberDao.getInstance();

            boolean isS = dao.insertMember(new MemberDto(id, pw,name, email,0));
            System.out.println(isS);
            if (isS) {
               // response.sendRedirect("login.jsp");
                request.setAttribute("message", "MESSAGE_YES");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
            else {
                request.setAttribute("message", "MESSAGE_NO");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
        }
        else if (param.equals("loginAf")) {
            String id= request.getParameter("id");
            String pw = request.getParameter("pw");

            MemberDto member =  dao.login(id,pw);
            if (member != null && !member.getId().equals("")) {
                // member가 null이 아니고 id가 빈문자열이 아닐 때
                // 로그인 성공
                System.out.println("login success");

                // 세션에 로그인 정보 저장
                HttpSession session = request.getSession();
                session.setAttribute("login", member); // 로그인한 사용자 정보 저장
                session.setMaxInactiveInterval(60 * 60 * 24 * 7); // 세션 유효 시간 설정: 1주일

                request.setAttribute("login", "LOGIN_OK");

            }else {
                System.out.println("login fail");
                request.setAttribute("login", "LOGIN_NG");

            }
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
