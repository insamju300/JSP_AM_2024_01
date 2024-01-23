package com.KoreaIT.java.Jsp_AM.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class IdCheckServlet
 */

@WebServlet("/member/idDuplicateCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		String loginId = (String)request.getParameter("loginId");
		System.out.println(loginId);
		if(loginId.length()>10) {
		    response.getWriter().print(true);
		}else {
			response.getWriter().print(false);
		}
	}

}
