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
<%for(int i = 0; i<articleRows.size();i++){ %>
<tr>
	<td><%=articleRows.get(i).get("id")%>번</td>
	<td><%=articleRows.get(i).get("regDate")%></td>
	<td><%=articleRows.get(i).get("title")%></td> 
	<td><%=articleRows.get(i).get("body")%></td>
<tr>
<%} %>
</table>


</body>
</html>