<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
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
	
	#updateForm {
		width: 400px;
		text-align: center;
	}
	
	#updateForm .label-wrapper {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	
	#updateForm input {
		width: 100%;
		height: 25px;
		border: 0px;
		background-color : #F6F6F6;
	}
	
	#updateForm div {
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

	#btnUpdate { width: 400px; height: 50px; border-radius: 4px; border : 0px; background-color: #787878; color: white; font-size: 1.0em; margin-top: 10px;}

	.label-wrapper { margin-bottom: 10px;}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div id="p_location">
		<div style="display: inline-block;text-align:left; width:1070px; margin-top : 14px;">
			<span>마이페이지<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">회원정보 수정</span>
		</div>
	</div>
	<div class="form-wrapper">
		<form id="updateForm" action="/Account/updateInfo.do" method="post">
			<input type="hidden" id="updateMsg" value="${updateMsg}">
			<div>
				<img id="join_img" src="${pageContext.request.contextPath}/resources/images/join.png">
				<h2 style="margin-bottom : 60px; margin-left : -30px;">회원정보 수정</h2>
			</div>
			<div class="label-wrapper" style="margin-bottom : 65px; margin-top : -10px; margin-left : 165px; font-size : 1.1em;">
				<label for="fullName"><strong>${loginUser.fullName}님</strong></label>
			</div>
			<input type="hidden" id="userId" name="userId" value="${loginUser.userId}">
			<div class="label-wrapper">
				<label for="currentPassword">현재 비밀번호</label>
			</div>
			<input type="password" id="currentPassword" name="currentPassword" required>
			<hr>
			<p id="currentMsg"></p>
			<div class="label-wrapper">
				<label for="password">변경할 비밀번호</label>
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
			<input type="text" id="lastName" name="lastName" value="${loginUser.lastName}">
			<hr>
			<div class="label-wrapper">
				<label for="firstName">이름</label>
			</div>
			<input type="text" id="firstName" name="firstName" value="${loginUser.firstName}">
			<hr>
			<div class="label-wrapper">
				<label for="birthDate">생년월일</label>
			</div>
			<input type="date" id="birthDate" name="birthDate" value="${loginUser.birthDate}" min="1900-01-01" max="2022-11-23">
			<div class="label-wrapper">
				<label for="phone">전화번호</label>
			</div>
			<input type="text" id="phone" name="phone" value="${loginUser.phone}">
			<hr>
			<div class="label-wrapper">
				<label for="address">주소</label>
			</div>
			<input type="text" id="address" name="address" size="59" value="${loginUser.address}">
			<hr>
			<div style="display: block; margin: 20px auto;">
				<button type="submit" id="btnUpdate">수정하기</button>
			</div>
		</form>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
	<script>
		$(function() {
			
			//회원정보 수정 실패 시 메시지 출력
			if($("#updateMsg").val() != "" && $("#updateMsg").val() != null) {
				alert($("#updateMsg").val());
			}
			
			
			//기존 비밀번호와 일치하는지 확인하는 플래그
			var currentPwCheck = false;
			//password가 형식에 맞게 작성됐는지(특수문자 + 영문자 + 숫자 8자리)
			var pwValidation = false;
			//password가 확인란과 일치하는지
			var pwCheck = false;
			
			$("#pwValidation").hide();
			$("#pwCheckResult").hide();

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
			
			//회원정보 수정 진행
			$("#updateForm").on("submit", function(e) {
				
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
				
				//현재 비밀번호 일치하지 않을 때
				if(!currentPwCheck) {
					alert("현재 비밀번호가 일치하지 않습니다.");
					$("#currentPassword").focus();
					e.preventDefault();
					return;
				}
			});
			
			//현재 비밀번호 체크
			$("#currentPassword").on("change", function() {
				$.ajax({
					url: "/Account/currentPwdCheck.do",
					type: 'post',
					data: {
						userId: $("#userId").val() ,
						currentPassword: $("#currentPassword").val() 
					},
					success: function(obj) {
						if(obj == 'pwdOk') {
							currentPwCheck = true;
							$("#currentMsg").text("비밀번호를 변경해주세요.").css("color","green");
						} else {
							currentPwCheck = false;
							$("#currentMsg").text("비밀번호를 다시 입력해주세요.").css("color","red");
						}
					},
					error: function(e) {
						console.log(e);
					}
				});
			});
		});
	</script>
</body>
</html>