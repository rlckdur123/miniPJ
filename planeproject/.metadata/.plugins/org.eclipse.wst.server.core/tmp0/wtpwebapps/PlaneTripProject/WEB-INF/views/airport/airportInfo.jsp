<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {background-color : #F6F6F6; }
    #container { width: 100%; display: flex; justify-content: center;}
    #box01 {width: 1100px; margin-top:20px;}
    .a_title { font-size: 1.8rem; font-weight: bold; margin-bottom: 0px;}
    .a_text {font-size: 0.9rem;}
    #img {width: 100%;}
    .a_info{ font-size: 1.5rem; font-weight: bold;}
    #box02 {width: 93%; border: 2px solid lightgray; padding: 20px 10px 35px 50px; margin-bottom: 50px;}
    .a_select {font-weight: bold; color: gray;}
    select { width: 700px; height: 80px; font-size: 1.1rem;}
    select option { font-size: 1.1rem;}
    #btnSelect {width: 100px; height: 40px;  margin-top: 30px;
      border: 1px solid #FF8C00;     background-color:#FF8C00; color:white; font-size: 1.1rem; 
      font-weight: bold;
      }
    #box04 {width: 93%; background: white;
    border: 2px solid lightgray; padding: 20px 10px 20px 50px;
    margin-bottom: 30px; 
    }
    #t_airportInfo{
      width: 100%;
      margin-top: 10px; 
      margin-bottom: 10px;
      border-top: 1px solid lightgray;
    }
    #t_airportInfo th, #t_airportInfo td{
      height: 80px;
      border-bottom: 1px solid lightgray;
    }
    #t_airportInfo th {
      font-size: 1.3rem;
      font-weight: nomal;
    }
    #t_title{
      font-size: 1.9rem;
      font-weight: bold;
      text-align: center;
    }
   	.t_data{
      font-size: 1.3rem;
      text-align: left;
    }
</style>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div id="container">
		<div id="box01">
		  <p class="a_title">취항지 공항 정보</p>
		  <p class="a_text">가시는 곳 공항 정보가 궁금할 때, 공항 이름을 선택하여 [조회]를 누르시면 상세정보를 확인할 수 있습니다. </p>
		  <img src="${pageContext.request.contextPath }/resources/images/airportInfo.png" id="img">
		  <p class="a_info">취항지 선택</p>
		  <div id="box02">
		    <p class="a_select">취항지 공항선택</p>
		    <form id="airportInfoForm" action="/airport/airportInfo.do" method="post">
		      <div id="box03">          
		        <select id="airportSelect"> 
		        <c:forEach items="${airportList }" var="airport" varStatus="status">
		        	<c:if test="status.last">
		        		<input type="hidden" id="selectedAirportId" name="selectedAirportId" value="${airport.selectedAirportId }">
		        	</c:if>
		          <option value="${airport.airportId }"
		          	<c:if test="${airport.selectedAirportId ne 0 && airport.selectedAirportId eq airport.airportId}">
		          		 selected="selected"
		          	</c:if>
		          >${airport.airportName }</option>
		          
		          </c:forEach>
		        </select>
		      </div>
		      <div>
		        <button type="button" id="btnSelect">조회</button>
		      </div>        
		    </form>
		  </div>
		  <div id="box04" style="display:none;">
		    <table id="t_airportInfo">
		      <thead>
		        <tr>
		          <td colspan="2" id="t_title">공&emsp;항&emsp;정&emsp;보</td>
		        </tr>
		      </thead>
		      <tbody>
		        <tr>
		          <th>공항이름</th>
		          <td class="t_data" id="airportName"></td>
		        </tr>
		        <tr>
		          <th>공항주소</th>
		          <td class="t_data" id="airportHomepage"></td>
		        </tr>
		        <tr>
		          <th>대표 전화번호</th>
		          <td class="t_data" id="airportTel"></td>
		        </tr>
		        <tr>
		          <th>요일별 운영시간</th>
		          <td class="t_data" id="airportHours"></td>
		          </tr>
		        </tbody>         
		      </table>
		   </div>
		 </div>
	</div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	
	<script>
	$(function(){
		const selectedAirportId = $("#selectedAirportId").val();
		
		if(selectedAirportId == 0 || selectedAirportId ==null || selectedAirportId == '') {
			$("#airportSelect").val("1").prop("selected", true);
		}
		
		$("#btnSelect").on("click", function(){
			const airportId = $("option:selected").val();
			
			$.ajax({
				url: "/airport/airportInfo.do",
				type: "post",
				data: {
					airportId: airportId
				},
				success: function(obj) {
					$("#box04").show();
					
					const data = JSON.parse(obj);
					console.log(data);
					$("#airportName").text(data.airportInfo.airportName);
					$("#airportHomepage").text(data.airportInfo.airportHomepage);
					$("#airportTel").text(data.airportInfo.airportTel);
					$("#airportHours").text(data.airportInfo.airportHours);
				},
				error: function(e) {
					console.log(e);
				}
			})
		});
	})
	</script>
</body>
</html>