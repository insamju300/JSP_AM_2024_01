package com.KoreaIT.java.Jsp_AM.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		httpRequest.setCharacterEncoding("utf-8");
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		httpResponse.setContentType("text/html;charset=utf-8");
		
		String[] uri = httpRequest.getRequestURI().split("/");

		List<String> filterList = new ArrayList<>();
		
		filterList.add("doDelete");
		filterList.add("doModify");
		filterList.add("doWrite");
		filterList.add("modify");
		filterList.add("write");
		
		System.out.println(uri[uri.length-1]);

		if(filterList.contains(uri[uri.length-1])) {
			Member member = (Member)httpRequest.getSession().getAttribute("loginMember");
			if(member==null) {
				response.getWriter()
				.append(String.format("<script>alert('로그인이 필요한 기능입니다.'); location.replace('../member/login');</script>"));
				return;	
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
