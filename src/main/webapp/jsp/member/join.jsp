<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    form{
     display:flex;
     flex-direction: column;
    }
</style>
</head>
<body>
    <h1>회원가입</h1>
    <form action="#">
    <label for="loginId">id</label>
    <input type="text" name="loginId" id="loginId"/>
    <label for="password">password</label>
    <input type="password" name="password" id="password"/>
    <label for="passwordCheck">password 확인</label>
    <input type="password" name="passwordCheck" id="passwordCheck"/>
    <label for="name">이름</label>
    <input type="text" name="name" id="name"/>
    <button id="submit"> 회원가입 </button>
    </form>

<script>
let idCheck = false;
let passwordCheck= false;
$("#submit").click(function(){
	if(!loginCheck){
		alert("id를 올바르게 입력해주세요.");
	}else if(!passwordCheck){
		alert("패스워드를 올바르게 입력해주세요.");
	}
});
    
</script>
</body>
</html>