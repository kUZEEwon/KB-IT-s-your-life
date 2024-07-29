package com.example.jsp_02;

import com.example.jsp_02.db.UserDAO;
import com.example.jsp_02.db.UserVO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/insertUser.do")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력정보 추출

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);

		UserDAO dao = new UserDAO();
		dao.insertUser(vo);

		// 페이지 넘김, 주소를 호출( 서버에서 호출 forward ==> 결과를 출력해서 응답)

		// 3. 화면 이동
		//서버가 호출하여 실행결과를 클라이언트에게 전달,
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

		//클라이언트에게 호출하도록 명령 ==> 다음 페이지를 호출하라고 명령
		//response.sendRedirect("/index.jsp");
	}
}



