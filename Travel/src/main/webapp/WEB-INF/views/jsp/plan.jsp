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
<link rel="stylesheet" type="text/css" href="../css/plan.css">
<link rel="stylesheet" type="text/css" href="../css/plancalendar.css">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
    var latitudes = ${capitalCityLatitudes};
    var longitudes = ${capitalCityLongitudes};
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var nationalCode = "${nationalCode}";
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
        <div id= "travelModal" class="t_modal">
            <div class="modal_content">
            나의 일정이 생성 되었습니다.
            </div>
            <i class="fa-solid fa-plane fa-2xl"></i>
            <div class="airlineTickets">
            <a><img id="expedia" src= "../images/expedia.png"></a>
            <a><img id="skyscanner" src="../images/Skyscanner.png"></a>
            <a><img id="kayak" src="../images/kayak.png"></a>
            <a><img id="tripcom" src="../images/tripcom.png"></a>
            </div>
            <p>항공권 예매하기</p>
            <form id="travelForm" action="/itinerary/" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" id="departureDateInput" name="departureDate">
            <input type="hidden" id="arrivalDateInput" name="arrivalDate">
            <input type="hidden" id="destinationInput" name="selectedCityCodes">
            <button type="submit" id="create_btn" class= "create_btn" data-nationalCode="${nationalCode}">일정 확인</button>
            </form>

            <button id= "closeModal" >취소</button>
        </div>
        <div id="modalBackGround" class="modal_background"></div>
        
        <div class="container">
            <ul class="tab_menu">
				<div class="tab_items">
					<li class="tab_item">
					    <a id="first_btn" class="first_btn" data-toggle="tab" role="tablist">STEP 1<br>국가 확인</a>
					</li>
					<li class="tab_item">
					    <a id="second_btn" class="second_btn" data-toggle="tab" role="tablist">STEP 2<br>날짜 선택</a>
					</li>
					<li class="tab_item">
					    <a id="third_btn" class="third_btn" data-toggle="tab" role="tablist">STEP 3<br>도시 선택</a>
					</li>
				</div>
				
				<div class="tab_items2">
                    <button id="createPlan">일정 생성</button>
                </div>
			</ul>

			
            <ul class="tab_menu2">
<div class="country_main">
    <div class="country_item">
        <div class="country_img"><img src="../../..${flagPath}" alt="${nationalName}"></div>

        <div class="country_name">&nbsp; &nbsp;${nationalName}</div>
    </div>
        <div class="country_time">시차 &nbsp;${timeDifference}</div>
</div>
                
            <div class="c_container">
                <div class="select_date"> 일정을 선택해 주세요</div>
                    <div class="calendar_container">
                    
                        <div class="calendar_header">
                            <button id="prevBtn">
                                <i class="fa-solid fa-circle-chevron-left fa-2xl"></i>
                            </button>
                        <h2 id="currentMonth"></h2>
                            <button id="nextBtn">
                                <i class="fa-solid fa-circle-chevron-right fa-2xl"></i>
                            </button>
                        </div>
                    
                        <div class="calendar_days">
                            <div class="day1">일</div>
                            <div class="day">월</div>
                            <div class="day">화</div>
                            <div class="day">수</div>
                            <div class="day">목</div>
                            <div class="day">금</div>
                            <div class="day2">토</div>
                        </div>
                    
                        <div class="calendar-dates" id="calendarDates"></div>
                        <div id="selectedDates" >
                        </div>
                    </div>
            </div>
            
                <table class="city_main">
                    <tr>
                        <th class="c_name">${nationalName}</th>
                    </tr>

                    <tr>
                        <td>
                            <ul id="city_list" class="city_list">
                            
                            <c:forEach var="C" items="${cityList}" varStatus="loop">
                            <li class="city_item_${C.cityCode}">
                                <div class="city_name">${C.cityName}</div>
                                <div class="container_c">
                                    <button id= "select_city${C.cityCode}" class="select_city" data-longitude="${C.longitude}" data-latitude="${C.latitude}" data-index="${loop.index}" data-cityCode="${C.cityCode}" data-cityName="${C.cityName}">+</button>
                                </div>
			                </li>
			                </c:forEach>
			                </ul>
			            </td>
                    </tr>
                    <tr>
                    <td>
                        <input type="text" id="placeSearch" placeholder="장소 검색" />
                    </td>
                    </tr>
                </table>
            </ul>
        </div>
		    <div id="map"></div>
	</div>
	
	<%-- 외부 javascript 파일 연결 --%>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQ4RyCuYJe7JbBpsNsi3_CUlpNlsKxOe8&libraries=places"></script>
    
	<script 
	    src="https://kit.fontawesome.com/9d75e77952.js"crossorigin="anonymous">
	</script>
	<script src="../js/planDestination.js"></script>
	<script src="../js/plancalendar.js"></script>
</body>
</html>