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

import com.google.gson.Gson;
import com.kakao.db.*;
import com.kakao.dto.ReviewDTO;
import com.kakao.dto.UserDTO;


@WebServlet("/ReviewOutServlet")
public class ReviewOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		Gson gson = new Gson();
		
		
		ReviewDAO mv = new ReviewDAOImpl();
		String jsonData = gson.toJson(mv.review_load());
		System.out.println(jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);

	}

//		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//		dis.forward(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
