package com.KoreaIT.java.Jsp_AM;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeMainServlet
 */
@WebServlet("/printDan")
public class PrintDan extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		int dan = 2;
		int limit = 9;
		try {
			dan = Integer.parseInt(request.getParameter("dan").trim());
		}catch(Exception e) {
			
		}
		try {
			limit = Integer.parseInt(request.getParameter("limit").trim());
		}catch(Exception e) {
			
		}
		
		String html1="<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "  <title>Document</title>\r\n"
				+ "  <style>\r\n"
				+ "    .body,\r\n"
				+ "    ul,\r\n"
				+ "    li {\r\n"
				+ "      margin: 0;\r\n"
				+ "      padding: 0;\r\n"
				+ "      list-style: none;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    a {\r\n"
				+ "      color: inherit;\r\n"
				+ "      text-decoration: none;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar {\r\n"
				+ "      display: flex;\r\n"
				+ "      width: 1024px;\r\n"
				+ "      margin: 0 auto;\r\n"
				+ "      justify-content: space-between;\r\n"
				+ "      background-color: gray;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>div {\r\n"
				+ "      width: 20%;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>div>a {\r\n"
				+ "      display: flex;\r\n"
				+ "      width: 100%;\r\n"
				+ "      padding: 20px 0px;\r\n"
				+ "      justify-content: center;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>nav {\r\n"
				+ "      width: 60%;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>nav>ul {\r\n"
				+ "      display: flex;\r\n"
				+ "      width: 100%;\r\n"
				+ "      justify-content: space-around;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>nav>ul>li {\r\n"
				+ "      width: 15%;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>nav>ul a {\r\n"
				+ "      display: flex;\r\n"
				+ "      width: 100%;\r\n"
				+ "      background-color: gray;\r\n"
				+ "      padding: 20px 0px;\r\n"
				+ "      justify-content: center;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .topbar>nav>ul>li:hover a {\r\n"
				+ "      background-color: black;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    main {\r\n"
				+ "      width: 1000px;\r\n"
				+ "      margin: auto;\r\n"
				+ "      display: flex;\r\n"
				+ "      justify-content: center;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    main h3 {\r\n"
				+ "      text-shadow: 1px 1px 3px gray;\r\n"
				+ "    }\r\n"
				+ "  </style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "  <div class=\"topbar\">\r\n"
				+ "    <div><a href=\"./printDan\">구구단</a></div>\r\n"
				+ "    <nav class=\"menu\">\r\n"
				+ "      <ul>\r\n"
				+ "        <li><a href=\"./printDan?dan=2\">2단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=3\">3단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=4\">4단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=5\">5단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=6\">6단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=7\">7단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=8\">8단</a></li>\r\n"
				+ "        <li><a href=\"./printDan?dan=9\">9단</a></li>\r\n"
				+ "      </ul>\r\n"
				+ "    </nav>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "  <main>\r\n";
		writer.print(html1);
		
		writer.print("<ul>");
		writer.print("<h3>=="+dan+"단==</h3>");
		for(int i=1; i<=limit; i++) {
//			writer.print("<li>"+dan+ " * "+ i +" = " + (dan * i)+ "</li>");
			writer.print(String.format("<li>%d * %d = %d</li>", dan, i, dan*i).toString());
		}
		writer.print("</ul>");
		writer.print("</main>");		
		writer.print("</body>");
		writer.print("</html>");	
		writer.close();
		
		
		
	}
}
