package com.kakao.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.db.UserDAO;
import com.kakao.db.UserDAOImpl;
import com.kakao.dto.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("login: ").append(request.getContextPath());
//		response.sendRedirect("login.jsp");
//		request.setAttribute("email","a@a.com" ); // String email = "a@a.com";
//		RequestDispatcher dis = request.getRequestDispatcher("");
//		dis.forward(request, response);
		
		//한글처리
		request.setCharacterEncoding("utf-8");

		
		//넘어온 데이터 받기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(phone1);
		System.out.println(phone2);
		//데이터를 DB에 넣고
		UserDTO dto = new UserDTO();
		dto.setEmail(email);
		dto.setName(name);
		dto.setPw(pw);
		dto.setPhone(phone1+phone2);
		UserDAO dao = new UserDAOImpl();
		dao.user_insert(dto);
		//로그인 페이지로 이동
		response.sendRedirect("login.kakao");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
