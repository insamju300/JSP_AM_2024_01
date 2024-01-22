<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
int startPage= (int)request.getAttribute("startPage");
int endPage= (int)request.getAttribute("endPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 목록</title>
</head>
<body>

	<a href="../home/main">메인으로 이동</a>

	<h2>게시물 목록</h2>

	<table style="border-collapse: collapse; border-color: green"
		;  border="1px">
		<thead>
			<tr>
				<th>번호</th>
				<th>작성날짜</th>
				<th>제목</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Map<String, Object> articleRow : articleRows) {
			%>
			<tr style="text-align: center;">
				<td><%=articleRow.get("id")%></td>
				<td><%=articleRow.get("regDate")%></td>
				<td><a href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a></td>
				<td><a href="doDelete?id=<%=articleRow.get("id")%>">del</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
		
	</table>

<a href="list?page=<%=startPage-1%>">◀</a>
<%for(int i = startPage; i<=endPage; i++) {%>
    <a href="list?page=<%=i%>"><%=i %></a>
<%} %>
    <a href="list?page=<%=endPage+1%>">▶</a>


</body>
</html>