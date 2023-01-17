<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>୧(๑•̀ᗝ•́)૭</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<style>
		#header{width: 100%; text-align: center; display: inline-block;}
		body {background : #F6F6F6;}
	    /* 최 상단 로그인 메뉴 */
	    #top_container{ width: 100%; margin-top: -10px;}
	    #top_menu{ width: 1200px; display: inline-block;}
	    #top_menu ul,  #top_menu li{ list-style: none;}
	    #top_menu ul li{ margin-right: 30px; float: right;}
	    #top_menu ul li a{ text-align: center; font-size: 0.9em; font-family: 'Noto Sans KR', sans-serif; font-weight : bolder;
	        text-decoration: none; color: #828282;}
	        
	    /* 상단 메뉴 */
	    #img_logo{ width: 250px; object-fit: cover;margin-top : -40px; margin-left : 0px}
	    #img_menu{ width: 30px; object-fit: cover}
	    #middle_container{ width: 1200px; height: 90px; display: inline-block;}
	    #middle_menu{padding-top: 15px;}
	    #middle_menu ul, #middle_menu li{ list-style: none;}
	    #middle_menu ul li{ float: left;}
	    #middle_menu ul li a{ text-align: center; font-size: medium ; margin-right: 50px; font-family: 'Noto Sans KR', sans-serif;
	        text-decoration: none; color: inherit; font-weight : bolder;}
	    #middle_menu ul li:first-child{margin-right: 30px;}
	   
</style>
<script>
	$(document).ready(function(){
		//메뉴 페이지 클릭 이벤트
        $("#img_menu").click(function(e){
            if($("#category").css("display")=="none"){
                $("#img_menu").attr("src", "../../resources/images/X.png");
                $("#category").css("display", "inline-block");
                
                $('#header').on('scroll touchmove mousewheel', function(event) {
                	  event.preventDefault();
                	  event.stopPropagation();
                	  return false;
                	});
            }
            else{
                $("#img_menu").attr("src", "../../resources/images/menu.png");
                $("#category").css("display", "none");
            }
        })
        //메뉴가 열려있을때 바깥의 반투명 페이지 클릭시
        $("#category_black").click(function(e){
            $("#img_menu").attr("src", "../../resources/images/menu.png");
            $("#category").css("display", "none");
        })
	})
</script>
<link rel="icon" href="${pageContext.request.contextPath }/favicon.ico">
</head>
<body>
	<div id="header">
		<!--최상단 메뉴-->
        <div id="top_container">
            <nav id="top_menu">
                <ul>
                    <li><a href="#">고객센터</a></li>
                    <c:choose>
                    	<c:when test="${loginUser eq null}">
                    		<li><a href="/Account/join.do">회원가입</a></li>
                    		<li><a href="/Account/login.do">로그인</a></li>
                    	</c:when>
						<c:otherwise>
						    <li><a href="/Account/logout.do">로그아웃</a></li>
                    		<li><a href="/Account/userInfo.do">${loginUser.fullName}님</a></li>
						</c:otherwise>
					</c:choose>
                </ul>
            </nav>
        </div>
        <!-- 상단 메뉴-->
        <div id="middle_container">
            <nav id="middle_menu">
                <ul>
                    <li><a href="/mainPage.do"><img id="img_logo" src="${pageContext.request.contextPath}/resources/images/logo.png"></a></li>
                    <li><a href="#">항공권 예매</a></li>
                    <li><a href="/Account/userInfo.do">마이페이지</a></li>
                    <li><a href="/airport/airportInfo.do">공항정보</a></li>
                    <li><a href="/board/getBoardList.do">질문게시판</a></li>
                    <li><a href="#">이벤트</a></li>
                </ul>
            </nav>
        </div>
	</div>

</body>
</html>