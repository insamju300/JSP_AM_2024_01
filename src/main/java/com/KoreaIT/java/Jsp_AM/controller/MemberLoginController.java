package com.KoreaIT.java.Jsp_AM.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginServlet
 */
//@WebServlet("/member/login")
public class MemberLoginController implements Controller {
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		// TODO Auto-generated method stub
		return "/jsp/member/loginForm.jsp";
	}

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public MemberLoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		request.getRequestDispatcher("/jsp/member/loginForm.jsp").forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}


}
