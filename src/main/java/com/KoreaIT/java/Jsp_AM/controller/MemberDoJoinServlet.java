package com.KoreaIT.java.Jsp_AM.controller;

import java.io.IOException;

import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/doJoin")
public class MemberDoJoinServlet extends HttpServlet {
	MemberService service = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");
		
		int id = service.insert(new Member(loginId, loginPw, name)); 
		
		response.getWriter().append(String.format(
		"<script>alert('%s님, 회원가입이 완료되었습니다.'); location.replace('../article/list');</script>", name));
		
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
//			String loginId = request.getParameter("loginId");
//			String loginPw = request.getParameter("loginPw");
//			String name = request.getParameter("name");
//
//			SecSql sql = SecSql.from("INSERT INTO `member`");
//			sql.append("SET regDate = NOW(),");
//			sql.append("loginId = ?,", loginId);
//			sql.append("loginPw = ?,", loginPw);
//			sql.append("`name` = ?;", name);
//
//			int id = DBUtil.insert(conn, sql);
//
//			response.getWriter().append(String.format(
//					"<script>alert('%s님, 회원가입이 완료되었습니다.'); location.replace('../article/list');</script>", name));
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