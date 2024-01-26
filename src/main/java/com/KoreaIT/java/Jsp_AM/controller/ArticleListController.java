package com.KoreaIT.java.Jsp_AM.controller;

import java.util.List;
import java.util.Map;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Page;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;
import jakarta.servlet.http.HttpSession;


//@WebServlet("/article/list")
public class ArticleListController implements Controller {
	ArticleService service = new ArticleService();

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> responseParamMap, HttpSession session) {
		int page = 1;

		if (paramMap.get("page") != null && paramMap.get("page").length() != 0) {
			page = Integer.parseInt(paramMap.get("page"));
		}
		Page pageNation = service.getPageNation(page);
		List<Article> articles = service.findArticles(pageNation.getLimitFrom(), pageNation.getItemsInAPage());

		responseParamMap.put("page", pageNation.getPage());
		responseParamMap.put("totalCnt", pageNation.getTotalCnt());
		responseParamMap.put("totalPage", pageNation.getTotalPage());
		responseParamMap.put("itemsInAPage", pageNation.getItemsInAPage());
		responseParamMap.put("articles", articles);

		return "/jsp/article/list.jsp";
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		int page = 1;
//
//		if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
//
//		Page pageNation = service.getPageNation(page);
//
//		List<Article> articles = service.findArticles(pageNation.getLimitFrom(), pageNation.getItemsInAPage());
//
//		request.setAttribute("page", pageNation.getPage());
//		request.setAttribute("totalCnt", pageNation.getTotalCnt());
//		request.setAttribute("totalPage", pageNation.getTotalPage());
//		request.setAttribute("itemsInAPage", pageNation.getItemsInAPage());
//		request.setAttribute("articles", articles);
//
//		request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
//
//		// DB연결
////		try {
////			Class.forName(Config.getDbDriverClassName());
////		} catch (ClassNotFoundException e) {
////			System.out.println("클래스가 없습니다.");
////			e.printStackTrace();
////		}
////
////		Connection conn = null;
////
////		try {
////			conn = DriverManager.getConnection(Config.getDbUrl(), Config.getDbUser(), Config.getDbPw());
////
////			int page = 1;
////
////			if (request.getParameter("page") != null && request.getParameter("page").length() != 0) {
////				page = Integer.parseInt(request.getParameter("page"));
////			}
////
////			int itemsInAPage = 10;
////			int limitFrom = (page - 1) * itemsInAPage;
////
////			SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt");
////			sql.append("FROM article");
////
////			int totalCnt = DBUtil.selectRowIntValue(conn, sql);
////			int totalPage = (int) Math.ceil(totalCnt / (double) itemsInAPage);
////
////			sql = SecSql.from("SELECT article.*, `member`.`name` as writer");
////			sql.append("FROM article INNER JOIN `member` ON article.memberId = `member`.id");
////			sql.append("ORDER BY id DESC");
////			sql.append("LIMIT ?, ?;", limitFrom, itemsInAPage);
////
////			List<Map<String, Object>> articleRows = DBUtil.selectRows(conn, sql);
////
////			request.setAttribute("page", page);
////			request.setAttribute("totalCnt", totalCnt);
////			request.setAttribute("totalPage", totalPage);
////			request.setAttribute("itemsInAPage", itemsInAPage);
////			request.setAttribute("articleRows", articleRows);
////
////			request.getRequestDispatcher("/jsp/article/list.jsp").forward(request, response);
//
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
////		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}

}