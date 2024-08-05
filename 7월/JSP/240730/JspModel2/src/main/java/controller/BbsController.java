package controller;

import dao.BbsDao;
import dto.BbsDto;
import dto.MemberDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class BbsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProc(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doProc(req, resp);
    }

    public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        BbsDao dao = BbsDao.getInstance();
        String param = req.getParameter("param");

        if (param.equals("bbslist")) {
            System.out.println("bbslist");

            String category = req.getParameter("category");
            System.out.println("category: " + category);
            String keyword = req.getParameter("keyword");
            System.out.println("keyword: " + keyword);
            if(category == null || category.equals("")) {
                category = "";
            }
            if(keyword == null || keyword.equals("")) {
                keyword="";
            }

            List<BbsDto> list = dao.getBbsSearchlist(category, keyword);
            System.out.println("list >> " +list.size());
            req.setAttribute("list", list); // 짐싸
            req.getRequestDispatcher("bbslist.jsp").forward(req, resp); // 잘가
        }
        else if (param.equals("bbsdetail")) {
            System.out.println("bbsdetail");

            int seq = Integer.parseInt(req.getParameter("seq"));

            BbsDto bbs = dao.getBbs(seq);

            req.setAttribute("bbs", bbs);
            req.getRequestDispatcher("bbsdetail.jsp").forward(req, resp);
        }
        else if (param.equals("bbswrite")) {
            System.out.println("bbswrite");

            // session 에서 로그인 상태 확인
            HttpSession session = req.getSession();
            MemberDto member = (MemberDto) session.getAttribute("login");

            if (member == null) {
                resp.sendRedirect("login.jsp");
                return;
            }

            // 게시글 작성 페이지로 포워딩
            req.getRequestDispatcher("bbswrite.jsp").forward(req, resp);
        }
        else if (param.equals("bbswriteAf")) {
            System.out.println("bbswriteAf");

            String id = req.getParameter("id");
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            boolean isS = dao.bbswrite( new BbsDto(id, title, content));
            if(isS){
                System.out.println("글 작성 성공");
                req.setAttribute("bbswrite", "BBSWRITE_OK");
                req.getRequestDispatcher("message.jsp").forward(req, resp);
            }else{
                System.out.println("글 작성 실패");
                req.setAttribute("bbswrite", "BBSWRITE_NG");
                req.getRequestDispatcher("message.jsp").forward(req, resp);
            }
        }
        else if(param.equals("bbsupdate")){
            System.out.println("bbsupdate");

            int seq = Integer.parseInt(req.getParameter("seq"));
            BbsDto bbs = dao.getBbs(seq);
            if (bbs != null) {
                req.setAttribute("bbs", bbs);
                req.getRequestDispatcher("bbsupdate.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("bbslist.jsp");
            }
        }
        else if (param.equals("bbsupdateAf")) {
            System.out.println("bbsupdateAf");
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int seq = Integer.parseInt(req.getParameter("seq"));


            boolean result = dao.updateBbs(seq, title, content);

            if (result) {
                req.setAttribute("bbsupdate", "BBSUPDATE_OK");
            } else {
                req.setAttribute("bbsupdate", "BBSUPDATE_NG");
            }

            req.getRequestDispatcher("message.jsp").forward(req, resp);
        }

    }
}
