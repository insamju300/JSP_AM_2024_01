package com.KoreaIT.java.Jsp_AM.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/article/modify")
public class ArticleModifyController implements Controller {
	
	ArticleService service = new ArticleService();
	
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(paramMap.get("id"));
		Article article = service.findArticleById(id).get();
		responseParamMap.put("article", article);
		return "/jsp/article/modify.jsp";
	}
	
	
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//        
//		int id = Integer.parseInt(request.getParameter("id"));
//		Article article = service.findArticleById(id).get();
//		request.setAttribute("article", article);
//		request.getRequestDispatcher("/jsp/article/modify.jsp").forward(request, response);
//		
//		// DB연결
////		try {
////			Class.forName(Config.getDbDriverClassName());
////		} catch (ClassNotFoundException e) {
////			System.out.println("클래스가 없습니다.");
////			e.printStackTrace();
////		}
////
////		Connection conn = null;
////
////		try {
////			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
////
////			int id = Integer.parseInt(request.getParameter("id"));
////
////			SecSql sql = SecSql.from("SELECT *");
////			sql.append("FROM article");
////			sql.append("WHERE id = ?;", id); 
////
////			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
////			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
////			
////			
////			if(Integer.parseInt(articleRow.get("memberId").toString())!=loginMember.getId()) {
////				conn.close();
////				response.getWriter()
////				.append("<script>alert('회원님인 이 게시글의 수정 권한이 없습니다.'); location.replace('list');</script>");
////				return;
////			};
////
////			request.setAttribute("articleRow", articleRow);
////			request.getRequestDispatcher("/jsp/article/modify.jsp").forward(request, response);
////
////		} catch (SQLException e) {
////			System.out.println("에러 : " + e);
////		} catch (SQLErrorException e) {
////			e.getOrigin().printStackTrace();
////		} finally {
////			try {
////				if (conn != null && !conn.isClosed()) {
////					conn.close();
////				}
////			} catch (SQLException e) {
////				e.printStackTrace();
////			}
////		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}



}