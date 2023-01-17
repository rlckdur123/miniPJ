<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<style>
	footer {
		display: flex;
		justify-content: center;
		align-items: center;
		background: #d2d2d2;
		border-top: 2px solid orange;
	}
	#footer_container{ width: 1200px; margin-top: -10px; display: inline-block;justify-content: center;}
    #footer_menu li:first-child { margin-left : 135px;}
    #footer_menu ul {margin-top : 20px;}
    #footer_menu ul,  #footer_menu li{ list-style: none;}
    #footer_menu ul li{ margin-right: 100px; float: left;}
    #footer_menu ul li a{ text-align: center; font-size: 1em; font-family: 'Noto Sans KR', sans-serif;
        text-decoration: none; color: inherit;}
    #footer_p { font-family: 'Noto Sans KR', sans-serif;justify-content: center; text-align : center; margin-top : 30px;}
</style>
</head>
<body>
	<footer>
 	<div id="footer_container">
		<nav id="footer_menu">
			<ul>
				<li><a href="#">회사소개</a></li>
                <li><a href="#">여객운송약관</a></li>
                <li><a href="#">홈페이지 이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">사이트맵</a></li>
            </ul>
        </nav>
       	<br>
       	<div>
    		<p id="footer_p">
				(주)썬투나잇항공 사업자등록번호 : 111-22-33333 대표이사 : 레드썬<br>
				서울특별시 서초구 반포동 사평대로 310-4(썬투나잇회관 7층)<br><br>
				Copyright ⓒ SunToNightAIR. All Rights Reserved.
			</p>
    	</div>
    </div>
</footer>
</body>
</html>