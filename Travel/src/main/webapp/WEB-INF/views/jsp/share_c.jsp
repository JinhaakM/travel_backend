<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Share Square</title>
<link rel="stylesheet" type="text/css" href="../css/share_c.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

</head>

<body>
<div class="wrap">
<div class="main_img"></div>

<div class="line"> <p>▷ Share Square ◁</p> </div>

<%--일정공유 상단 --%>
  <div class="search-container">
     <form action="search_result.jsp" method="GET">
       <input type="text" name="text" placeholder="국가/도시/회원ID 를(을) 입력하세요">
       <button type="submit">검색</button>
      </form>
   </div>

<!-- 버튼 박스 -->
   <div class="button_box">
   	  <a href="add_schedule.jsp" class="btn_1">New Schedule</a>
      <a href="my_trip.jsp" class="btn_2">My Trip</a>
      <a href="share_c.jsp" class="btn_3">Share Square</a>
    </div>
   
 <!-- 정렬 버튼 -->
 	<div class="sort-box">
 	  <a href="WishList.jsp" class="btn_wish">Wish List</a>
      <a href="Best.jsp" class="btn-best">Best</a>
 	</div>
 
 <!-- 중심 게시물 -->
<!-- https://ktsmemo.cafe24.com/s/SwiperJS/367  나중에 지우기ㅎㅎ-->

<div class="swiper-container">
	<div class="swiper-wrapper">
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
		<div class="swiper-slide"><img src="../images/map.jpg" alt="대표이미지" onclick="location.href='plan_share.jsp'"> </div>
	</div>

	<!-- 네비게이션 -->
	<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
	<div class="swiper-button-prev"></div><!-- 이전 버튼 -->

	<!-- 페이징 -->
	<div class="swiper-pagination"></div>
</div>



<script src="../script/share_c.js"></script>
   </div>
</body>
</html>

 <%--일정관리 footer --%>
   <jsp:include page="../include/footer.jsp" />