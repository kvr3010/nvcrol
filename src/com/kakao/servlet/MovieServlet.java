package com.kakao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kakao.db.MovieDAO;
import com.kakao.db.MovieDAOImpl;
import com.kakao.search.ApiExamSearchBlog;
import com.kakao.search.NvMovie;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MovieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");

		Gson gson = new Gson();
		
		
		MovieDAO mv = new MovieDAOImpl();
		String jsonData = gson.toJson(mv.movie_rank());
		System.out.println(jsonData);
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
