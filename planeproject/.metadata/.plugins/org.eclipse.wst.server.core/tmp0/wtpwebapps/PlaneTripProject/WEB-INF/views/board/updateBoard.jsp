<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {background-color : #F6F6F6;}
    #container { width: 100%; display: flex; justify-content: center;}
    #box { width: 900px;}
    #t_section {text-align: center;}
    .qna_title {font-size: 2rem; text-align: center; font-weight: bold;
      margin-bottom: 13px; 
    }
    #t_qna {width:100%; border-collapse: collapse;
      border-top: 2px solid black;
      border-bottom: 2px solid black;
    }
    #t_qna th {
      height: 40px;
      text-align: center;
      border-bottom: 1px solid lightgray;
    }
    #t_qna td{
      text-align: left;
      border-bottom: 1px solid lightgray;
    }
    #boardContent {
     	width:150px;
    	height: 60px;
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
	#btnWrap{
      width: 80px;
      height: 30px;
      border: 1px solid #FF8200;
      border-radius: 20px;
      background-color: #FF8200;
      text-align: center;
      float: right;
      margin-top: 9px;
      margin-right: 5px;
      margin-bottom: 10px;
    }
     #btnUpdate {
       background-color: #FF8200;
       border: 1px solid #FF8200;
       color: white; font-size: 0.8rem;
    } 
    .btns a {
      text-decoration: none;
      color: #ffffff; font-size: 0.8rem;
    }
</style>
</head>
<body>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div id="container">
	  <div id="box" >	    
	    <p class="qna_title">게시글 내용수정</p>
	    <div id="t_section">
	      <form action="/board/updateBoard.do" method="post"> 
	     	<input type="hidden" name="pageNum" value="${pageVO.cri.pageNum }">
	    	<input type="hidden" name="amount" value="${pageVO.cri.amount }">
	        <input type="hidden" name="boardId" id="boardId" value="${board.boardId }">
	          <table id="t_qna">
	            <tr>
	              <th>글번호</th>
	              <td>${board.boardId }</td>
	            </tr>
	            <tr>
	              <th>작성자</th>
	              <td>${board.fullName}</td>
	            </tr>
	            <tr>
	              <th>작성일자</th>
	              <td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/></td>
	            </tr>
	            <tr>
	              <th>제목</th>
	              <td>${board.boardTitle}</td>
	            </tr>
	            <tr>
	              <th>내용</th>
	              <td><textarea name="boardContent" id="boardContent" rows="10" style="resize:none; width: 98%;">${board.boardContent}</textarea></td>
	             <%--  <td><input type="text" value="${board.boardContent }" name="boardContent" id="boardContent"></td> --%>
	            </tr>
	          </table>
	          <div id="btnWrap"><button type="submit" id="btnUpdate">수정</button></div>
	      </form>
	      <div class="btns" id="btnCancelWrap" ><a href="/board/getBoard.do?boardId=${board.boardId }" id="btnCancel" class="btnCancel" >취소</a></div>
	      <div class="btns" ><a href= "/board/getBoardList.do" id="btnList" class="btnList">글목록</a></div>
	    </div>
	  </div> 
	</div>	

	<jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	
	<script>
		$(function(){
			const boardContent = '${board.boardContent}';
			
			console.log(boardContent);
			// 세션, 리퀘스트 스코프에 담겨진 데이터를 빼오는 방식
			const loginUserId = '${loginUser.userId}';
			const boardWriter = '${board.userId}';
			
			console.log(loginUserId);
			console.log(boardWriter);
			
			// 게시글 작성자랑 로그인 유저가 다르면 게시글 수정 못하게 설정 
			if(loginUserId !== boardWriter){
				$("#btnWrap").hide();
				$("#btnCancelWrap").hide();
				$("#boardTitle").attr("readonly", true); 
				$("#boardContent").attr("readonly", true);		
			}
		})
	</script>
</body>
</html>