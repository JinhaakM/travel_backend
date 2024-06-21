<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
	integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Reddit+Mono:wght@200..900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/itinerary.css">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script>
    var cities= [
    	<c:forEach items="${cities}" var="city" varStatus= "loop">{
    		cityName: "${city.cityName}",
    		latitude: ${city.latitude},
    		longitude: ${city.longitude}
    	}<c:if test="${not loop.last}">,</c:if>
    	</c:forEach>
    	];
    console.log(latitude);
</script>

</head>
<body>

<nav class="navlogo">
<div id="logoid">
    <img id="logo"
	src="../images/main_logo.png" alt="HTML Logo">
</div>
</nav>
    <div class="wrapper">
        
        <div class="container">
            <div class="tab_menu">
				<div class="tab_items">
					<div class="tab_item">
					    <a id="first_btn" class="first_btn" data-toggle="tab" role="tablist">전체 일정</a>
					</div>
				</div>
				
				<div class="tab_items2">
                    <button id="myPlan">나의 일정</button>
                </div>
			</div>

			
            <div class="tab_menu2">
                <div class= "totalPlan" id= "totalPlan">
                    <p>${departureDate} - ${arrivalDate}</p>
                </div>
                <div class="totalCity" id= "totalCity">
                    <div>
                    <c:forEach var="city" items="${cities}" varStatus= "loop">
                        <div class="planNational" id= "planNational">
                        <img src="../../..${flagPath}" alt="${nationalName}">
                        <div>${nationalName}</div>
                        </div>
                            <div class="planCityName" id="planCityName">${city.cityName}</div>

                    </c:forEach>
                    </div>                
                </div>
            </div>
        </div>
		    <div id="map"></div>
	</div>
	
	<%-- 외부 javascript 파일 연결 --%>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQ4RyCuYJe7JbBpsNsi3_CUlpNlsKxOe8&libraries=places"></script>
    
	<script 
	    src="https://kit.fontawesome.com/9d75e77952.js"crossorigin="anonymous">
	</script>
	<script src="../js/itinerary.js"></script>
</body>
</html>