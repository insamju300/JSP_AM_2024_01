<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	display: flex;
	flex-direction: column;
}

#passDupleLabel{
    display: none;
}

#passDuple {
    display : none;
}

</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="join" method="post" id="joinForm">
		<label for="loginId" id="loginIdLabel">id</label> <input type="text" name="loginId"
			id="loginId" /> 
			
	    <label for="password" id="passwordLabel">password</label> <input
			type="password" name="password" id="password" /> 
			<label
			for="passDuple" id="passDupleLabel">password 확인</label> <input type="password"
			name="passDuple" id="passDuple" /> 
			<label for="name" id="nameLabel">이름</label>
		<input type="text" name="name" id="name" />
		<button type="button" id="submitButton">회원가입</button>
	</form>

	<script type="text/javascript">
		let idCheck = false;
		let passwordCheck = false;
		let passDupleCheck = false;
		$("#submitButton").click(function() {
			let isOk = true;
			if (!$("#loginId").val()) {
				$("#loginIdLabel").text("id id를 입력해 주세요.");
				isOk = false;
			}else if (!idCheck){
				isOk = false;
			}
			
			if (!$("#password").val()) {
				$("#passwordLabel").text("password password를 입력해주세요.");
				isOk = false;
			}else if (!passwordCheck){
				isOk = false;
			}
			
			if (!$("#passDuple").val()) {
				$("#passDupleLabel").text("password확인 password확인을 입력해주세요.");
				isOk = false;
			}else if (!passDuple){
				isOk = false;
			}
			
			if (!$("#name").val()){
				$("#nameLabel").text("이름 이름을 입력해주세요.");
				isOk = false;
			}else{
				$("#nameLabel").text("이름");
			}
			
			
			if(isOk){
				$("#joinForm").submit();
			}
		});
		
		$("#loginId").blur(function(){
			let loginId = $("#loginId").val();
			let idValCheck = new RegExp("^[a-z0-9-_]{5,20}$").test(loginId);
			
			if(!idValCheck){
				idCheck = false;
				$("#loginIdLabel").text("id 5~20자의 영문 소문자, 숫자, -_를 사용해 주세요.");
				return;
			}

			  $.ajax({url: "idDuplicateCheck",
				  data: {loginId: loginId},
				  dataType : "text",
				  method : "post",
				  success: function(result){
				    if(result=="true"){
						$("#loginIdLabel").text("id 이미 존재하는 loginId입니다.");
				    	idCheck = false;
				    }else{
						$("#loginIdLabel").text("id");
				    	idCheck = true;
				    }
				  }
			});
		});
		
		$("#password").blur(function(){
			let password = $("#password").val();
			let passValCheck = new RegExp("^[a-zA-Z0-9!@#%^&]{8,16}$").test(password);
			
			if(!passValCheck){
				$("#passwordLabel").text("password 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
				passwordCheck = false;
				return;
			}
			passwordCheck = true;
			$("#passwordLabel").text("password");
			$("#passDupleLabel").show();
			$("#passDuple").show();
			
		});
		
		$("#passDuple").blur(function(){
			let password = $("#password").val();
			let passDuple = $("#passDuple").val();
			
			if(password!==passDuple){
				$("#passDupleLabel").text("password 확인 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				passDupleCheck = false;
				return;
			}
			$("#passDupleLabel").text("password 확인");
			passDupleCheck = true;
		});		
		
		
	</script>
</body>
</html>