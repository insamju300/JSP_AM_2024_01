<%@ page import="com.KoreaIT.java.Jsp_AM.servlet.Member"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
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
		<%=articleRow.get("id")%></div>
	<div>
		작성자 :
		<%=articleRow.get("writer")%></div>
	<div>
		날짜 :
		<%=articleRow.get("regDate")%></div>
	<div>
		제목 :
		<%=articleRow.get("title")%></div>
	<div>
		내용 :
		<%=articleRow.get("body")%></div>


	<div>
		<%
		if (loginMember != null && loginMember.getId() == Integer.parseInt(articleRow.get("memberId").toString())) {
		%>
		<a href="modify?id=<%=articleRow.get("id")%>">수정</a>
		<%}%>
		<%
		if (loginMember != null && loginMember.getId() == Integer.parseInt(articleRow.get("memberId").toString())) {
		%>
		<a href="doDelete?id=<%=articleRow.get("id")%>">del</a>
		<%}%>
	</div>
	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>

</body>
</html>