<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://code.jquery.com/jquery-latest.min.js"></script>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<title>plan_share</title>
<link rel="stylesheet" type="text/css" href="../css/plan_share_cont.css">

</head>
<body>

<!-- 좋아요 하트 -->
  <div class="ttt"> 
   <h1>제목 : ${ssc.sboard_title} <br> </h1>
   <h4>작성자 : ${ssc.sboard_writer} &emsp;&emsp;&emsp; 조회수 : ${ssc.sboard_hit} </h4>
     <div id="btn-like">   
      <i class="like bi bi-heart"></i>    
     </div>
  </div>

	<!-- 본문(후기공유)내용 -->
	<div id="aMain_cont">
	  <div id="aBc_wrap">
	    <h2 class="aBc_title">  -  후기 공유 내용 ${sboard_no} - <br>
		  <table id="aBs_t">		   
			<tr> 
			 <th> <br>후기내용</th>  <td>${s_content}</td>
			</tr>
			<tr>
			 <th>첨부파일</th>  <td>${ssc.sboard_file}</td>
			</tr>   
		  </table>
		</h2>   
	  </div>
	</div>


	<!-- 댓글 작성 --> 
	<div class="reply">
  	 <br>  	 
   	    <div class="reply_cont">
  	      <br>  	    
  	      <input type="hidden" name="sboard_no" value="${sboard_no}" id="sboard_no">	
  	      댓글 작성자 : <input type="text" name="sreplyer" id="sreplyer" > 
   		  <br>
   		  댓글 내용 : <br><br> <textarea rows="8" cols="50" name="replytext" id="newReplyText"></textarea>
   		  <button id="sreplyAddBtn" >댓글 등록</button>    		 
   	      <hr>
   	      
   	  <!-- 댓글 목록 -->	
   	  <ul id="replies"></ul>
   	   <div class="reply_ok">
	 	<c:forEach var="r" items="${srvo}">
	     <c:if test="${!empty srvo}">
	       
	        <br> ${r.sreplyer} : ${r.replytext} 
	        <br> ${r.regdate}
	       	<br> ${sboard_no}
	       
	       	</c:if>
	       </c:forEach>	  
	 	 </div> 
  		</div> 
   	   </div>

  
 	<div class="btn-list">
      <input type="button" class="button-b" value="후기목록" onclick="location='ShareSquare_plist';"> 
	</div>


<%-- 외부 javascript 파일 연결 --%>
<script src="../js/plan_share_cont.js"></script>
<script src="../js/heart.js"></script>


</body>
</html>

 <%--일정관리 footer --%>
   <jsp:include page="../include/footer.jsp" />
  