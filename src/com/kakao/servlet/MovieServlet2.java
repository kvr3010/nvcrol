package com.kakao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.db.MovieDAO;
import com.kakao.db.MovieDAOImpl;
import com.kakao.dto.MovieDTO;


@WebServlet("/MovieServlet2")
public class MovieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieServlet2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");

		
		MovieDAO mv = new MovieDAOImpl();
		ArrayList<MovieDTO> dlist = mv.movie_rank();
		request.setAttribute("movielist", dlist);
		RequestDispatcher dis = request.getRequestDispatcher("movie2.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
