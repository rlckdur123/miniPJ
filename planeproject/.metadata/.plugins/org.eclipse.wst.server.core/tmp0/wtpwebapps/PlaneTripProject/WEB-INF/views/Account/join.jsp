<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	body { background-color : #F6F6F6;}
	
	#r_arrow { width : 10px; height : 15px; margin-right : 15px; margin-left : 15px;}
	#join_img { width : 30px; height : 30px; margin-bottom : 40px; margin-right : 124px;}
	
	#p_location { 
		width : 100%;
		height : 50px;
		text-align : center;
		font-weight : bold;
		color:#848484; 
		background-color :#d2d2d2; 
		margin-top : 15px; 
		margin-bottom : 15px; 
		font-size : 1.1em;
		border-top : 2px solid orange;
		border-bottom : 2px solid orange;
	}
		
	.form-wrapper {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		margin-top : 20px;
		margin-bottom : 30px;
	}
	
	#joinForm {
		width: 400px;
		text-align: center;
	}
	
	#joinForm .label-wrapper {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	#joinForm input {
		width: 100%;
		height: 25px;
		border: 0px;
		background-color : #F6F6F6;
	}
	
	#joinForm div {
		display: flex;
		align-items: center;
	}
	
	#btnIdCheck {
		width: 50px;
		height: 25px;
		border-radius: 0; 
		border : 0px; 
		background-color: #787878; 
		color: white;
		margin-left: 55px;
	}

	#btnJoin { width: 400px; height: 50px; border-radius: 4px; border : 0px; background-color: #787878; color: white; font-size: 1.0em; margin-top: 10px;}

	.label-wrapper { margin-bottom: 10px;}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="p_location">
		<div style="display: inline-block;text-align:left; width:1070px; margin-top : 14px;">
			<span>홈<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">회원가입</span>
		</div>
	</div>
	<div class="form-wrapper">
		<form id="joinForm" action="/Account/join.do" method="post">
			<input type="hidden" id="joinMsg" value="${joinMsg}">
			<div>
				<img id="join_img" src="${pageContext.request.contextPath}/resources/images/join.png">
				<h2 style="margin-bottom : 60px;">회원가입</h2>
			</div>
			<div class="label-wrapper">
				<label for="email">아이디</label>
			</div>
			<div>
				<input type="text" id="email" name="email" required>
				<button type="button" id="btnIdCheck" style="width: 100px;">중복체크</button>
			</div>
			<hr>
			<p id="idValidation" style="color: red; font-size: 0.8rem;">
				이메일은 ***@*** 형식에 맞게 작성해주세요.
			</p>
			<div class="label-wrapper">
				<label for="password">비밀번호</label>
			</div>
			<input type="password" id="password" name="password" required>
			<hr>
			<p id="pwValidation" style="color: red; font-size: 0.8rem;">
				비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정해주세요.
			</p>
			<div class="label-wrapper">
				<label for="passwordCheck">비밀번호 확인</label>
			</div>
			<input type="password" id="passwordCheck" name="passwordCheck" required>
			<hr>
			<p id="pwCheckResult" style="font-size: 0.8rem;"></p>
			<div class="label-wrapper">
				<label for="lastName">성</label>
			</div>
			<input type="text" id="lastName" name="lastName" required>
			<hr>
			<div class="label-wrapper">
				<label for="firstName">이름</label>
			</div>
			<input type="text" id="firstName" name="firstName" required>
			<hr>
			<div class="label-wrapper">
				<label for="gender">성별</label>
			</div>
			<div id="gender_radio">
				<input type="radio" id="gender" name="gender" value="M" checked style="width : 10px; margin-right : 10px;"><label for="male" style="margin-right : 20px;">남성</label>
				<input type="radio" id="gender" name="gender" value="F" style="width : 10px; margin-right : 10px;"><label for="female" style="">여성</label>
			</div>
			<div class="label-wrapper">
				<label for="birthDate">생년월일</label>
			</div>
			<input type="date" id="birthDate" name="birthDate" value="2022-01-01" min="1900-01-01" max="2022-11-23">
			<div class="label-wrapper">
				<label for="phone">전화번호</label>
			</div>
			<input type="text" id="phone" name="phone" placeholder="숫자만 입력하세요.">
			<hr>
			<div class="label-wrapper">
				<label for="address">주소</label>
			</div>
			<input type="text" name="address" id="address" size="59">
			<hr>
			<div style="display: block; margin: 20px auto;">
				<button type="submit" id="btnJoin">회원가입</button>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	<script>
		$(function() {
			//회원가입 실패 시 메시지 출력
			if($("#joinMsg").val() != "" && $("#joinMsg").val() != null) {
				alert($("#joinMsg").val());
			}
			
			//id 중복체크 했는지 확인하는 플래그
			var checkId = false;
			//email이 형식에 맞게 작성됐는지
			var idValidation = false;
			//password가 형식에 맞게 작성됐는지(특수문자 + 영문자 + 숫자 8자리)
			var pwValidation = false;
			//password가 확인란과 일치하는지
			var pwCheck = false;
			
			$("#idValidation").hide();
			$("#pwValidation").hide();
			$("#pwCheckResult").hide();
			
			//id 중복체크
			$("#btnIdCheck").on("click", function() {
				$.ajax({
					url: "/Account/idCheck.do",
					type: "post",
					data: $("#joinForm").serialize(),
					success: function(obj) {
						console.log(obj);
						
						if(obj == 'duplicatedId') {
							alert("중복된 아이디입니다.");
							$("#email").focus();
						} else {
							if(confirm("사용가능한 아이디입니다. " + $("#email").val() + 
									"를(을) 사용하시겠습니까?")) {
								checkId = true;
								$("#btnIdCheck").attr("disabled", true);
							}
						}
					},
					error: function(e) {
						console.log(e);
					}
				})
			});
			
			//id 중복체크 후 다시 id를 변경했을 때
			$("#email").on("change", function() {
				checkId = false;
				$("#btnIdCheck").attr("disabled", false);
			});
			//이메일 유효성 검사
			function validateId(character) {
				return /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/.test(character);
			}
			
			$("#email").on("change", function() {
				//이메일 유효성 처리
				if(!validateId($("#email").val())) {
					idValidation = false;
					$("#idValidation").show();
					$("#email").focus();
				} else {
					idValidation = true;
					$("#idValidation").hide();
				}
			});
			
			//비밀번호 유효성 검사
			function validatePassword(character) {
				return /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{9,}$/.test(character);
			}
			
			//비밀번호 입력될때마다 유효성 검사
			$("#password").on("change", function() {
				//비밀번호 유효성 처리
				if(!validatePassword($("#password").val())) {
					pwValidation = false;
					$("#pwValidation").show();
					$("#password").focus();
				} else {
					pwValidation = true;
					$("#pwValidation").hide();
				}
				
				//비밀번호 확인까지 입력한 후 다시 비밀번호 재설정
				if($("#password").val() == $("#passwordCheck").val()) {
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
				} else {
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
				}
			});
			
			//비밀번호 확인란 입력할 때 일치여부 체크
			$("#passwordCheck").on("change", function() {
				$("#pwCheckResult").show();
				
				if($("#password").val() == $("#passwordCheck").val()) {
					pwCheck = true;
					$("#pwCheckResult").css("color", "green");
					$("#pwCheckResult").text("비밀번호가 일치합니다.");
				} else {
					pwCheck = false;
					$("#pwCheckResult").css("color", "red");
					$("#pwCheckResult").text("비밀번호가 일치하지 않습니다.");
				}
			});
			
			//회원가입 진행
			$("#joinForm").on("submit", function(e) {
				if(!checkId) {
					alert("아이디 중복체크를 진행하세요.");
					$("#email").focus();
					e.preventDefault();
					return;
				}
				
				//비밀번호 유효성 검사가 틀렸을 때
				if(!pwValidation) {
					alert("비밀번호는 영문자, 숫자, 특수문자 조합의 9자리 이상으로 설정하세요.");
					$("#password").focus();
					e.preventDefault();
					return;
				}
				
				//비밀번호와 비밀번호 확인이 일치하지 않을 때
				if(!pwCheck) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#passwordCheck").focus();
					e.preventDefault();
					return;
				}
			});
		});
	</script>
</body>
</html>