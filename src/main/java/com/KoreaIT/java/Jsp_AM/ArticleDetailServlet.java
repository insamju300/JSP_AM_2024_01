package com.KoreaIT.java.Jsp_AM;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class ArticleDetailServlet
 */
@WebServlet("/article/detail")
public class ArticleDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("id").trim());
		}catch(NumberFormatException e) {
			request.setAttribute("errorMsg", "검색할 아이디는 숫자로 입력해 주세요.");
			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
			return;
		}catch(NullPointerException e) {
			request.setAttribute("errorMsg", "검색할 아이디를 입력해주세요.");
			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
			return;
		}
		
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

		try {
			conn = DriverManager.getConnection(url, "root", "");
			

			DBUtil dbUtil = new DBUtil(request, response);

			String sql = String.format("SELECT * FROM article where id = %d;", id);

			Map<String, Object> article = dbUtil.selectRow(conn, sql);
			
			//response.getWriter().append("연결 성공!");
			

			//response.getWriter().append(articleRows.toString());
			request.setAttribute("article", article);
			request.getRequestDispatcher("/jsp/article/detail.jsp").forward(request, response);
			

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
