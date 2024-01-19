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
		int dan = 8;
		try {
			dan = Integer.parseInt(request.getParameter("dan").trim());
		}catch(Exception e) {
			
		}
		
		
		writer.print("<!DOCTYPE html>");
		writer.print("<html lang=\"UTF-8\">");
		writer.print("<body>");
		writer.print("\r\n"
				+ "<a href=\"./printDan?dan=2\">2단</a>\r\n"
				+ "<a href=\"./printDan?dan=3\">3단</a>\r\n"
				+ "<a href=\"./printDan?dan=4\">4단</a>\r\n"
				+ "<a href=\"./printDan?dan=5\">5단</a>\r\n"
				+ "<a href=\"./printDan?dan=6\">6단</a>\r\n"
				+ "<a href=\"./printDan?dan=7\">7단</a>\r\n"
				+ "<a href=\"./printDan?dan=8\">8단</a>\r\n"
				+ "<a href=\"./printDan?dan=9\">9단</a>");
		writer.print("<ul>");
		writer.print("<h1>=="+dan+"단==</h1>");
		for(int i=1; i<=9; i++) {
			writer.print("<li>"+dan+ " * "+ i +" = " + (dan * i)+ "</li>");	
		}
		writer.print("</ul>");		
		writer.print("</body>");
		writer.print("</html>");	
		writer.close();
		
		
		
	}
}
