<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 테그 라이브러리 추가 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<!-- 선생님 header.jsp 이미 a 태그 text-decoration: none; color:black; 적용되어 있음 -->
	body {background : #F6F6F6;}
    #container { width: 100%; display: flex; justify-content: center; position:relative;}
    #box { width: 1000px; margin: 10px auto;}
    #t_section {text-align: center;}
    .qna_title {font-size: 2rem; text-align: center; font-weight: bold;
      margin-bottom: 13px; 
    }
    #t_qna {width:100%; border-collapse: collapse;
    }
    #t_qna tr, #t_qna th{ height: 38px;}
    #t_qna thead { border-top: 2px solid black; 
      border-bottom: 1px solid lightgray;
    }
    #t_qna tbody { border-bottom: 1px solid lightgray;}
    .t_title {text-align: left;} 
    .search {
      position:relative;    
      width: 200px;
      margin-bottom: 8px;
      margin-right: 25px;
      margin-left: 400px;
      float: right;
    }
    .search input {
      width: 100%;
      height: 10px;
      border: 1px solid black;
      border-radius: 8px;
      padding: 10px 12px;
      font-size: 14px;
    }
    .search img {
      position:absolute;
      width: 20px;
      top: 7px;
      right: -10px;
      margin:0;
    }
    .pageCount {
      display: inline-block;
      width: 55%;
      text-align: right;
    }
    .pagination {
      list-style: none;
      display: inline-block;	
	  }
	  .pagination_button {
      float: left;
      margin-left: 5px;
	  }
    .pagination a {
      text-decoration: none;
      color: black;
    }
    .pagination a:hover {
      color: red;
    }
    .insert-wrap {
    	position:relative;
    	display: inline-block;
    	width: 40%;
    }
    .insert{
      width: 80px;
      height: 30px;
      border: 1px solid black;
      border-radius: 20px;
      background-color: black;
      text-align: center;
      position:absolute;
      top:-40px;
      right:-15px;
    }
    .btnInsert {
      text-decoration: none;
      color: white;
      font-size: 1.03rem;
    }
    td a {text-decoration: none; color:black;}
/*     #btnInsert{position: absolute; top:0px; bottom: 0px;} */
    
</style>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath }/header.jsp"></jsp:include>
	<div id="container">
    <div id="box" >
      <p class="qna_title">질 문 게 시 판</p>
      <form id="searchForm" action="/board/getBoardList.do" method="post">
      	<input type="hidden" name="pageNum" value="${pageVO.cri.pageNum }">
      	<input type="hidden" name="amount" value="${pageVO.cri.amount }">
        <div class="search">
          <input type="text" name="searchKeyword" value="${searchKeyword}">
          <img src="${pageContext.request.contextPath }/resources/images/search.png" style="width: 20px;">
        </div>
      </form>
      <div id="t_section">
        <table id="t_qna">
          <thead>
            <tr>
              <th width="7%">NO</th>
              <th width="60%">제목</th>
              <th width="10%">작성자</th>
              <th width="12%">작성일자</th>
              <th width="11%">조회수</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${boardList}" var="board">
            <tr>
              <td>${board.boardId}</td>
              <td class="t_title"><a href="/board/updateBoardCnt.do?boardId=${board.boardId }">${board.boardTitle }</a></td>
              <td>${board.fullName}</td>
              <td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/></td>					
              <td>${board.boardCount} </td>
            </tr>
          </c:forEach>
          </tbody>          
        </table>
      </div>
      <div>
	      <div class="pageCount">
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
	      <div class="insert-wrap">
		      <div id="insert" class="insert" >
		        <a href="/board/insertBoard.do" id="btnInsert" class="btnInsert">글쓰기</a>
		      </div>
	      </div>
      </div>
    </div> 
  </div>
  <jsp:include page="${pageContext.request.contextPath }/footer.jsp"></jsp:include>
	
  <script>
    
    //페이지 이동
    $(function(){
	 		$(".pagination a").on("click", function(e){
	 			e.preventDefault(); // a 태그의 기능을 막음
	 			/* 클릭된 value가 데이터로 들어감 */
	 			$("input[name='pageNum']").val($(this).attr("href"));
	 			$("#searchForm").submit();
	 		});
	 		
	 		/* 검색시 1page로 보내는 것  */
	 		$(".search img").on("click", function(){
	 			/* console.log(e.target); */
	 			$("input[name='pageNum']").val(1);
	 			$("#searchForm").submit();
	 		});
		});
  </script>  
</body>
</html>