<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<% List<Map<String, Object>> articleRows = (List<Map<String, Object>>)request.getAttribute("articleRows"); %>
</head>
<body>
<h2>게시글 목록</h2>
<table>
<tr>
<th>번호</th><th>생성일</th><th>타이틀</th><th>내용</th>
</tr>
<%for(Map<String, Object> articleRow : articleRows){ %>
<tr>
	<td><%=articleRow.get("id")%>번</td>
	<td><%=articleRow.get("regDate")%></td>
	<td><a href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a></td>  
	<td><%=articleRow.get("body")%></td>
<tr>
<%} %>
</table>


</body>
</html>