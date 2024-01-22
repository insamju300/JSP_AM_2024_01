<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<% String errorMsg =  (String)request.getAttribute("errorMsg");
   Map<String, Object> article= (Map<String, Object>)request.getAttribute("article");
%>
</head>
<body>
<h2>게시글 상세보기</h2>
<% if (errorMsg!=null && errorMsg.length()>0){ %>
<h3><%=errorMsg %></h3>
<%}else if(article==null || article.size()==0){ %>
<h3>해당 id의 게시글이 존재하지 않습니다.</h3>
<%}else{ %>
<table>
<tr>
<th>번호</th><th>생성일</th><th>타이틀</th><th>내용</th>
</tr>
<tr>
	<td><%=article.get("id")%>번</td>
	<td><%=article.get("regDate")%></td>
	<td><%=article.get("title")%></td> 
	<td><%=article.get("body")%></td>
	
<tr>
</table>
<%} %>

<a href="list">리스트로 돌아가기</a>



</body>
</html>