package com.kakao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.search.ApiExamSearchBlog;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// view(jsp,html)에서 넘어 오는 데이터 search 값을 받아준다
		// 네이버API를 활용해서 정보를 가져온다(json형태)
		// view쪽에 정보를 출력하면 끝
		request.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		System.out.println(search);
		String jsonData = ApiExamSearchBlog.main(search); //이거 안되면 메소드로 새로 만들기
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(jsonData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
