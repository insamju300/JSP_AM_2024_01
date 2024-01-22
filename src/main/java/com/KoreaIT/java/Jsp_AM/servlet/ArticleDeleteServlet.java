package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/delete")
public class ArticleDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String errMsg = null;

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "");
			response.getWriter().append("연결 성공!");



			int id = -1; 
		    try {
				id=	Integer.parseInt(request.getParameter("id"));
		    }catch(Exception e) {
		    	errMsg = "삭제할 id는 숫자로만 입력 가능합니다.";
		    	request.setAttribute("errMsg", errMsg);
		    	request.getRequestDispatcher("list").forward(request, response);
				return;
		    }

			SecSql sql = SecSql.from("SELECT * FROM Article");
			sql.append("WHERE id = ?;", id);
			
			Map<String, Object> articleRow = DBUtil.selectRow(conn, sql);
			if(articleRow==null || articleRow.size()==0) {
				errMsg = id+"번 회원이 존재하지 않습니다.";
		    	request.setAttribute("errMsg", errMsg);
		    	request.getRequestDispatcher("list").forward(request, response);
				return;
			}
			SecSql secSql = new SecSql();
			secSql.append("DELETE FROM article WHERE id = ?;", id);
			DBUtil.delete(conn, secSql);

			request.setAttribute("msg", id+"번 게시글이 삭제되었습니다.");
			request.getRequestDispatcher("list").forward(request, response);

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