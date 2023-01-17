<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>୧(๑•̀ᗝ•́)૭</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<style>
    body { background-color : #F6F6F6;}
    /* 전체 컨테이너 */
	#container{ width: 100%; display: inline-block; text-align: center;}
	
	#r_arrow { width : 10px; height : 15px; margin-right : 15px; margin-left : 15px;}
	#p_location { width : 100%; height : 50px; text-align : center; font-weight : bold; color:#848484; background-color :#d2d2d2;
	  margin-top : 15px; margin-bottom : 15px; font-size : 1.1em; border-top : 2px solid orange; border-bottom : 2px solid orange;
	}
	
    /* 페이지 제목 */
    #page_name{ width: 1000px; display: inline-block; font-family: 'Jua'; font-size: xx-large; 
        text-align: left; margin-top: 20px;}
    /* 내용부분 전체 */
    #info_div{ width: 1000px; display: inline-block;}
    /* 항공기 정보 */
    #f_info{ width: 1000px; height: 300px; border: 1px solid black; border-radius: 3px; margin-bottom: 30px;}
    #personnal{ font-family: "Jua"; text-align: left;}
    #person_img{width: 20px; height: 20px;}
    #f_info{ text-align: left; position: relative;}
    #f_info_img{position: relative;}
    #f_info p{ font-family: "Jua";}
    #airplane{width: 150px; height: 150px; position: absolute; top: 75px; left: 75px;}
    #arrow{ width: 75px; height: 75px; position: absolute; top: 105px; left: 290px;}
    #arrow_text1{ position: absolute; top:70px; left: 290px;}
    #arrow_text2{ position: absolute; top:160px; left: 320px;}
    #f_info_con{ width: 560px; height: 150px; position: absolute;
        top: 50px; right: 0; font-family: 'Jua'; font-size: large;}
    /* 정보 받아올 항목 */
    #f_info_con_up{ width: 100%; height: 50%;  position: relative;}
    #f_info_con_down{ width: 100%; height: 50%; position: relative; margin-top: 50px;}

    #from_eng{ position: absolute; top:0px; left: 0px;}
    #from_kor{ position: absolute; top:0px; left: 40px;}
    #from_arrow{ position: absolute; top:-5px; left: 170px;}
    #to_eng{ position: absolute; top:0px; left: 230px;}
    #to_kor{ position: absolute; top:0px; left: 270px;}
    #from_date{ position: absolute; top:40px; left: 0px;}
    #from_time{ position: absolute; top:36px; left: 130px;}
    #plain_name{ position: absolute; top:40px; left: 290px;}
    #seat_lv{ position: absolute; top:40px; left: 400px;}

    #from_eng2{ position: absolute; top:0px; left: 0px;}
    #from_kor2{ position: absolute; top:0px; left: 40px;}
    #from_arrow2{ position: absolute; top:-5px; left: 170px;}
    #to_eng2{ position: absolute; top:0px; left: 230px;}
    #to_kor2{ position: absolute; top:0px; left: 270px;}
    #from_date2{ position: absolute; top:40px; left: 0px;}
    #from_time2{ position: absolute; top:36px; left: 130px;}
    #plain_name2{ position: absolute; top:40px; left: 290px;}
    #seat_lv2{ position: absolute; top:40px; left: 400px;}

    #personnal_data{width: 1000px; display: inline-block; }
    .person_data p{font-family: "Jua"; text-align: left; font-size: larger;}
    .person_data input[type=text]{ width: 350px; height: 50px; border: none; border-bottom: 1px solid black;
         background: none; font-size: larger; outline: none;}
    .person_data input[type=button]{ width: 170px; height: 40px;}
    
    .person_data{ width: 1000px; height: 370px; margin-bottom: 30px; background-color: #dcdcdc; position: relative;}
    .name_f_p{ position: absolute; top: 20px; left: 50px;}
    .name_f{ position: absolute; top: 60px; left: 50px;}
    .name_p{ position: absolute; top: 20px; left: 550px;}
    .name{ position: absolute; top: 60px; left: 550px;}
    .ph_p{ position: absolute; top: 130px; left: 50px;}
    .ph{ position: absolute; top: 170px; left: 50px;}
    .birthday_p{ position: absolute; top: 130px; left: 550px;}
    .birthday{ position: absolute; top: 170px; left: 550px;}
    .gender_p{ position: absolute; top: 240px; left: 50px; }
    .male{ position: absolute; top: 290px; left: 50px; border: none; font-family: 'Jua';}
    .female{ position: absolute; top: 290px; left: 230px; border: none; font-family: 'Jua';}
    #btn_submit{ width: 350px; height: 40px; position: absolute; top: 290px; left: 550px;
        background-color: #ff5000; border: none; border-radius: 3px; color: white;
         font-family: 'Jua'; font-size: larger;} 

