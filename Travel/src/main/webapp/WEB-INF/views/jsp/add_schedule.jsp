<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="../css/schedule.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
	integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<p id="schedule_p">Schedule</p>
		<%-- 버튼 박스 --%>
		<div class="button_box">
			<a id="btn_1">New Schedule</a>
			<a id="btn_2">My Trip</a>
			<a id="btn_3">Wish List</a>
			<a id="btn_4">Share square</a>
		</div>
		<div class="container2">
			<%-- 검색창 --%>
			<div class="search_container">
				<input class="search_input" type="text" placeholder="어디로 여행을 떠나시나요?" />
				<button id= "search_btn" class="search_button" type="button" >
					<i class="fa-solid fa-plane fa-2x"></i>
				</button>
			</div>
			<button id= "btn_plan" class="btn_plan">
				<i class="fa-solid fa-plane-departure fa-2x fa-pull-right"></i> <span
					class="plan_span">NEW</span>
			</button>

			<ul id= "list" class="list">
			   <c:forEach var="N" items="${Nlist}" varStatus="loop">
			   <li>
			       <button class="btn_1" data-index="${loop.index}" data-n_code="${N.n_code}">${N.n_name}</button>
			   </li>
			   </c:forEach>
			</ul>
		</div>

<jsp:include page="../include/footer.jsp" />


<%-- 외부 javascript 파일 연결 --%>
<script src="../js/schedule.js"></script>
<script src="https://kit.fontawesome.com/9d75e77952.js"crossorigin="anonymous"></script>