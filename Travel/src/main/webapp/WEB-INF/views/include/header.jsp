<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/header_css.css">

	<nav class="navbar">
	  <a href="homepage" class="logo-link">
            <img src="../images/main_logo.png" alt="HTML Logo">
        </a>
            <li><a href="/addschedule">여행 계획</a></li>
            <li><a href="/ShareSquare_plist">여행 후기</a></li>       
            <li><a href="/community_board">커뮤니티</a></li>
            <li><a href="/Alert">내 정보</a></li>
            
    <c:if test="${empty id}">         
		<div class="login-button">
		<a href="/login" onclick="#" style="text-decoration: none; color: pink;">로그인</a>
		</div>
    	</nav>
    	<hr>
    </c:if>
     
    <c:if test="${!empty id}">       
		<div class="login-button">
		<a href="/logout" onclick="#" style="text-decoration: none; color: pink;">로그아웃</a>
		</div>
    	</nav>
    	<hr>
    </c:if>