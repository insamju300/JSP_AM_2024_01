<%@ page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Map<String, Object> articleRow = (Map<String, Object>) request.getAttribute("articleRow");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>게시물 상세페이지</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous"></script>

<style>
main {
	text-align: center;
	display: none;
}

main>form {
	display: flex;
	flex-direction: column;
}

main>form>.button_block {
	display: flex;
	justify-content: space-around;
}

main>form>.button_block>input {
	width: 40%;
}

main>form>* {
	margin-top: 10px;
}
</style>

</head>
<body>

    <section>
	<h2>게시물 상세페이지</h2>
	<div>
		번호 :
		<%=articleRow.get("id")%></div>
	<div>
		날짜 :
		<%=articleRow.get("regDate")%></div>
	<div>
		제목 :
		<%=articleRow.get("title")%>
	</div>
	<div>
		내용 :
		<%=articleRow.get("body")%></div>
	</section>


	<main>
		<h1>게시글 수정</h1>
		<form action="doModify" method="post">
		    <input type="hidden" name="id" value=<%=articleRow.get("id") %> />
			<input type="text" name="title" placeholder="제목" value="<%=articleRow.get("title")%>">
			<textarea name="body" rows="30" cols="33" placeholder="내용" ><%=articleRow.get("body")%></textarea>
			<div class="button_block">
				<input type="submit" value="수정확정">
			</div>
		</form>

	</main>

	<button id="modify">수정</button>
	<button id="cancle">취소</button>



	<div>
		<a style="color: green" href="list">리스트로 돌아가기</a>
	</div>
<script>
$( '#modify' ).click(function() {
	$('main').show();
	$('section').hide();
});
$('#cancle').click(function() {
	$('main').hide();
	$('section').show();
	$('main>form')[0].reset();
});

</script>
</body>
</html>