//package com.kakao.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//
//import com.google.gson.Gson;
//import com.kakao.db.MovieDAO;
//import com.kakao.db.MovieDAOImpl;
//import com.kakao.search.ApiExamSearchBlog;
//import com.kakao.search.NvMovie;
//
//@WebServlet("/MovieDbServlet")
//public class MovieDbServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//    public MovieDbServlet() {
//        super();
//    }
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("application/json; charset=UTF-8");
//		
//		ArrayList<String> jsonData = NvMovie.movie();
//		Gson gson = new Gson();
//		ArrayList<String> jsonn = new ArrayList<String>();
//		
//		MovieDAO dao = new MovieDAOImpl();
//
//		
//		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
//
//		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
//		Document doc = Jsoup.connect(url).get();
//		System.out.println("Title : 네이버 영화정보 크롤링해서 DB저장");
//		
//		
//		
//		
//		
//		PrintWriter out = response.getWriter();
//		out.println(jsonData);
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
