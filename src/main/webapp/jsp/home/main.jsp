<%@ page import="com.KoreaIT.java.Jsp_AM.dto.Member"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>
<%
    Member loginMember = (Member)request.getSession().getAttribute("loginMember");
 %>
	<h1>MAIN</h1>
	
	<ul>
		<li><a href="../article/list">리스트로 이동</a></li>
		<% if(loginMember==null){ %>
		<li><a href="../member/login">로그인으로 이동</a></li>
		<li><a href="../member/join">회원가입으로 이동</a></li>
		<%} else { %>
		<li><a href="../member/doLogout">로그아웃</a></li>
		<% } %>
	</ul>	
</body>
</html>