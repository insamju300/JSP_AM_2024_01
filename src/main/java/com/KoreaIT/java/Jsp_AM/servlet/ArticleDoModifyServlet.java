package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doModify")
public class ArticleDoModifyServlet extends HttpServlet {
	ArticleService service = new ArticleService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		Article article = service.findArticleById(id).get();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		article.setTitle(title);
		article.setBody(body);
		service.update(article);


		response.getWriter().append(String
				.format("<script>alert('%d번 글이 수정되었습니다.'); location.replace('detail?id=%d');</script>", id, id));

		
		
		
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
//
//			int id = Integer.parseInt(request.getParameter("id"));
//			
//			//서버쪽 수정 권한 체크
//			SecSql sql = SecSql.from("SELECT *");
//			sql.append("FROM article");
//			sql.append("WHERE id = ?;", id);
//
//			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
//			Member loginMember = (Member)request.getSession().getAttribute("loginMember");
//			
//			
//			if(Integer.parseInt(articleRow.get("memberId").toString())!=loginMember.getId()) {
//				response.getWriter()
//				
//				.append("<script>alert('회원님인 이 게시글의 수정 권한이 없습니다.'); location.href('list');</script>");
//				return;
//			};
//            //서버쪽 수정권한 체크 끝
//
//			String title = request.getParameter("title");
//			String body = request.getParameter("body");
//
//			sql = SecSql.from("UPDATE article");
//			sql.append("SET ");
//			sql.append("title = ?,", title);
//			sql.append("`body` = ?", body);
//			sql.append("WHERE id = ?;", id);
//
//			DBUtil.update(conn, sql);
//
//			response.getWriter().append(String
//					.format("<script>alert('%d번 글이 수정되었습니다.'); location.replace('detail?id=%d');</script>", id, id));
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