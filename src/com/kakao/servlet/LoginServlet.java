package com.kakao.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.db.*;
import com.kakao.dto.UserDTO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		System.out.println(email);
		System.out.println(pw);
		
		//디비 연결, 이메일 패스워드 확인, 있으면 있다 없으면 없다.
		UserDAO dao = new UserDAOImpl();
		UserDTO dto = dao.user_select(email, pw);
		if(dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
		}
		response.sendRedirect("logincheck.jsp");

	}

//		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//		dis.forward(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
