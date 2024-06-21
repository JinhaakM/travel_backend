<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<div class="button_box">
    <a id="btn_1">New Schedule</a>
    <a id="btn_2">My Trip</a>
    <a id="btn_3">Wish List</a>
    <a id="btn_4">Share square</a>
</div>
<p id="my_trip_p">My Trip</p>

<div class="posts" id="postsContainer">
    <c:forEach var="plan" items="${planList}" varStatus="loop">
        <div class="post">
            <div id="cityList-${plan.planNo}" class="city-list">
                <c:forEach var="nationalName" items="${nationalsByPlan[loop.index]}">
                    <div class="cityImage">
                        <img src="${firstCityImages[loop.index]}" alt="${nationalNameList} 첫 번째 도시 이미지">
                    </div>
                    <div class="nationalName">
                        ${nationalName}
                    </div>
                </c:forEach>     
                <div class="cityNames">
                    <c:forEach var="city" items="${plan.cities}">
                        <div data-city-code="${city.cityCode}">
                            ${city.cityName}
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="dates">
                <p><fmt:formatDate value="${plan.departureDate}" pattern="yyyy-MM-dd" />~<fmt:formatDate value="${plan.arrivalDate}" pattern="yyyy-MM-dd" /></p>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="../include/footer.jsp"/>

<script src="../js/mytrip.js"></script>
<script src="https://kit.fontawesome.com/9d75e77952.js" crossorigin="anonymous"></script>