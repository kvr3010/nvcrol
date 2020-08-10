package com.kakao.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.kakao")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String [] arrUri = uri.split("/");
		String site = null;
		uri = arrUri[2];
//		for (String string : arrUri) {
//			System.out.println(string);
//			
//		}
//		System.out.println("내가 찾고 싶은 문자열: "+ arrUri[2]);
		
		
		if(uri.equals("main.kakao")) {
			site = "main.jsp";
		}else if(uri.equals("join.kakao")) {
			site = "join.jsp";
		}else if(uri.equals("joinok.kakao")) {
			site = "JoinServlet";
		}else if(uri.equals("emailck.kakao")) {
			site = "EmailCkServlet";
		
		}else if(uri.equals("login.kakao")) {
			site = "login.jsp";
		}else if(uri.equals("loginok.kakao")) {
			site = "LoginServlet";
		
		}else if(uri.equals("search.kakao")) {
			site = "search.jsp";
		}else if(uri.equals("searchok.kakao")) {
			site = "SearchServlet";
		
		}else if(uri.equals("food.kakao")) {
			site = "foodsearch.jsp";
		}else if(uri.equals("foodok.kakao")) {
			site = "FoodSearchServlet";
		
		}else if(uri.equals("movie.kakao")) {
			site = "movie.jsp";
		}else if(uri.equals("movieok.kakao")) {
			site = "MovieServlet";
			
		}else if(uri.equals("movie2.kakao")) {
			site = "MovieServlet2";
		}
		
		else if(uri.equals("review.kakao")) {
			site = "review.jsp";
		}else if(uri.equals("reviewsubmit.kakao")) {
			site = "ReviewSubmitServlet";
		
		}else if(uri.equals("logout.kakao")) {
			site = "logout.jsp";
		}else{
			site = "404.jsp";
			System.out.println("error");
		}
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);
		
		
//		String addr = request.getRemoteAddr();
//		int port = request.getRemotePort();
//		String host = request.getRemoteHost();
//		response.getWriter().println(url);
//		response.getWriter().println(addr);
//		response.getWriter().println(port);
//		response.getWriter().println(host);
//		System.out.println(url);
//		System.out.println(host);
//		System.out.println("addr:"+addr);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
