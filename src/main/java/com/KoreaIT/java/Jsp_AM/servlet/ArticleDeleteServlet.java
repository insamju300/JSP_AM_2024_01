package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.exception.SQLErrorException;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doDelete")
public class ArticleDeleteServlet extends HttpServlet {
	
	private ArticleService service = new ArticleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// DB연결
//		try {
//			Class.forName(Config.getDbDriverClassName());
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스가 없습니다.");
//			e.printStackTrace();
//		}
//
//		Connection conn = null;
//
//		try {
//			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
//			//response.getWriter().append("연결 성공!");
//
//			int id = Integer.parseInt(request.getParameter("id"));
//			//서버쪽 삭제 권한 체크
//			SecSql sql = SecSql.from("SELECT *");
//			sql.append("FROM article");
//			sql.append("WHERE id = ?;", id);
//
//			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
//			Optional<Article> article = service.findArticleById(id);
//			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
//			
//			if(Integer.parseInt(articleRow.get("memberId").toString())!=loginMember.getId()) {
//				
//				response.getWriter()
//				.append("<script>alert('회원님은 이 게시글의 삭제 권한이 없습니다.'); location.replace('list');</script>");
//				return;
//			};
//            //서버쪽 삭제 권한 체크 끝
//			
////			sql = SecSql.from("DELETE");
////			sql.append("FROM article");
////			sql.append("WHERE id = ?;", id);
////
////			DBUtil.delete(conn, sql);
////
////			response.getWriter()
////					.append(String.format("<script>alert('%d번 글이 삭제되었습니다.'); location.replace('list');</script>", id));
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
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}