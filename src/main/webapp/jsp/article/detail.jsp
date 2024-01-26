<%@ page import="com.KoreaIT.java.Jsp_AM.dto.Article"%>
<%@ page import="com.KoreaIT.java.Jsp_AM.dto.Member"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Article article = (Article) request.getAttribute("article");
Member loginMember = (Member) request.getSession().getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 상세페이지</title>
</head>
<body>

	<h2>게시물 상세페이지</h2>

	<div>
		번호 :
		<%=article.getId()%></div>
	<div>
		작성자 :
		<%=article.getWriter()%></div>
	<div>
		날짜 :
		<%=article.getStringRegDate()%></div>
	<div>
		제목 :
		<%=article.getTitle()%></div>
	<div>
		내용 :
		<%=article.getBody()%></div>


	<div>
		<%
		if (loginMember != null && loginMember.getId() == article.getMemberId()) {%>
		<a href="modify?id=<%=article.getId()%>">수정</a>
		<%}%>
		<%
		if (loginMember != null && loginMember.getId() == article.getMemberId()) {
		%>
		<a href="doDelete?id=<%=article.getId()%>">del</a>
		<%}%>
	</div>
	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>

</body>
</html>