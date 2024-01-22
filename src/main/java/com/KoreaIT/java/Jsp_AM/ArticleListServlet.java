package com.KoreaIT.java.Jsp_AM;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("123");
		response.setContentType("text/html;charset=utf-8");

		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/JSP_AM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 없습니다.");
			e.printStackTrace();
			System.out.println("시스템을 종료합니다.");
			return;
		} 

		try {
			conn = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결 성공");
			
			DBUtil dbUtil = new DBUtil(request, response);

			
			List<Map<String,Object>> articleRows = dbUtil.selectRows(conn, "SELECT * FROM ALTICLE;");
			response.getWriter().append(articleRows.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연결에 실패하였습니다.");
			e.printStackTrace();
			System.out.println("시스템을 종료합니다.");
			return;
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
