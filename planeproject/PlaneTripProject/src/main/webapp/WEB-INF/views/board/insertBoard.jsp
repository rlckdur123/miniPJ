<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {background-color : #F6F6F6;}
	#container { width: 100%; display: flex; justify-content: center;
	 margin-top: 70px;
     margin-bottom: 150px;
    }
    #box { width: 900px;}
    .qna_title {font-size: 2rem; text-align: center; font-weight: bold;
      margin-bottom: 13px; 
    }
    #t_qna {width:100%; border-collapse: collapse;
      border-top: 2px solid black;
      border-bottom: 2px solid black;
    }
    #t_qna th {
      width: 30%;
      height: 40px;
      border-bottom: 1px solid lightgray;
      padding: 7px;
    }
    #t_qna td{
      border-bottom: 1px solid lightgray;
      text-align: left;
    }
    #t_qna input {
      width:500px;
      height: 30px;
    }
    #t_qna textarea{
      margin: 7px 0px;
    }
    .btns {
      width: 80px;
      height: 30px;
      border: 1px solid black;
      border-radius: 20px;
      background-color: black;
      text-align: center;
      float: right;
      margin-top: 10px;
      margin-right: 5px;
      margin-bottom: 10px;

    }
    #btnReset, #btnInsert {
       background-color: black;
       border: 1px solid black;
       color: white; font-size: 1.03rem;
    }
    .btns a {
      text-decoration: none;
       color: white; font-size: 1.03rem;     
    }  
</style>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div id="container">
		<div id="box">
		  <p class="qna_title">문의사항</p>
		  <form id="insertForm" action="/board/insertBoard.do" method="post">
			<input type="hidden" name="userId" id="userId" value="${loginUser.userId}">
		    <table id="t_qna">
		      <tr>
		        <th>제목</th>
		        <td>
		          <input type="text" name="boardTitle">
		        </td>
		      </tr>
		      <tr>
		        <th>작성자</th>
		        <td>
		          <input type="text" name="boardWriter" value="${loginUser.fullName }" readonly>
		        </td>
		      </tr>
		      <tr>
		        <th>내용</th>
		        <td>
		          <textarea name="boardContent" cols="100" rows="10"></textarea>
		        </td>
		      </tr>
		    </table>
		    <div class="btns"><button type="submit" id="btnInsert">등록</button></div>
		    <div class="btns"><button type="reset" id="btnReset">취소</button></div>
		  </form>
		  <div class="btns" ><a href= "/board/getBoardList.do" id="btnList" class="btnList" style="font-size: 1.02rem;">글목록</a></div>  
		</div>
	 </div>
	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
</body>
</html>