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
		String color = "black";
				
		try {
			dan = Integer.parseInt(request.getParameter("dan").trim());
		}catch(Exception e) {
			
		}
		try {
			limit = Integer.parseInt(request.getParameter("limit").trim());
		}catch(Exception e) {
			
		}
		
		if(request.getParameter("color")!=null && request.getParameter("color").trim().length()>0) {
			color = request.getParameter("color");
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
				+ ".body,\r\n"
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
				+ "      position: relative;\r\n"
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
				+ "    .topbar>nav ul>li:hover>a {\r\n"
				+ "      background-color: black;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "    .topbar>nav>ul ul{\r\n"
				+ "      display: none;\r\n"
				+ "    }\r\n"
				+ "    .topbar>nav ul>li:hover>ul {\r\n"
				+ "      display:block;\r\n"
				+ "      position:absolute;\r\n"
				+ "      width:100%;\r\n"
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
				+ "      color: "+color+";\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    main li {\r\n"
				+ "      text-align: center;\r\n"
				+ "      color: "+color+";\r\n"
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
				+ "        <li><a href=\"./printDan?dan=2\">2단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=1\">2*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=2\">2*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=3\">2*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=4\">2*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=5\">2*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=6\">2*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=7\">2*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=8\">2*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=2&limit=9\">2*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=3\">3단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=1\">3*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=2\">3*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=3\">3*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=4\">3*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=5\">3*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=6\">3*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=7\">3*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=8\">3*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=3&limit=9\">3*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=4\">4단</a>\r\n"
				+ "         <ul>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=1\">4*1까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=2\">4*2까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=3\">4*3까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=4\">4*4까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=5\">4*5까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=6\">4*6까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=7\">4*7까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=8\">4*8까지</a></li>\r\n"
				+ "           <li><a href=\"./printDan?dan=4&limit=9\">4*9까지</a></li>\r\n"
				+ "         </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=5\">5단</a>\r\n"
				+ "           <ul>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=1\">5*1까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=2\">5*2까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=3\">5*3까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=4\">5*4까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=5\">5*5까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=6\">5*6까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=7\">5*7까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=8\">5*8까지</a></li>\r\n"
				+ "             <li><a href=\"./printDan?dan=5&limit=9\">5*9까지</a></li>\r\n"
				+ "           </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=6\">6단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=1\">6*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=2\">6*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=3\">6*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=4\">6*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=5\">6*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=6\">6*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=7\">6*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=8\">6*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=6&limit=9\">6*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=7\">7단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=1\">7*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=2\">7*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=3\">7*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=4\">7*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=5\">7*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=6\">7*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=7\">7*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=8\">7*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=7&limit=9\">7*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=8\">8단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=1\">8*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=2\">8*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=3\">8*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=4\">8*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=5\">8*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=6\">8*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=7\">8*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=8\">8*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=8&limit=9\">8*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "        </li>\r\n"
				+ "        <li><a href=\"./printDan?dan=9\">9단</a>\r\n"
				+ "          <ul>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=1\">9*1까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=2\">9*2까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=3\">9*3까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=4\">9*4까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=5\">9*5까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=6\">9*6까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=7\">9*7까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=8\">9*8까지</a></li>\r\n"
				+ "            <li><a href=\"./printDan?dan=9&limit=9\">9*9까지</a></li>\r\n"
				+ "          </ul>\r\n"
				+ "        </li>\r\n"
				+ "      </ul>\r\n"
				+ "    </nav>\r\n"
				+ "  </div>\r\n"
				+ "\r\n"
				+ "  <main>";
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
