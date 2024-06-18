<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Trip</title>
<link rel="stylesheet" type="text/css" href="../css/my_trip.css">
<link rel="stylesheet" type="text/css" href="../css/planPost.css">
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
    integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

	<%-- 버튼 박스 --%>
	<div class="button_box">
		<a id="btn_1">New Schedule</a>
		<a id="btn_2">My Trip</a>
		<a id="btn_3">Wish List</a>
		<a id="btn_4">Share square</a>
	</div>
	<button id="btn_shcedule" type="button">
		<i class="fa-solid fa-calendar-plus fa-2x"></i>
	</button>
	<p id="my_trip_p">My Trip</p>
	<%-- 게시글 영역 --%>
	<div class="posts">
		<div class="post" id="post1">
			<img src="" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post2">
			<img src="../images/thumbnail2.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post3">
			<img src="../images/thumbnail3.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post4">
			<img src="../images/thumbnail4.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>
		<div class="post" id="post5">
			<img src="../images/thumbnail5.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post6">
			<img src="../images/thumbnail6.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post7">
			<img src="../images/thumbnail7.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

		<div class="post" id="post8">
			<img src="../images/thumbnail8.jpg" alt="게시글 썸네일" class="thumbnail">
		</div>

	</div>

<jsp:include page="../include/footer.jsp"/>

<%-- 외부 javascript 파일 연결 --%>


<script src="../js/posts.js"></script>
<script src="../js/mytrip.js"></script>
<script src="https://kit.fontawesome.com/9d75e77952.js"crossorigin="anonymous"></script>