package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/detail")
public class ArticleDetailServlet extends HttpServlet {
	ArticleService service = new ArticleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Optional<Article> findArticle = service.findArticleById(id);
		//todo: findArticle이 null인경우 고려 해야할까?
		request.setAttribute("article", findArticle.get());
		request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
		
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}