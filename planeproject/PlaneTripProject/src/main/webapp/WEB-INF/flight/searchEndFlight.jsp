<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공편 조회</title>
</head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<!-- 상단 웹페이지 스크립트 -->
<style>
		body { background-color : #F6F6F6;}
        #container{ width: 100%; height: 100%; text-align: center;justify-content: center;}
        /*메뉴 위치선정 */
        #category_menu nav{ display: inline-block; text-align: center;}
        .line1{ position: absolute; top: 0px; left: 8.25%; border-left: 1px solid #f2f2f2; width: 16.5%; height: 280px;}
        .line2{ position: absolute; top: 0px; left: 24.75%; border-left: 1px solid #f2f2f2; width: 16.5%; height: 280px;}
        .line3{ position: absolute; top: 0px; left: 41.25%; border-left: 1px solid #f2f2f2; width: 16.5%; height: 280px;}
        .line4{ position: absolute; top: 0px; left: 57.75%; border-left: 1px solid #f2f2f2; width: 16.5%; height: 280px;}
        .line5{ position: absolute; top: 0px; left: 74.25%; border-left: 1px solid #f2f2f2; width: 16.5%; height: 280px;
            border-right: 1px solid #f2f2f2;}
        /*아래 반투명 화면*/
        #category_black{ width: 100%; height: 100%; background-color: black; opacity: 0.5;}

        /*티케팅 창*/
        #ticketing{ width: 1200px; margin-top: 20px; display: inline-block;}
        #ticketing_box{ width: 100%; height: 220px; box-shadow: 0 0 4px #c8c8c8;
            border-radius: 10px; background-color : white;}
        #way ul, #way li{ list-style: none;}
        #way li{ float: left; margin-right: 30px; margin-top: 20px; font-weight: light;
            font-family: 'Jua', sans-serif; font-size: medium;}
        #round{ color: #ff5000; border-bottom: #ff5000 2px solid; text-decoration: none; margin-left : 125px}
        #oneway{ text-decoration: none; color: inherit; }

        #form_div{clear: both; padding-top: 20px; text-align: left;}
        #starting_point{width: 270px; height: 50px; color: #8c8c8c; cursor: pointer; margin-left: 165px;
            border: none; border-bottom: solid #c8c8c8 1px; background-color:transparent; 
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: x-large;}
        #swap{ width: 30px; height: 30px; border: none; margin-left: 10px; margin-right: 10px;
            background: url( "../../resources/images/arrow.png") no-repeat; cursor: pointer; border-radius: 100%;}
        #arrive_point{width: 270px; height: 50px; color: #8c8c8c; cursor: pointer;
            border: none; border-bottom: solid #c8c8c8 1px; background-color:transparent;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: x-large;}
        #calendar_date{ width: 250px; height: 43px; margin-left: 20px; background-color:transparent;
            background-image: url("../../resources/images/calendar.png"); background-repeat: no-repeat;
            background-size: 20px; background-position: left; cursor: pointer;
            border-style: none; border-bottom: solid #c8c8c8 1px;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: medium;}
        #person{ width: 270px; height: 43px; margin-top: 20px; background-color: transparent;
            background-image: url("../../resources/images/person.png"); background-repeat: no-repeat;
            background-size: 20px; background-position: 10px center; cursor: pointer;
            border-style: none;  border-bottom: solid #c8c8c8 1px; margin-left: 165px;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: medium;}
        #serch{ width: 200px; height: 50px; margin-left: 400px; margin-top: 30px; cursor: pointer;
            background-color: #aaaaaa; color: white; border: none; border-radius: 5px;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large;}
            
        /*출발지*/
        #starting_point_serch{ width: 950px; height: 400px; background-color: white;
            display: none; position: absolute; opacity: none; z-index: 2;
            top: 50%; left: 50%; transform: translate(-50%, -35%); box-shadow: 0 0 4px #c8c8c8;
            margin-top: 150px;}
        #dummy_serch{ width: 100%; height: 60px;}
        #dummy_serch_img{ width: 20px; height: 20px; float: left; cursor: pointer;
             margin-top: 25px; margin-left: 30px;}
        #dummy_serch input{ width: 830px; height: 40px; margin: 10px; float: left; border: none;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large; outline: none;
            margin-top : 14px;}
        .close{ width: 20px; height: 20px; float: right; cursor: pointer;
            margin-top: 25px; margin-right: 25px;}

        #starting_point_list1{ width: 20%; height: 330px; float: left; background-color: #f2f2f2}
        #starting_point_list1 ul { margin-left : -40px; margin-top : -5px; list-style: none;}
        #starting_point_list1 li{ width: 100%; height: 40px; padding-top: 15px;
            background-color: #f2f2f2;  border-bottom: #dcdcdc solid 1px;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large;}
        #starting_point_list1 li:first-child{ background-color: white;}

        #starting_point_list2{ width: 80%; height: 330px; float: right; background-color: white}
        #starting_point_list2 ul { margin-top : -5px; list-style: none;}
        #starting_point_list2 div{ width: 100%; height: 35px; text-align: left;
            padding-top: 5px; padding-left: 20px; cursor: pointer;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large;}
        #starting_point_list2 div:first-child{ padding-top: 15px;}
        #starting_point_list2 li a{ color: #aaaaaa;}

        /* 도착지 */
        #arrive_point_serch{ width: 950px; height: 400px; background-color: white; 
            display: none; position: absolute; opacity: none; z-index: 2;
            top: 50%; left: 50%; transform: translate(-50%, -35%); box-shadow: 0 0 4px #c8c8c8;
            margin-top: 150px;}
        #arrive_point_list1{ width: 20%; height: 330px; float: left; background-color: #f2f2f2}
        #arrive_point_list1 ul { margin-left : -40px; margin-top : -5px;  list-style: none;}
        #arrive_point_list1 li{ width: 100%; height: 40px; padding-top: 15px;
            background-color: #f2f2f2;  border-bottom: #dcdcdc solid 1px;
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large;}
        #arrive_point_list1 li:first-child{ background-color: white;}
        #arrive_point_list2{ width: 80%; height: 330px; float: right; background-color: white}
        #arrive_point_list2 ul { margin-top : -5px;  list-style: none;}
        #arrive_point_list2 div{ width: 100%; height: 35px; text-align: left;
            padding-top: 5px; padding-left: 20px; cursor: pointer; 
            font-family: 'Jua', sans-serif; font-weight: bold; font-size: large;}
        #arrive_point_list2 div:first-child{ padding-top: 15px;}
        
        /* 날짜 선택(달력) */
        #calendar{ width: 950px; height: 400px; background-color: white; 
            display: none; position: absolute; opacity: none; z-index: 2;
            top: 50%; left: 50%; transform: translate(-50%, -46%); box-shadow: 0 0 4px #c8c8c8;}
        #calendar .close{ position: absolute; top: 0%; right: 0%;}
        #cal1_div{ width: 50%; height: 100%; float: left;}
        #cal2_div{ width: 50%; height: 100%; float: left;}
        
        #cal_pre{ position: absolute; left: 2%; top: 43%; border: none; background: none;}
        #cal_next{ position: absolute; right: 2%; top: 43%; border: none; background: none; }

        #cal1_year, #cal1_month{ position: absolute; font-size: large; font-weight: bold;}
        #cal1_year{left: 8%; top: 4%;}
        #cal1_month{left: 15%; top:4%;}
        #cal1 { display: flex; flex-wrap: wrap; width: 80%; margin-left: 13%; margin-top: 10%;}
        .asdf{ text-align: center; width: calc(100%/7); height: 50px; box-sizing: border-box;line-height: 3;
             border-radius: 3px; color: #c8c8c8 !important;}
        #cal1 > .date {text-align: center; width: calc(100%/7); height: 50px; box-sizing: border-box;line-height: 3; border-radius: 3px;} 
        #cal1 > .date:nth-child(7n){color: blue;}
        #cal1 > .date:nth-child(7n+1){color: red;}
        
        #cal2_year, #cal2_month{ position: absolute; font-size: large; font-weight: bold;}
        #cal2_year{left: 55%; top: 4%;}
        #cal2_month{left: 62%; top:4%;}
        #cal2 { display: flex; flex-wrap: wrap; width: 80%; margin-left: 7%; margin-top: 10%;}
        #cal2 > .date {text-align: center; width: calc(100%/7); height: 50px; box-sizing: border-box;line-height: 3; border-radius: 3px; cursor: Z;} 
        #cal2 > .date:nth-child(7n){color: blue;}
        #cal2 > .date:nth-child(7n+1){color: red;}
        #cal2 > .date2 {text-align: center; width: calc(100%/7); height: 50px; box-sizing: border-box;line-height: 3; border-radius: 3px; cursor: Z;} 
        #cal2 > .date2:nth-child(7n){color: blue;}
        #cal2 > .date2:nth-child(7n+1){color: red;}
        
        #date_select{ width: 100px; height: 30px; position: absolute; bottom: 4%; left: 44.5%;
            border: none; background-color: #ff5000; color: white; font-family: 'Jua';}

        /*인원수*/
        #personnel{  width: 950px; height: 300px; background-color: white; 
            display: none; position: absolute; opacity: none; z-index: 2;
            top: 50%; left: 50%; transform: translate(-50%, -35%); box-shadow: 0 0 4px #c8c8c8; }
        #personnel img{ width: 30px; height: 30px; position: absolute; top: 10%; left: 47.5%;}
        #personnel_body input{ width: 30px; height: 30px; text-align: center;
            border: none; border-bottom: 1px solid #dcdcdc;}
        #personnel_body>div button{  width: 30px; height: 30px; border-radius: 100%; border: none; }
        #personnel_header{ height: 30%;}
        #personnel_header_left{ width: 50%; float: left; margin-top: 3%; font-family: 'Jua'}
        #personnel_header_right{ width: 50%; float: left; margin-top: 3%; font-family: 'Jua'}
        #p_start{ font-size: x-large;}
        #p_arrive{ font-size: x-large;}
        #personnel_body{ clear: both; width: 100%; height: 70%; }
        #personnel_body_left{ width: 33.33%; height: 100%; float: left;}
        #personnel_body_center{ width: 33.33%; height: 100%; float: left;}
        #personnel_body_right{ width: 33.33%; height: 100%; float: left;}
        .body_text_title{ margin-top: 10%; margin-left: 10%; text-align: left; }
        .body_text_content{ margin-top: 1%; margin-left: 10%; text-align: left; font-size: small;}
        #body_button_left{ position: absolute; left:18%; top: 45%;}
        #body_button_center{ position: absolute; left:51.33%; top: 45%;}
        #body_button_right{ position: absolute; left:84.66%; top: 45%;}

        #select_personnel{ width: 150px; height: 40px; position: absolute; bottom: 6%; left: 41%;
            background-color: #ff5000; border: none; color: white; border-radius: 5px; 
            font-family: 'Jua'; font-size: large;}
            
		/* 조회된 비행편 정렬되는 창 */
		#flightList {
			width: 100%;
			display: inline-block;
			text-align:center;
		}

		/* 조회수가 많을 경우 조회페이지를 나누어 보여줌. */
		#pageNumber {
			display: inline-block;
			margin: 0px; padding: 0px;
			width: 200px; height: 50px;
		}
		/* 페이지 숫자표시 div*/
		.pagination {
			list-style: none;
			width: 100%;
			display: inline-block;
		}
		
		.pagination_button {
			float: left;
			margin-left: 5px;
		}
		/* 안보이는 리스트 처리 */
		.idList {
			display: none;
		}
		
		/* 항공편 부분 */
		.showList {
			display: inline-block;
			width:1200px; height:130px;
			border: 1px solid #bebebe;
			margin-top:20px;
			border-radius: 8px;
			background-color: white;
		}
		.column{
			width:39%; height:100%; float:left;
			position:relative;
		}
		.columns{
			border-left: 1px solid #bebebe;
			width: 20%; height:100%; float:right;
			position:relative;
		}
		#class1{
			border-top-right-radius: 8px;
			borderbottom-right-radius: 8px;
		}
		#class1>.classCol{
			color: #FF0000;
		}
		#class2>.classCol{
			color: #FF9100;
		}
		#class3>.classCol{
			color: #0000CD;
		}
		.flight_code{
			position: absolute; top: 18px; left: 215px; /* 왼쪽으로 보내려면 left: 18px; */
		 }
		.under_line{
			width: 80%; height: 0.01px;
			border-bottom: 1px solid #bebebe;
			position: absolute; top:55px; left:10%;
		}
		.start_time{
			font-size: x-large; font-weight: bold;
			position: absolute; bottom: 18px; left: 80px;
		}
		.start_time>span{
			display: none;
		}
		.finish_time{
			font-size: x-large;font-weight: bold;
			position: absolute; bottom: 18px; right: 80px;
		}
		.finish_time>span{
			display: none;
		}
		.column>img{ position: absolute; bottom: 20px;}
		
		.classCol {
			width: 100%;
			position: absolute; top:18px; left: 0;
			font-size: x-large;
		}
		.priceCol {
			width: 100%;
			position: absolute; top:53px; left: 0;
			font-size: x-large;
		}
		.remainCol {
			width: 100%;
			position: absolute; bottom: 15px; left: 0;
			color: #828282;
		}
		#pageNumber_div{
			width: 100%;
		}
		#under_div{
			width: 100%; height: 60px; position:fixed; background-color: rgba(0, 0, 0, 0.8);
			bottom:0; 
		}
		#under_div_position{ 
			width: 1200px; display: inline-block;
		}
		#selectButton{
			width:150px; height:40px; float:right; border: none; border-radius: 4px; font-weight:bold;
			margin-top: 10px; margin-right: 10px;  background-color: #8c8c8c; color:white;
		}
