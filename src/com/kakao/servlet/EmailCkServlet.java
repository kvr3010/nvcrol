package com.kakao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.db.*;
import com.kakao.dto.UserDTO;


@WebServlet("/EmailCkServlet")
public class EmailCkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailCkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println(email);
		PrintWriter out = response.getWriter();		
		UserDAO dao = new UserDAOImpl();
		
		if(dao.select(email)) {
			out.println("ok");
		}

	}

//		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//		dis.forward(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
