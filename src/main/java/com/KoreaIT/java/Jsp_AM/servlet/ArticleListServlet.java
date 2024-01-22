package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.util.DBUtil;
import com.KoreaIT.java.Jsp_AM.util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/list")
public class ArticleListServlet extends HttpServlet {

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

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "");
			//response.getWriter().append("연결 성공!");

			SecSql sql = SecSql.from("SELECT * FROM Article");

			int page = 1;
			int limitItem=10;
			int limitPage = 10;
		
			
			try {
			if (request.getParameter("page") != null && request.getParameter("page").toString().length() > 0) {
				page = Integer.parseInt(request.getParameter("page").toString());
			}
			}catch(Exception e) {
				response.getWriter()
				.append(String.format("페이지는 숫자값만 입력 가능합니다."));
				return;
			}
			
			sql.append("LIMIT ? ", (page-1)*limitItem);
			sql.append(", ?", limitItem);
		
			
			System.out.println(sql.toString());

			List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
			
			sql = SecSql.from("SELECT COUNT(1) FROM Article");
			
			int allArticleCount = DBUtil.selectRowIntValue(conn, sql);
			int maxPage = allArticleCount/limitItem;
			maxPage+=(allArticleCount%limitItem==0)?0:1;
			
			int currentBlock = page/limitPage;
			currentBlock += page%limitPage==0? 0:1;

//			response.getWriter().append(articleRows.toString());
			
			int startPage=((currentBlock-1)*limitPage)+1;
			if(startPage<=0) startPage=1;
			int endPage = startPage+(limitPage-1);
			if(endPage>maxPage) {
				endPage=maxPage;
			}
			request.setAttribute("currentPage", page);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("articleRows", articleRows);
			request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);

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