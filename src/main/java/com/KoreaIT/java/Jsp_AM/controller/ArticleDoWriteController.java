package com.KoreaIT.java.Jsp_AM.controller;

import java.util.Map;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.http.HttpSession;


//@WebServlet("/article/doWrite")
public class ArticleDoWriteController  implements Controller{
	
	ArticleService service = new ArticleService();
	
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		String title = paramMap.get("title");
		String body = paramMap.get("body");
		int memberId = ((Member)session.getAttribute("loginMember")).getId();
		int id = service.insert(new Article(memberId, title, body));
		
		return String.format("<script>alert('%d번 글이 등록되었습니다.'); location.replace('list');</script>", id);
	}
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		
//		String title = request.getParameter("title");
//		String body = request.getParameter("body");
//		int memberId = ((Member)request.getSession().getAttribute("loginMember")).getId();
//		int id = service.insert(new Article(memberId, title, body));
//		
//		
//		response.getWriter().append(String.format("<script>alert('%d번 글이 등록되었습니다.'); location.replace('list');</script>", id));
		
		
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
//			String title = request.getParameter("title");
//			String body = request.getParameter("body");
//			int memberId = ((Member)request.getSession().getAttribute("loginMember")).getId();
//
//			SecSql sql = SecSql.from("INSERT INTO article");
//			sql.append("SET regDate = NOW(),");
//			sql.append("title = ?,", title);
//			sql.append("`body` = ?, ", body);
//			sql.append("`memberId` = ? ", memberId);
//
//			int id = DBUtil.insert(conn, sql);
//
//			response.getWriter()
//					.append(String.format("<script>alert('%d번 글이 등록되었습니다.'); location.replace('list');</script>", id));
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
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
}