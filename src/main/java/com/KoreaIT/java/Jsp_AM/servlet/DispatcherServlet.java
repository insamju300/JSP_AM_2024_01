package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Map<String, String> paramMap = new HashMap<>();
		Map<String, Object> responseParamMap = new HashMap<>();
		
		//"/JSP_AM_2024_01/article/list"

		response.getWriter().append("<h1>" + request.getRequestURI() + "<h1>");
		
		//리퀘스트
		request.getParameterNames().asIterator().forEachRemaining(a -> {
		    paramMap.put(a, request.getParameter(a));
		});
		
		//리스폰스
		responseParamMap.entrySet().forEach(a->request.setAttribute(a.getKey(), a.getValue()));
		
		//forward 처리
		
		//js처리

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
