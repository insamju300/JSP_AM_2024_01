package com.KoreaIT.java.Jsp_AM.controller;

import java.util.Map;

import com.KoreaIT.java.Jsp_AM.dto.Member;

import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberDoLogout
 */
//@WebServlet("/member/doLogout")
public class MemberDoLogout implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		String name = ((Member)session.getAttribute("loginMember")).getName();
		session.removeAttribute("loginMember");
		
		return String.format("<script>alert('%s님 안녕히가세요');location.href = '../home/main';</script>", name);
	}
	//private static final long serialVersionUID = 1L;
       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MemberDoLogout() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String name = ((Member)request.getSession().getAttribute("loginMember")).getName();
//		request.getSession().removeAttribute("loginMember");
//		
//		response.getWriter().write(String.format("<script>alert('%s님 안녕히가세요');location.href = '../home/main';</script>", name));
//		
//		
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