</style>
<script>
	$(document).ready(function(){
        let personnal_data = "<form action='/passenger/insertPassenger.do' method='post'>";
        let personnal_num = (Number)($("#personnal_num").html());
        
       	let fwd_depart_datetime = "${flight_data.minimumDate} ${flight_data.d_departTime}:00";
       	let fwd_arrival_datetime = "${flight_data.minimumDate} ${flight_data.d_arrivalTime}:00";
       	let bwd_depart_datetime = "${flight_data.maximumDate} ${flight_data.departTime}:00";
       	let bwd_arrival_datetime = "${flight_data.maximumDate} ${flight_data.arrivalTime}:00";
       	
       	console.log(fwd_depart_datetime);
       	console.log(fwd_arrival_datetime);
       	console.log(bwd_depart_datetime);
       	console.log(bwd_arrival_datetime);
       
        for(let i = 1; i <= personnal_num; i++){
        	 personnal_data += "<div class='person_data'>";
             personnal_data += "<p class='name_f_p'>성(영문)</p><input type='text' name='firstName" + i + "' class='name_f'>"
             personnal_data += "<p class='name_p'>이름(영문)</p><input type='text' name='lastName" + i + "' class='name'>"
             personnal_data += "<p class='ph_p'>연락처</p><input type='text' name='phone" + i + "' class='ph'>"
             personnal_data += "<p class='birthday_p'>생년월일(YYYY-MM-DD)</p><input type='text' name='birthDate" + i + "' class='birthday'>"
             personnal_data += "<p class='gender_p'>성별</p><input type='button' id='male" + i + "' class='male' value='남성'> <input type='button' id='female" + i + "' class='female' value='여성'> "
             personnal_data += "<input type='hidden' id='gender" + i + "' name='gender" + i + "' value='남성'>"
        
            if(i == personnal_num){
                personnal_data += "<input type='hidden' name='fwd_flight_id' value='${flight_data.d_flightId }'>"
                personnal_data += "<input type='hidden' name='fwd_seat_id' value='${flight_data.d_classId  }'>"
                personnal_data += "<input type='hidden' name='fwd_departTime' value='${flight_data.d_departTime }'>"
                personnal_data += "<input type='hidden' name='fwd_arrivalTime' value='${flight_data.d_arrivalTime }'>"
                personnal_data += "<input type='hidden' name='fwd_date' value='${flight_data.minimumDate }'>"
                personnal_data += "<input type='hidden' name='fwd_depart_airportName' value='${d_departPointCode.airportName }'>"
                personnal_data += "<input type='hidden' name='fwd_depart_airportCode' value='${d_departPointCode.airportCode }'>"
                personnal_data += "<input type='hidden' name='fwd_arrived_airportName' value='${d_arrivedPointCode.airportName }'>"
                personnal_data += "<input type='hidden' name='fwd_arrived_airportCode' value='${d_arrivedPointCode.airportCode }'>"
                personnal_data += "<input type='hidden' name='fwd_depart_datetime' value='" + fwd_depart_datetime + "'>"
                personnal_data += "<input type='hidden' name='fwd_arrival_datetime' value='" + fwd_arrival_datetime + "'>"
                
                personnal_data += "<input type='hidden' name='bwd_flight_id' value='${flight_data.flightId }'>"
                personnal_data += "<input type='hidden' name='bwd_seat_id' value='${flight_data.classId  }'>"
                personnal_data += "<input type='hidden' name='bwd_departTime' value='${flight_data.departTime }'>"
                personnal_data += "<input type='hidden' name='bwd_arrivalTime' value='${flight_data.arrivalTime }'>"
                personnal_data += "<input type='hidden' name='bwd_date' value='${flight_data.maximumDate }'>"
                personnal_data += "<input type='hidden' name='bwd_depart_airportName' value='${departPointCode.airportName }'>"
                personnal_data += "<input type='hidden' name='bwd_depart_airportCode' value='${departPointCode.airportCode }'>"
                personnal_data += "<input type='hidden' name='bwd_arrived_airportName' value='${arrivedPointCode.airportName }'>"
                personnal_data += "<input type='hidden' name='bwd_arrived_airportCode' value='${arrivedPointCode.airportCode }'>"
                personnal_data += "<input type='hidden' name='bwd_depart_datetime' value='" + bwd_depart_datetime + "'>"
                personnal_data += "<input type='hidden' name='bwd_arrival_datetime' value='" + bwd_arrival_datetime + "'>"
                
                
                
            	
                personnal_data += "<input type='submit' id='btn_submit' value='입력하기'>"
                personnal_data += "</form></div>"
            }
            else{
                personnal_data += "</div>"
            }
        }
       	console.log($("#asdf").val());
        
        $("#personnal_data").html(personnal_data);

        for(let i = 1; i <= personnal_num; i++){
            $("#male" + i).click(function(e){
                $("#gender" + i).val("남성");
                $("#male" + i).css("border", "1px solid #ff5000");
                $("#female" + i).css("border", "none");
            })

            $("#female" + i).click(function(e){
                $("#gender" + i).val("여성");
                $("#male" + i).css("border", "none");
                $("#female" + i).css("border", "1px solid #ff5000");
            })
        }
	})