</style>

<!-- 상단 웹페이지 스크립트 -->
<script>
    $(document).ready(function(){
        let way = 0;        //왕복 편도
        let flag = false;   //유효성검사
        let start = $(".start").get();
        let arrive = $(".arrive").get();
        //날짜
        var CDate = new Date();
        let selectedDate = $("#calendar_date").val();
        let today = new Date();
        let day = ["일", "월", "화", "수", "목", "금", "토"];
        let e_target1;  //첫번째 클릭한 날짜 오브젝트 저장
        let e_target2;
        let text1;      //출발날짜 저장파일
        let text2;      //도착날짜 저장
        let textd1;     //.찍혀있는 날짜
        let textd2;
        let date_flag = 0;

        let dtemp = 0;
        //여행 날짜 기본설정
        $("#calendar_date").val(selectedDate);
        //$("#calendar_date").val(today.getFullYear() + "." + (today.getMonth()+1) + "." + today.getDate() + " ~ " + today.getFullYear() + "." + (today.getMonth()+1) + "." + today.getDate());
       
        //왕복, 편도(왕복일때 way=0, 편도일때 way=1)
        $("#round").click(function(e){
            way=0;
            $("#round").css("color","#ff5000").css("border-bottom", "#ff5000 2px solid");
            $("#oneway").css("color", "black").css("border-bottom", "none");
        })
        $("#oneway").click(function(e){
            way=1;
            $("#oneway").css("color","#ff5000").css("border-bottom", "#ff5000 2px solid");
            $("#round").css("color", "black").css("border-bottom", "none");
        })
        //출발지 입력창
        $("#starting_point").click(function(e){
            $("#starting_point_serch").css("display", "inline-block");
            $("#arrive_point_serch").css("display", "none");
            $("#calendar").css("display", "none");
            $("#personnel").css("display", "none");
        })
        for(let i = 0; i < start.length; i++){
            $(start[i]).click(function(e){
                $("#starting_point").val(start[i].innerHTML);
                $("#departPointId").val(i+1);	//공항의 id를 저장
                $("#starting_point").css("color", "black");
                $("#starting_point_serch").css("display", "none");
                flag=true;
            })
        }

        //도착지 입력창
        $("#arrive_point").click(function(e){
            if(!flag){
                alert("도착지를 입력해주세요.")
                return;
            }
            else
                $("#arrive_point_serch").css("display", "inline-block");
            	$("#starting_point_serch").css("display", "none");
                $("#calendar").css("display", "none");
                $("#personnel").css("display", "none");
        })
        for(let i = 0; i < arrive.length; i++){
            $(arrive[i]).click(function(e){
                $("#arrive_point").val(arrive[i].innerHTML);
                $("#arrivedPointId").val(i+1);	//공항의 id를 저장
                $("#arrive_point").css("color", "black");
                $("#arrive_point_serch").css("display", "none");
            })
        }

        //출발지 도착지 스왑
        $("#swap").click(function(){
            if($("#arrive_point").val() == "도착지"){

            }
            else{ 
                let temp = $("#arrive_point").val();
                let temp2 = $("#arrivedPointId").val();
                $("#arrive_point").val($("#starting_point").val());
                $("#arrivedPointId").val($("#departPointId").val());
                $("#starting_point").val(temp);
                $("#departPointId").val(temp2);
            }
        })

        //달력 만들기
        $.create_cal = function (num) {
	        let htmlDates = ''; 
            let prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0); //지난 달의 마지막 날 
            let thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1); //이번 달의 첫쨰 날
            let thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0); //이번 달의 마지막 날
            const dates = []; 

            $("#cal1_year").html(CDate.getFullYear() + "년");
            $("#cal1_month").html((CDate.getMonth() + 1) + "월");
            if((CDate.getMonth() + 2) == 13){
                $("#cal2_year").html((CDate.getFullYear() + 1) + "년");
                $("#cal2_month").html( "1월");
            }
            else{
                $("#cal2_year").html(CDate.getFullYear() + "년");
                $("#cal2_month").html((CDate.getMonth() + 2) + "월");
            }
            
            

            if(thisFirst.getDay()!=0){ 
                for(let i = 0; i < thisFirst.getDay(); i++){
                    dates.unshift(prevLast.getDate()-i); // 지난 달 날짜 채우기
                } 
            } 
            for(let i = 1; i <= thisLast.getDate(); i++){
                    dates.push(i); // 이번 달 날짜 채우기 
            } 
            for(let i = 1; i <= 13 - thisLast.getDay(); i++){ 
                    dates.push(i); // 다음 달 날짜 채우기 (나머지 다 채운 다음 출력할 때 42개만 출력함)
            } 
            
            //inner html에 데이터 잔뜩 집어넣기
            if(num == 1){
                for(let i = 0; i < 42; i++){
                    if(i < thisFirst.getDay()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else if(today.getDate() > dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else if(today.getDate()==dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
                        htmlDates += '<div id="date_'+dates[i]+'" class="date">'+dates[i]+'</div>'; 
                    }else if(i >= thisFirst.getDay() + thisLast.getDate()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else{
                        htmlDates += '<div id="date_'+dates[i]+'" class="date">'+dates[i]+'</div>'; 
                    }
                }
            }
            else if(num == 2){
                for(let i = 0; i < 42; i++){
                    if(i < thisFirst.getDay()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else if(today.getDate() > dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else if(today.getDate()==dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
                        htmlDates += '<div id="date2_'+dates[i]+'" class="date">'+dates[i]+'</div>'; 
                    }else if(i >= thisFirst.getDay() + thisLast.getDate()){
                        htmlDates += '<div class="asdf">'+dates[i]+'</div>'; 
                    }else{
                        htmlDates += '<div id="date2_'+dates[i]+'" class="date2">'+dates[i]+'</div>'; 
                    }
                }
            }
            // div에 넣기
            return htmlDates;
        }

        //뒷배경 지우기 함수
        $.clear = function() {
            $(".date").css("background-color", "");
            $(".date").css("color", "");
            $(".date2").css("background-color", "");
            $(".date2").css("color", "");
        };

        //앞 달력 이벤트
        $(document).on("click", ".date", function(e){
            if(dtemp == 0){
                $.clear();
                $(e.target).css("background-color", "red");
                $(e.target).css("color", "white");

                console.log(e.target);
                e_target1 = e.target;
                dtemp = 1;
            }
            else if(dtemp == 1){
                if(e_target1.className == "date" && ((Number)(e_target1.textContent)) > ((Number)(e.target.textContent))){
                    alert("일정을 확인해주세요");
                    $.clear();
                }
                else if(e_target1.className == "date2"){
                    alert("일정을 확인해주세요");
                    $.clear();
                }
                else{
                    e_target2 = e.target;
                    $(e.target).css("background-color", "red");
                    $(e.target).css("color", "white");
                    for(let i = ((Number)(e_target1.textContent)) + 1; i < e.target.textContent; i++){
                        $("#date_"+i).css("background-color", "#FFDDDD");
                    }
                }
                dtemp = 0;
            }
        })
        //뒤 달력 이벤트
        $(document).on("click", ".date2", function(e){
            if(dtemp == 0){	//아무것도 선택하지 않은 상태일때
                $.clear();
                $(e.target).css("background-color", "red");
                $(e.target).css("color", "white");
                
                e_target1 = e.target;
                dtemp = 1
            }
            else if(dtemp == 1){	//날짜한개를 선택한 상태일때
            	//날짜
                if(e_target1.className == "date2" && ((Number)(e_target1.textContent)) > ((Number)(e.target.textContent))){
                    alert("두번째 선택하는 날짜는 첫번째 날짜보다 이전일 수 없습니다.");
                    $.clear();
                }
                else{	//정상적으로 날짜를 선택했을때
                    e_target2 = e.target;
                    $(e.target).css("background-color", "red");
                    $(e.target).css("color", "white");
                    if(e_target1.className == "date"){
                        for(let i = ((Number)(e_target1.textContent)) + 1; i < 32; i++){
                            $("#date_"+i).css("background-color", "#FFDDDD");
                            for(let j = 1; j < e.target.textContent; j++){
                                $("#date2_"+j).css("background-color", "#FFDDDD");
                            }
                        }
                    }
                    else{
                        for(let i = ((Number)(e_target1.textContent)) + 1; i < e.target.textContent; i++){
                        $("#date2_"+i).css("background-color", "#FFDDDD");
                    }
                    }
                }
                dtemp = 0;
            }
        })


        //달력 열기
        $("#calendar_date").click(function(e){
            if($("#arrive_point").val() == "도착지"){
                alert("도착지를 설정해주세요");
            }
            else{ 
                $("#calendar").css("display", "inline-block");
                $("#starting_point_serch").css("display", "none");
                $("#arrive_point_serch").css("display", "none");
                $("#personnel").css("display", "none");
                CDate.setMonth(CDate.getMonth()+1);
                let text = $.create_cal(2);
                $("#cal2").html(text);
                CDate.setMonth(CDate.getMonth()-1);
                text = $.create_cal(1);
                $("#cal1").html(text);
            }
        })
        //이전달 버튼
        $("#cal_pre").click(function(e){
            let text = $.create_cal(2);
            $("#cal2").html(text);
            CDate.setMonth(CDate.getMonth()-1); 
            text = $.create_cal(1);
            $("#cal1").html(text);
        })
        //다음달 버튼
        $("#cal_next").click(function(e){
            CDate.setMonth(CDate.getMonth()+2);
            let text = $.create_cal(2);
            $("#cal2").html(text);
            CDate.setMonth(CDate.getMonth()-1); 
            text = $.create_cal(1);
            $("#cal1").html(text);
        })

        //달력 선택버튼
        $("#date_select").click(function(){
            let a = CDate.getFullYear().toString();
            let a2 = CDate.getFullYear().toString();
            let b = (CDate.getMonth()+1).toString();
            let b2 = (CDate.getMonth()+2).toString();
            let c = ((String)(e_target1.textContent));
            let c2 = '';
            
            //날짜를 하나만 선택할시 조건 처리
            if(!e_target2) {
                c2 = ((String)(e_target1.textContent));
            } else {
                c2 = ((String)(e_target2.textContent));
            }
            console.log(c);
            console.log(c2);
            if(b2 == 13){
                a2 = (CDate.getFullYear()+1).toString();
                b2 = 1;
            }

            text1 = a + "-" + b + "-" +c;
            text2 = a2 + "-" + b2 + "-" +c2;
            textd1 = a + "." + b + "." +  c ;
            textd2 =  a2 + "." + b2 + "." + c2;
            date_flag = 1;

            $("#calendar_date").val(textd1 + " ~ " + textd2);
            $("#minimumDate").val(textd1);
            $("#maximumDate").val(textd2);
            $("#serch").attr("disabled", false).css("background-color", "#ff5000");
            $("#calendar").css("display", "none");
        })
        
        //인원수 선택 버튼
        $("#person").click(function(){
            if(date_flag == 0){
                alert("여정 및 일정을 먼저 선택해주세요"); 
            }
            else if(date_flag == 1){
                $("#personnel").css("display", ("inline-block"));
                $("#p_start").text($("#starting_point").val());
                $("#p_startd").text(textd1);
                $("#p_arrive").text($("#arrive_point").val());
                $("#p_arrived").text(textd2);
            }
        })

        //인원수 처리 버튼
        //왼쪽(성인)
        let adultNumber = 1; //다음페이지로 가지고 갈 데이터 변수
        $("#left_down").click(function(){
            let num = $("#left_text").val();
            num--;
            $("#left_text").val(num);
            adultNumber = num;
            if(num == 0){
                $("#left_down").attr("disabled",true);
            }
            else if(num == 8){
                $("#left_up").attr("disabled",false);
            }
        })
        $("#left_up").click(function(){
            let num = $("#left_text").val();
            num++;
            $("#left_text").val(num);
            adultNumber = num;
            if(num == 9){
                $("#left_up").attr("disabled",true);
            }
            else if(num == 1){
                $("#left_down").attr("disabled",false);
            }
        })
        //중앙(어린이)
        let childNumber = 0;	//다음페이지로 가지고 갈 데이터 변수
        $("#center_down").click(function(){
            let num = $("#center_text").val();
            num--;
            $("#center_text").val(num);
            childNumber = num;
            if(num == 0){
                $("#center_down").attr("disabled",true);
            }
            else if(num == 8){
                $("#center_up").attr("disabled",false);
            }
        })
        $("#center_up").click(function(){
            let num = $("#center_text").val();
            num++;
            $("#center_text").val(num);
            childNumber = num;
            if(num == 9){
                $("#center_up").attr("disabled",true);
            }
            else if(num == 1){
                $("#center_down").attr("disabled",false);
            }
        })
        //오른쪽(유아)
        let babyNumber = 0; //다음페이지로 가지고 갈 데이터 변수
        $("#right_down").click(function(){
            let num = $("#right_text").val();
            num--;
            $("#right_text").val(num);
            babyNumber = num;
            if(num == 0){
                $("#right_down").attr("disabled",true);
            }
            else if(num == 8){
                $("#right_up").attr("disabled",false);
            }
        })
        $("#right_up").click(function(){
            let num = $("#right_text").val();
            num++;
            $("#right_text").val(num);
            babyNumber = num;
            if(num == 9){
                $("#right_up").attr("disabled",true);
            }
            else if(num == 1){
                $("#right_down").attr("disabled",false);
            }
        })

        //인원수 선택 버튼
        $("#select_personnel").click(function(){
            let txt = "";
            $("#personnel").css("display", "none");

            if($("#left_text").val() > 0){
                txt = "성인" + ((String)($("#left_text").val()));
            }
            if($("#center_text").val() > 0){
                txt += ", 소아" + $("#center_text").val();
            }
            if($("#right_text").val() > 0){
                txt += ", 유아" + $("#right_text").val();
            }
            $("#person").val(txt);
        })
        
        //닫기
        $(".close").click(function(e){
            $("#starting_point_serch").css("display", "none");
            $("#arrive_point_serch").css("display", "none");
            $("#calendar").css("display", "none");
        })

        //항공권 검색 버튼
        $("#serch").click(function(){
        	$("#info").submit();
        })
        
        //항공권 등급 숫자-> 문자
        
    })

</script>
<body>
<jsp:include page="/header.jsp"></jsp:include>
    <!--전체 화면 컨테이너-->
    <div id="container">
        <!--표 예매-->
        <div id="ticketing">
            <div id="ticketing_box" style="position: relative; bottom: 60; z-index: 2;">
                <nav id="way">
                    <ul>
                        <li><a id="round" href="#">왕복</a></li>
                        <li><a id="oneway" href="#">편도</a></li>
                    </ul>
                </nav>
                <div id="form_div">
                    <form id="info" action="/flight/searchArriveFlight.do" method="post">
                        <input type="button" id="starting_point" value="${flightListArv[0].airportDpt }">
                      	<input type="hidden" id="departPointId" name="departPointId" value="${departFlyMap.departPointId }">
                        <input type="button" id="swap">
                        <input type="button" id="arrive_point" value="${flightListArv[0].airportArv }">
                        <input type="hidden" id="arrivedPointId" name="arrivedPointId" value="${departFlyMap.arrivedPointId }">
                        <input type="button" id="calendar_date" name="calendar" value="${departFlyMap.minimumDate} ~ ${departFlyMap.maximumDate}">
                        <input type="hidden" id="minimumDate" name="minimumDate" value="${departFlyMap.minimumDate}">
                        <input type="hidden" id="maximumDate" name="maximumDate" value="${departFlyMap.maximumDate}">
                        <input type="button" id="person" name="passengerNumber" value="${departFlyMap.passengerNumber}">
                       	<input type="hidden" id="adultNumber" name="adultNumber" value="${departFlyMap.adultNumber }">
                       	<input type="hidden" id="childNumber" name="childNumber" value="${departFlyMap.childNumber }">
                       	<input type="hidden" id="babyNumber" name="babyNumber" value="${departFlyMap.babyNumber }">
                        <input type="button" id="serch" value="항공권 검색" disabled>
                    	<input type="hidden" name="pageNum" value="${pageVO.cri.pageNum }">
						<input type="hidden" name="amount" value="${pageVO.cri.amount }">
						<input type="hidden" name="refresh" value="0">
                    </form>
                </div>
                <div id="starting_point_serch">
                    <nav id="dummy_serch">
                        <img id="dummy_serch_img" src="${pageContext.request.contextPath}/resources/images/serch.png">
                        <input type="text" placeholder="어디에서 출발하세요??" onfocus="this.placeholder=''" onblur="this.placeholder='어디에서 출발하세요??'">
                        <img class="close" src="${pageContext.request.contextPath}/resources/images/X.png">
                    </nav>
                    <hr>
                    <nav id="starting_point_list1">
                    	<ul>
	                        <li>대한민국</li>
                        </ul>
                    </nav>
                    <nav id="starting_point_list2">
                    	<ul>
	                    	<c:forEach items="${airportList}" var="airportList">
	                    		<div class="start">${airportList.airportName}&emsp;${airportList.airportCode }</div>
	                    	</c:forEach>
                    	</ul>
                    </nav>
                </div>
                <div id="arrive_point_serch">
                    <nav id="dummy_serch">
                        <img id="dummy_serch_img" src="${pageContext.request.contextPath}/resources/images/serch.png">
                        <input type="text" placeholder="어디로 여행가세요??" onfocus="this.placeholder=''" onblur="this.placeholder='어디로 여행가세요??'">
                        <img class="close" src="${pageContext.request.contextPath}/resources/images/X.png">
                    </nav>
                    <hr>
                    <nav id="arrive_point_list1">
                    	<ul>
	                        <li>대한민국</li>
                    	</ul>
                    </nav>
                    <nav id="arrive_point_list2">
	                    <ul>
	                    	<c:forEach items="${airportList}" var="airportList">
	                    		<div class="arrive">${airportList.airportName}&emsp;${airportList.airportCode }</div>
	                    	</c:forEach>
                    	</ul>
                    </nav>
                </div>
            </div>
            <!-- 달력 -->
            <div id="calendar">
                <div id="cal1_div">
                    <button id="cal_pre"><img src="${pageContext.request.contextPath}/resources/images/left_btn.png"></button>
                    <a id="cal1_year"></a>
                    <a id="cal1_month"></a>
                    <nav id="cal1"></nav>
                </div>
                <div id="cal2_div">
                    <button id="cal_next"><img src="${pageContext.request.contextPath}/resources/images/right_btn.png"></button>
                    <a id="cal2_year"></a>
                    <a id="cal2_month"></a>
                    <nav id="cal2"></nav>
                </div>
                <button id="date_select">선택</button>
                <img class="close" src="${pageContext.request.contextPath}/resources/images/X.png">
            </div>
            <!--인원수 선택-->
            <div id="personnel">
                <div id="personnel_header">
                    <div id="personnel_header_left">
                        <nav id="p_start"></nav>
                        <nav id="p_startd"></nav>
                    </div>
                    <img src="${pageContext.request.contextPath}/resources/images/arrow.png">
                    <div id="personnel_header_right">
                        <nav id="p_arrive"></nav>
                        <nav id="p_arrived"></nav>
                    </div>
                </div>
                
                <div id="personnel_body">
                    <hr>
                    <div id="personnel_body_left">
                        <div class="body_text_title">성인</div>
                        <div class="body_text_content">
                        <nav>12세 이상</nav>
                        </div>
                        <div id="body_button_left">
                            <button id="left_down">-</button>
                            <input type="text" id="left_text" value="1" readonly>
                            <button id="left_up">+</button>
                        </div>
                    </div>
                    <div id="personnel_body_center">
                        <div class="body_text_title">소아</div>
                        <div class="body_text_content">
                            <nav>12세 이상</nav>
                            <nav>(최초 출발일 기준)</nav>
                        </div>
                        <div id="body_button_center">
                            <button id="center_down" disabled>-</button>
                            <input type="text" id="center_text" value="0" readonly>
                            <button id="center_up">+</button>
                        </div>
                    </div>
                    <div id="personnel_body_right">
                        <div class="body_text_title">유아</div>
                        <div class="body_text_content">
                            <nav>생후 14일 이상~만 2세 미만</nav>
                            <nav>(만 24개월 미만/최종 탑승일 기준)</nav>   
                            <nav>유아의 여정이 동반 성인과 일치하지 않으면</nav>
                            <nav>환불 후 재구매해야 합니다.</nav>
                        </div>
                        <div id="body_button_right">
                            <button id="right_down" disabled>-</button>
                            <input type="text" id="right_text" value="0" readonly>
                            <button id="right_up">+</button>
                        </div>
                    </div>
                    <button id="select_personnel">선택</button>
                </div>
            </div>
        </div>
    </div>
      <div id="flightList">
      	<c:forEach items="${flightSeatList.flightList }" var="flightList" varStatus="status">
      	<div class="idList">${flightList.flightCode }</div>
      	<div class="idList">${flightList.flightId }</div>
      	<div class="showList">
      		<div class="column">
      			<div class="flight_code">${flightList.flightCode }</div>
      			<div class="under_line"></div>
      			<!-- 시간 데이터 표시는 fmt jstl사용. 가져갈 데이터는 숨겨서 따로 스크립트로 처리 -->
     		  	<div class="start_time"><fmt:formatDate value="${flightList.departTime }" pattern="HH:mm"/><span>${startDateList[status.index] }</span></div>
				<img src="${pageContext.request.contextPath}/resources/images/right_btn.png" width="20px" height="20px">
				<div class="finish_time"><fmt:formatDate value="${flightList.arrivalTime }" pattern="HH:mm"/><span>${arrivalDateList[status.index] }</span></div>
      		</div>
      		<c:forEach items="${flightSeatList.classList[status.index] }" var="classList" varStatus="status2">
      			<div id="class${status2.index + 1 }" class="columns">
      				<div class="classCol"><c:out value="${flightSeatList.classList[status.index][status2.index] }"></c:out></div>
      				<div class="priceCol"><c:out value="${flightSeatList.priceList[status.index][status2.index] }원"></c:out></div>
      				<div class="remainCol"><c:out value="${flightSeatList.remainSeat[status.index][status2.index] }명"></c:out></div>
      			</div>
      		</c:forEach>
      	</div>
      	</c:forEach>
		<c:forEach items="${flightList }" var="flightList">
			<input type="hidden" name="flightId" value="${flightList.flightId }">
			<input class="codeList" type="hidden" name="flightCode" value="${flightList.flightCode }">
		</c:forEach><!-- 검색된 비행편의 개수 -->
		<div id="pageNumber_div">
			<div id="pageNumber">
				<ul class="pagination">
					<c:if test="${pageVO.prev }">
						<li class="pagination_button">
							<a href="${pageVO.cri.pageNum - 1 }">이전</a>
						</li>
					</c:if>	
					<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
						<li class="pagination_button">
							<a href="${num }">${num }</a>
						</li>
					</c:forEach>
					<c:if test="${pageVO.next}">
						<li class="pagination_button">
							<a href="${pageVO.cri.pageNum + 1 }">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		<form id="checkFlight" action="/passenger/passenger.do" method="post">
			
			<input type="hidden" name="pageNum" value="${pageVO.cri.pageNum }">
			<input type="hidden" name="amount" value="${pageVO.cri.amount }">

			<!-- 출발 비행편의 정보 (승객 정보 페이지에서 사용할 변수들 저장) -->
			<input type="hidden" name="d_classId" value="${flightListDpt.classId }">
			<!-- 비행편의 이름 과 아이디도 같이 보냄 -->
			<input type="hidden" id="d_departPointCode" name="d_departPointCode" value="${flightListDpt.airportDpt }">
			<input type="hidden" id="d_arrivedPointCode" name="d_arrivedPointCode" value="${flightListDpt.airportArv }">
			<input type="hidden" id="d_departPointId" name="d_departPointId" value="${flightListDpt.departPointId }">
			<input type="hidden" id="d_arrivedPointId" name="d_arrivedPointId" value="${flightListDpt.arrivedPointId }">
			<input type="hidden" id="d_flightId" name="d_flightId" value="${flightListDpt.flightId}">
			<input type="hidden" id="d_departTime" name="d_departTime" value="${flightListDpt.departTime}">
			<input type="hidden" id="d_arrivalTime" name="d_arrivalTime" value="${flightListDpt.arrivalTime}">
            <input type="hidden" id="d_calendar_date" name="d_calendar" value="${flightListDpt.minimumDate} ~ ${flightListDpt.maximumDate}">
            <input type="hidden" id="d_minimumDate" name="d_minimumDate" value="${flightListDpt.minimumDate}">
            <input type="hidden" id="d_maximumDate" name="d_maximumDate" value="${flightListDpt.maximumDate}">
           	<input type="hidden" id="d_person" name="d_passengerNumber" value="${flightListDpt.passengerNumber}">
           	<input type="hidden" id="d_adultNumber" name="d_adultNumber" value="${flightListDpt.adultNumber }">
           	<input type="hidden" id="d_childNumber" name="d_childNumber" value="${flightListDpt.childNumber }">
           	<input type="hidden" id="d_babyNumber" name="d_babyNumber" value="${flightListDpt.babyNumber }">

			<!--회귀 비행편의 정보 -->
			<input type="hidden" name="classId" value="">
			<input type="hidden" id="departPointId" name="departPointId" value="${departFlyMap.departPointId }">
			<input type="hidden" id="arrivedPointId" name="arrivedPointId" value="${departFlyMap.arrivedPointId }">
			<input type="hidden" id="departPointCode" name="departPointCode" value="${flightList[0].airportDpt }">
			<input type="hidden" id="arrivedPointCode" name="arrivedPointCode" value="${flightList[0].airportArv }">
			<input type="hidden" id="flightId" name="flightId" value="${flightList[0].flightId}">
			<input type="hidden" id="departTime" name="departTime" value="">
			<input type="hidden" id="arrivalTime" name="arrivalTime" value="">
            <input type="hidden" id="calendar_date" name="calendar" value="${departFlyMap.minimumDate} ~ ${departFlyMap.maximumDate}">
            <input type="hidden" id="minimumDate" name="minimumDate" value="${departFlyMap.minimumDate}">
            <input type="hidden" id="maximumDate" name="maximumDate" value="${departFlyMap.maximumDate}">
           	<input type="hidden" id="person" name="passengerNumber" value="${departFlyMap.passengerNumber}">
           	<input type="hidden" id="adultNumber" name="adultNumber" value="${departFlyMap.adultNumber }">
           	<input type="hidden" id="childNumber" name="childNumber" value="${departFlyMap.childNumber }">
           	<input type="hidden" id="babyNumber" name="babyNumber" value="${departFlyMap.babyNumber }">
			<input type="hidden" name="refresh" value="0">
			
		</form>
		<div id="under_div">
			<div id="under_div_position">
				<button id="selectButton">돌아오는편 선택</button>
			</div>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
		
	<script>
		$(function() {
			console.log("출발 비행편 출발 : " + $("#d_departPointId").val());
			console.log("출발 비행편 도착 : " + $("#d_arrivedPointId").val());
			let flightIdList = [];

			$(".idList").each(function(i, e) {
				flightIdList.push($(this).text());
			});
			
			console.log('model에서 가져온 list : ' + flightIdList);
			
			//console.log('model 자료형' + $(".idList"));
			
			//console.log(flightIdList);
			//나머지 항공편을 8개씩만 출력하는 페이지버튼들을 표시 및 링크 이동
			$(".pagination a").on("click", function(e) {
				e.preventDefault();
				
				$("input[name='refresh']").val($(this).attr("href"));
				$("input[name='pageNum']").val($(this).attr("href"));
				$("#info").submit();
			});
			//비행편 선택하고 그 이후 비행편 선택 버튼을 눌러 해당 비행편 선택한 내용을 가지고 감.

			$(".columns").on("click", function(e) {
				$(".columns").css("border", "none").css("border-left", "1px solid #bebebe");
				$(this).css("border", "2px solid red");
				console.log("받아온 출발시간 데이터 : " + $(this).parent().find('.start_time').children('span').text());
				console.log("받아온 도착시간 데이터 : " + $(this).parent().find('.finish_time').children('span').text());
				 $("input[name='departTime']").val($(this).parent().find('.start_time').children('span').text());
				 $("input[name='arrivalTime']").val($(this).parent().find('.finish_time').children('span').text());
				 $("input[name='classId']").val($(this).children('.classCol').text());
				 $("input[name='flightId']").val($(this).parent().prev().text());
				 console.log("회귀 비행편 아이디 : " + $("input[name='flightId']").val());
				 console.log("회귀 비행편 클래스 : " + $("input[name='classId']").val());
				 
				 $("#selectButton").css("background-color", "#ff5000");
			});
			
			$("#selectButton").on("click", function(e) {
				if(!$("#departTime").val()) {
					alert("돌아가는 비행편을 하나 선택해주세요.");
					return;
				}
				$("#checkFlight").submit();
			});
			
		});
	</script>
	
</body>
</html>