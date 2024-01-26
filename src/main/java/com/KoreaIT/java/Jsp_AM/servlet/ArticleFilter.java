package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.KoreaIT.java.Jsp_AM.dto.Article;
import com.KoreaIT.java.Jsp_AM.dto.Member;
import com.KoreaIT.java.Jsp_AM.service.ArticleService;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ArticleFilter
 */
@WebFilter("/article/*")
public class ArticleFilter extends HttpFilter implements Filter {

	ArticleService service = new ArticleService();

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public ArticleFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding("utf-8");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setContentType("text/html;charset=utf-8");

		String[] uri = httpRequest.getRequestURI().split("/");

		List<String> needLoginList = new ArrayList<>();
		needLoginList.add("doDelete");
		needLoginList.add("doModify");
		needLoginList.add("doWrite");
		needLoginList.add("modify");
		needLoginList.add("write");

		List<String> needWriterCheckList = new ArrayList<>();
		needWriterCheckList.add("doDelete");
		needWriterCheckList.add("doModify");
		needWriterCheckList.add("modify");

		List<String> needArticleList = new ArrayList<>();
		needArticleList.add("detail");
		needArticleList.add("doDelete");
		needArticleList.add("doModify");
		needArticleList.add("modify");

		System.out.println(uri[uri.length - 1]);

		if (needLoginList.contains(uri[uri.length - 1])) {
			Member member = (Member) httpRequest.getSession().getAttribute("loginMember");
			if (member == null) {
				String redirectPath = httpRequest.getRequestURI().toString();
				String queryString = httpRequest.getQueryString();
				if (queryString != null && queryString.length() > 0) {
					redirectPath += "?" + queryString;
				}
				request.setAttribute("redirectPath", redirectPath);
				request.setAttribute("alertMsg", "로그인이 필요한 기능입니다.");

//				response.getWriter()
//				.append(String.format("<script>alert('로그인이 필요한 기능입니다.'); location.replace('../member/login');</script>"));
				request.getRequestDispatcher("/jsp/member/loginForm.jsp").forward(request, response);

				return;
			}
		}

		if (needArticleList.contains(uri[uri.length - 1])) {
			int id = Integer.parseInt(request.getParameter("id"));
			Optional<Article> articleOpt = service.findArticleById(id);
			if (articleOpt.isEmpty()) {
				response.getWriter().append("<script>alert('존재하지 않는 게시글 입니다.'); location.replace('list');</script>");
				return;
			}

			if (needWriterCheckList.contains(uri[uri.length - 1])) {
				Article article = articleOpt.get();
				Member member = (Member) httpRequest.getSession().getAttribute("loginMember");
				if (article.getMemberId() != member.getId()) {
					response.getWriter()
							.append("<script>alert('회원님은 이 게시글의 변경 권한이 없습니다.'); location.replace('list');</script>");
					return;
				}
			}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
