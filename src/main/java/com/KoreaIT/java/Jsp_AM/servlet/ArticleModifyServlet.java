package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doModify")
public class ArticleModifyServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// DB연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/JSP_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
		String user = "root";
		String password = "";

		Connection conn = null;
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id").trim());
		}catch(Exception e) {
			response.getWriter().append(String
					.format("<script>alert('id에 올바른 값을 입력해 주세요.'); location.replace('list')</script>", id));
			return;			
		}
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		if(title==null || title.isEmpty() || title.isBlank()) {
			response.getWriter().append(String
					.format("<script>alert('타이틀은 필수 입력 사항입니다.'); location.replace('detail?id=%d')</script>", id));
			return;
		}
		if(body==null || body.isEmpty() || body.isBlank()) {
			response.getWriter().append(String
					.format("<script>alert('바디는 필수 입력 사항입니다.'); location.replace('detail?id=%d')</script>", id));
			return;
		}
		

		try {
			conn = DriverManager.getConnection(url, "root", "");
			// response.getWriter().append("연결 성공!");

			SecSql sql = SecSql.from("UPDATE Article SET ");
			sql.append("title = ? ,", request.getParameter("title"));
			sql.append("`body` = ? ", request.getParameter("body"));
			sql.append("where id = ?", id);

			DBUtil.update(conn, sql);

			response.getWriter().append(String
					.format("<script>alert('%d번 글이 수정되었습니다.'); location.replace('detail?id=%d')</script>", id, id));

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
