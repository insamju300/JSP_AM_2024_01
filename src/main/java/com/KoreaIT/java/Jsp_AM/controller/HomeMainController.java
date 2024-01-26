package com.KoreaIT.java.Jsp_AM.controller;

import java.util.Map;

import jakarta.servlet.http.HttpSession;

//@WebServlet("/home/main")
public class HomeMainController implements Controller {

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		// TODO Auto-generated method stub
		return "/jsp/home/main.jsp";
	}

}
