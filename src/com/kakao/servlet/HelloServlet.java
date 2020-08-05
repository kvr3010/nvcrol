package com.kakao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") //주소
public class HelloServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

    //접근제어 protected
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String email = request.getParameter("email");
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		System.out.println("시스템 콘솔창 출력");
		out.print("클라이언트 브라우저 화면에 출력");
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