</script>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
	<div id="container">
		<div id="p_location">
			<div style="display: inline-block;text-align:left; width:1070px; margin-top : 14px;">
			<span>홈<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">항공권 예매<img id="r_arrow" src="${pageContext.request.contextPath}/resources/images/r_arrow.png">탑승자정보입력</span>
		</div>
		</div>
        <div id="page_name">탑승자 정보 입력</div>
        <br><br>

        <div id="info_div">
            <div id="personnal"><img id="person_img" src="${pageContext.request.contextPath}/resources/images/person.png"> 성인 <a id="personnal_num">1</a>명</div>
            <div id="f_info">
                <div id="f_info_img">
                    <p id="arrow_text1">가는편</p>
                    <img id="airplane" src="${pageContext.request.contextPath}/resources/images/airplane.png">
                    <img id="arrow" src="${pageContext.request.contextPath}/resources/images/arrow_double.png">
                    <p id="arrow_text2">오는편</p>
                </div>
                <div id="f_info_con">
                    <div id="f_info_con_up">
                        <div id="from_eng">${d_departPointCode.airportCode }</div>
                        <div id="from_kor">${d_departPointCode.airportName }</div>
                        <div id="from_arrow">▶</div>
                        <div id="to_eng">${d_arrivedPointCode.airportCode }</div>
                        <div id="to_kor">${d_arrivedPointCode.airportName }</div>
                        <div id="from_date">${flight_data.minimumDate }</div>
                        <div id="from_time">${flight_data.d_departTime } ~ ${flight_data.d_arrivalTime }</div>
                        <div id="plain_name">7C145</div>
                        <div id="seat_lv">일반석</div>
                    </div>
                    <div id="f_info_con_down">
                        <div id="from_eng2">${departPointCode.airportCode }</div>
                        <div id="from_kor2">${departPointCode.airportName }</div>
                        <div id="from_arrow2">▶</div>
                        <div id="to_eng2">${arrivedPointCode.airportCode }</div>
                        <div id="to_kor2">${arrivedPointCode.airportName }</div>
                        <div id="from_date2">${flight_data.maximumDate }</div>
                        <div id="from_time2">${flight_data.departTime } ~ ${flight_data.arrivalTime }</div>
                        <div id="plain_name2">7C116</div>
                        <div id="seat_lv2">일반석</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="personnal_data">
           
        </div>

	</div>
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
