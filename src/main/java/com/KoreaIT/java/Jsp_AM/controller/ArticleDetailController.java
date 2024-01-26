package com.KoreaIT.java.Jsp_AM.controller;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

//@WebServlet("/article/detail")
public class ArticleDetailController implements Controller{
	ArticleService service = new ArticleService();
	
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		int id = Integer.parseInt(paramMap.get("id"));
		Article findArticle = service.findArticleById(id).get(); //바로 get해주는 이유. null인경우는 filter에서 걸러버림.
		responseParamMap.put("article", findArticle);
		return "/jsp/article/detail.jsp";
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		int id = Integer.parseInt(request.getParameter("id"));
//		Article findArticle = service.findArticleById(id).get(); //바로 get해주는 이유. null인경우는 filter에서 걸러버림.
//		request.setAttribute("article", findArticle);
//		request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
		
		// DB연결
//		try {
//			Class.forName(Config.getDbDriverClassName());
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스가 없습니다.");
//			e.printStackTrace();
//		}
//
//		Connection conn = null;

//		try {
//			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
//			//response.getWriter().append("연결 성공!");
//
//			int id = Integer.parseInt(request.getParameter("id"));
//
//			SecSql sql = SecSql.from("SELECT article.*, `member`.`name` as writer");
//			sql.append("FROM article INNER JOIN `member` ON article.memberId = `member`.id");
//			sql.append("WHERE article.id = ?;", id);
//
//			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
//
//			request.setAttribute("articleRow", articleRow);
//			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
//
//		} catch (SQLException e) {
//			System.out.println("에러 : " + e);
//		} catch (SQLErrorException e) {
//			e.getOrigin().printStackTrace();
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

}