<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Share Square</title>
<link rel="stylesheet" type="text/css" href="../css/ShareSquare_plist.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>


</head>
<body>
		<div class="main_img"></div>

		<div class="line">
			<p>▷ Share Square ◁</p>
		</div>


		<!-- 버튼 박스 -->
		<div class="button_box">
			<a href="add_schedule.jsp" class="btn_1">New Schedule</a> <a
				href="my_trip.jsp" class="btn_2">My Trip</a> <a href="share_c.jsp"
				class="btn_3">Share Square</a>
		</div>

		<!-- 정렬 버튼 -->
		<div class="sort-box">
			<a href="WishList.jsp" class="btn_wish">Wish List</a> <a
				href="Best.jsp" class="btn-best">Best</a>
		</div>
		
		
		 <%--검색 폼추가 --%>
		      <div class="search-box">
		      <form action="ShareSquare_plist" method="get" enctype="multipart/form-data">
			  <select name="find_field">
				<option value="sboard_title"
					<c:if test="${find_field=='sboard_title'}"> ${'selected'}</c:if>>제목</option>
				<option value="sboard_writer"
					<c:if test="${find_field=='sboard_writer'}"> ${'selected'}</c:if>>작성자</option>
				</select> <input type="search"  placeholder="국가/도시/회원ID 를(을) 입력하세요" name="find_name" id="find_name" value="${find_name}" /> 
				<div class="s-button"> <input type="submit" value="검색" /> </div>
			  </form>
					
			  </div> 
		  

		
		<!-- 중심 게시물 -->
		<!-- https://ktsmemo.cafe24.com/s/SwiperJS/367  나중에 지우기ㅎㅎ-->
		 
		<div class="swiper-container">		
				 
		  <c:forEach var="s" items="${share}"> 
		   <c:if test="${!empty share}">
		    <form method="get" action="plan_share_ccont" enctype="multipart/form-data">
			
	  		  	<div class="swiper-slide">		
			  	    <ul>		
			          <li>			  			           			       	            
			          		           
						 <input type="hidden" name="no" value="${s.sboard_no}">	
								
						 <button type="submit" class="btn-src" > <img src="${s.sboard_file}" alt="국기이미지" ></button> 					             
			             <button type="submit" class="btn-src2"> <strong> Category(제목/여행지) : ${s.sboard_title} </strong> <br> 작성자 : ${s.sboard_writer} 
			             <br> 조회수 : ${s.sboard_hit} &nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(s.sboard_Regdate,0,10)} </button> 
			      		
			           <!-- <input type="hidden" name="sboard_no" value="${s.sboard_no}">이걸로 보내고 controller에서 sboard_no를 받았으니까
			           ShareSquareVO sc = this.sharesquareService.getshareSquareCont(s);이런식으로 다시 담아내서 정보를 읽어오자!!
			           value="${s.sboard_no}값을 name="sboard_no"이름으로 보내고 controller에는 sboard_no로 받는다? 확인해봐라
			           그리고 submit으로 정보를 주고 controller에서 받아야된단다 // sboard_no라는 이름으로 ${s.sboard_no}의 값을 전송 -->
		    
		 	     	  </li>
		 	     	</ul>		    
				</div>					  				
				
			   </form>
			  </c:if>
			</c:forEach>
					

		    
			  
			  	 <!-- 네비게이션 다음 버튼 (오른쪽에 있는 버튼) -->			  	 
				 <div class="swiper-button-next"></div>
				 <!--  이전 버튼 -->
				 <div class="swiper-button-prev"></div> 
				 
				 


	    </div>
	    		    
			  <!-- 페이징 즉 쪽나누기 추가  -->
			  <div id="pList_paging">
			  
			  <%-- 검색전 페이징 --%>
			  <c:if test="${(empty find_field) && (empty find_name)}">
		      <c:if test="${page<=1}">[이전]&nbsp; </c:if>
		      <c:if test="${page>1}">
		      <a href="ShareSquare_plist?page=${page-1}">[이전]</a>&nbsp;
   		      </c:if>

			  <%--현재 쪽번호 출력--%>
		      <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
		      <c:if test="${a == page}">
		      <%--현재 페이지가 선택되었다면--%>
     	      <${a}>
              </c:if>
		      <c:if test="${a != page}">
		      <%--현재 페이지가 선택되지 않았다면 --%>
		      <a href="ShareSquare_plist?page=${a}">[${a}]</a>&nbsp;
              </c:if>
	          </c:forEach>

			  <c:if test="${page >= maxpage}"> [다음] </c:if>
		      <c:if test="${page<maxpage}">
			  <a href="ShareSquare_plist?page=${page+1}">[다음]</a>
			  </c:if>
		      </c:if>
				
				
			 <%-- 검색후 페이징 --%>
			  <c:if test="${(!empty find_field) || (!empty find_name)}">
			  <c:if test="${page<=1}">[이전]&nbsp;</c:if>
			  <c:if test="${page>1}">
			  <a href="ShareSquare_plist?page=${page-1}&find_field=${find_field}&find_name=${find_name}">[이전]</a>&nbsp;
    		  </c:if>

		      <%--현재 쪽번호 출력 --%>
			  <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
			  <c:if test="${a == page}">
		      <%--현재 페이지가 선택되었다면 --%>
              <${a}>
              </c:if>
		      <c:if test="${a != page}">		      
			  <%--현재 페이지가 선택되지 않았다면 --%>
			  <a href="ShareSquare_plist?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a>&nbsp;
       		  </c:if>
			  </c:forEach>
			  <c:if test="${page >= maxpage}"> [다음] </c:if>
			  <c:if test="${page<maxpage}">
			  <a href="ShareSquare_plist?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
			  </c:if>
		      </c:if>

			</div>	  
			  
			  
		      <!-- 후기작성 버튼 -->
		      <div class="button_Write">
		       <input type="button" class="button2" value="후기작성" onclick="location='ShareSquare_Write';">  	
	          </div>
			  
			  


		
</body>
</html>

<%--일정관리 footer --%>
<jsp:include page="../include/footer.jsp" />

