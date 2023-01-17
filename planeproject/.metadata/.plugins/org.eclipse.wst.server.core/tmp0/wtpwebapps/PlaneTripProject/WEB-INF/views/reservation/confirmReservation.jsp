<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>୧(๑•̀ᗝ•́)૭</title>
<style>
   body { background-color : #F6F6F6;}
    #container{ width: 100%; display: inline-block; text-align: center;}
    
    #r_arrow { width : 10px; height : 15px; margin-right : 15px; margin-left : 15px;}
	#p_location { width : 100%; height : 50px; text-align : center; font-weight : bold; color:#848484; background-color :#d2d2d2;
	  margin-top : 15px; margin-bottom : 15px; font-size : 1.1em; border-top : 2px solid orange; border-bottom : 2px solid orange;
	}
	
   #content{ width: 600px; height: 300px; text-align: center; border : 2px solid #d2d2d2;
         border-radius : 10px; display: inline-block; margin-top: 130px; margin-bottom: 130px;}
   #msg{ width: 100%; font-size: xx-large; margin-top: 90px; font-weight: bold;}
    #btn_div{ margin-top: 50px;}
   #back_home{ padding: 10px; text-decoration: none; border-radius: 5px; color: white;
        background-color: #ff5000;}
   
</style>
<script>
    $(function() {
        
    });
</script>
</head>

<body>
   <jsp:include page="/header.jsp"></jsp:include>
   <div id="p_location">
			<div style="display: inline-block;text-align:left; width:1070px; margin-top : 14px;">
				<span>홈<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">항공권 예매<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">탑승자정보입력</span>
			</div>
		</div>
    <div id="container">
        <div id="content">
            <div id="msg">예약에 성공하셨습니다!</div>
            <nav id="btn_div">
                <a href="/mainPage.do" id="back_home">돌아가기</a>
            </nav>
        </div>
    </div>
   <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>