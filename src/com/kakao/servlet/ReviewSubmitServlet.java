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
import com.kakao.dto.ReviewDTO;
import com.kakao.dto.UserDTO;


@WebServlet("/ReviewSubmitServlet")
public class ReviewSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO dao = new ReviewDAOImpl();
		ReviewDTO dto = new ReviewDTO();
		
		String title = request.getParameter("hanjul");
		String nae = request.getParameter("sangse");
		int mb_num = Integer.parseInt(request.getParameter("unum"));
		int mv_num = Integer.parseInt(request.getParameter("mnum"));
		
		dto.setMb_num(mb_num);
		dto.setMv_num(mv_num);
		dto.setTitle(title);
		dto.setNae(nae);
		
		dao.review_insert(dto);
		
		
//		PrintWriter out = response.getWriter();		
//		UserDAO dao = new UserDAOImpl();
//		
//		if(dao.select(email)) {
//			out.println("ok");
//		}

	}

//		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//		dis.forward(request, response);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
