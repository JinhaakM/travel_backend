<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/homepage_css.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css"
	integrity="sha512-10/jx2EXwxxWqCLX/hHth/vu2KY3jCF70dCQB8TSgNjbCVAC/8vai53GfMDrO2Emgwccf2pJqxct9ehpzG+MTw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Reddit+Mono:wght@200..900&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/homepageMap.css">
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}">
</head>

<body>
<jsp:include page="../include/header.jsp" />
<div>현재 서울 여행객 ${seoulGo}</div> <div id="seoul"></div>
<div>현재 부산 여행객 ${busanGo}</div> 
<div>현재 도쿄 여행객 ${tokyoGo}</div>
<div id="map"></div>


<!--이곳은 시크릿 키 자리-->
<script src="https://maps.googleapis.com/maps/api/js?key=&libraries=places"></script>
	<script 
	    src="https://kit.fontawesome.com/9d75e77952.js"crossorigin="anonymous">
	</script>
	<script src="../js/homepageMap.js"></script>
	<script src="/js/searchResult.js"></script>	
</body>
</html>