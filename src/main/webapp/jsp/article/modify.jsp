<%@ page import="com.KoreaIT.java.Jsp_AM.dto.Article"%>
<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Article article = (Article) request.getAttribute("article");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정 페이지</title>
</head>
<body>

	<h2>게시물 수정</h2>

	<h3><%=article.getId()%>번 게시물 수정
	</h3>

	<div>
		날짜 :
		<%=article.getStringRegDate()%></div>
		
	<form method="POST" action="doModify">
		<input type="hidden" value="<%=article.getId()%>" name="id" />
		<div>
			제목 : <input type="text" name="title"
				value="<%=article.getTitle()%>"/ >
		</div>
		<div>
			내용 :
			<textarea type="text" name="body"><%=article.getBody()%></textarea>
		</div>
		<button type="submit">수정</button>
	</form>


	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>

</body>
</html>