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
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="#">
		<label for="loginId">id</label> <input type="text" name="loginId"
			id="loginId" /> <label for="password">password</label> <input
			type="password" name="password" id="password" /> <label
			for="passwordCheck">password 확인</label> <input type="password"
			name="passwordCheck" id="passwordCheck" /> <label for="name">이름</label>
		<input type="text" name="name" id="name" />
		<button type="button" id="submit">회원가입</button>
	</form>

	<script type="text/javascript">
		let idCheck = false;
		let passwordCheck = false;
		$("#submit").click(function() {
			if (!idCheck) {
				alert("id체크 작동 테스트");
			}else if (!passwordCheck){
				alert("password체크 작동 테스트");
			}
		});
		
		$("#loginId").blur(function(){
			let loginId = $("#loginId").val();
			let valCheck = new RegExp("^[a-z0-9-_]{5,20}$").test(loginId);
			if(!valCheck){
				alert("아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");	
				$("#loginId").val('')
				return;
			}

			  $.ajax({url: "idDuplicateCheck",
				  data: {loginId: loginId},
				  dataType : "text",
				  method : "post",
				  success: function(result){
				    if(result=="true"){
				    	alert("isExists");
				    }else{
				    	alert("isNotExists");
				    }
				  },
				  error: function(error){
					  alert(error);
				  }
				  });
			
			
			
			
		})
	</script>
</body>
</html>