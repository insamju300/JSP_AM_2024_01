package com.KoreaIT.java.Jsp_AM.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.KoreaIT.java.Jsp_AM.config.Config;
import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

/**
 * Servlet implementation class MemberJoinServlet
 */

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// DB연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPassword());

			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");

			SecSql sql = SecSql.from("INSERT INTO `MEMBER`");
			sql.append("SET regDate = NOW(),");
			sql.append("loginId = ?,", loginId);
			sql.append("password = SHA2(?, 256),", password);
			sql.append("name = ?;", name);

			int id = DBUtil.insert(conn, sql);

			response.getWriter()
					.append(String.format("<script>alert('%d번 회원이 등록되었습니다.'); location.replace('../article/list');</script>", id));

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
