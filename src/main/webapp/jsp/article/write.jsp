<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
main {
  text-align: center;
}

main > form {
  display: flex;
  flex-direction: column;
}

main > form > input:focus {
  box-shadow: 1px 1px 5px gray;
}
main > form > textarea:focus {
  box-shadow: 1px 1px 5px gray;
}

main > form > .button_block {
  display: flex;
  justify-content: space-around;
}

main > form > .button_block > input {
  width: 40%;
}

main > form > * {
  margin-top: 10px;
}

</style>
</head>
<body>
<main>
  <h1>게시글 등록</h1>
  <form action="doWrite" method="post">
    <input type="text" name="title" placeholder="제목">
    <textarea name="body" rows="30" cols="33" placeholder="내용"></textarea>
    <div class="button_block">
      <input type="submit" value="등록">
      <input type="reset" value="초기화">
    </div>
  </form>
</main>
<div><a style="color:green" href="list">리스트로 돌아가기</a></div>
</body>
</html>