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

#passDuple {
    display : none;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="#">
		<label for="loginId">id</label> <input type="text" name="loginId"
			id="loginId" /> <label for="password">password</label> <input
			type="password" name="password" id="password" /> 
			<label
			for="passDuple">password 확인</label> <input type="password"
			name="passDuple" id="passDuple" /> <label for="name">이름</label>
		<input type="text" name="name" id="name" />
		<button type="button" id="submit">회원가입</button>
	</form>

	<script type="text/javascript">
		let idCheck = false;
		let passwordCheck = false;
		let passDupleCheck = false;
		$("#submit").click(function() {
			if (!$("#loginId").val()) {
				alert("id를 입력해주세요.");
			}else if (!idCheck){
				alert("id체크를 통과해주세요");
			}
		});
		
		$("#loginId").blur(function(){
			let loginId = $("#loginId").val();
			let idValCheck = new RegExp("^[a-z0-9-_]{5,20}$").test(loginId);
			
			if(!idValCheck){
				idCheck = false;
				return;
			}

			  $.ajax({url: "idDuplicateCheck",
				  data: {loginId: loginId},
				  dataType : "text",
				  method : "post",
				  success: function(result){
				    if(result=="true"){
				    	alert("이미 존재하는 loginId입니다.");
				    	idCheck = false;
				    }else{
				    	alert("사용 가능한 id입니다.");
				    	idCheck = true;
				    }
				  };
			});
		});
		
		$("#password").blur(function(){
			let password = $("#password").val();
			let passValCheck = new RegExp("^[a-zA-Z0-9!@#%^&]{8,16}$").test(loginId);
			
			if(!passValCheck){
				alert("비밀번호:비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.");
				$("#password").val('')
				passwordCheck = false;
				return;
			}
			passwordCheck = true;
			$("#passwordCheck").show();
			
		})
		
		$("#passDuple").blur(function(){
			let password = $("#password").val();
			let passDuple = $("#passDuple").val();
			
			if(password!==passDuple){
				alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				passDupleCheck = false;
				return;
			}
			passDupleCheck = true;
		})		
		
		
	</script>
</body>
</html>