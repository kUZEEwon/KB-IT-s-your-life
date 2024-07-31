import dao.MemberDao;
import dto.MemberDto;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String param = request.getParameter("param");

        if (param.equals("login")) {
            response.sendRedirect("login.jsp"); // login.jsp로 이동
        }
        else if (param.equals("account")) {
            response.sendRedirect("account.jsp"); // login.jsp로 이동
        }
        else if (param.equals("idcheck")) {
           String id= request.getParameter("id");

            MemberDao dao = MemberDao.getInstance();
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

            MemberDao dao = MemberDao.getInstance();

            boolean isS = dao.insertMember(new MemberDto(id, pw,name, email,0));
            System.out.println(isS);
            if (isS) {
                response.sendRedirect("login.jsp");
            }
            else {
                response.sendRedirect("account.jsp");
            }
        }
        else if (param.equals("loginAf")) {
            String id= request.getParameter("id");
            String pw = request.getParameter("pw");

            MemberDao dao = MemberDao.getInstance();
            MemberDto member =  dao.login(id,pw);
            if (member != null) {
                // 로그인 성공
                System.out.println("login success");
            }else {
                System.out.println("login fail");
            }

        }
    }
}
