<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
  <html lang="en">
    <head>
      <!-- 포트원 SDK 라이브러리 추가 -->
      <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	  <script src="https://code.jquery.com/jquery-latest.min.js"></script>
      <link rel="stylesheet" href="/css/wallet_css.css">
      <meta charset="UTF-8" />
      <title>Sample Payment</title>
      <meta name="_csrf_header" content="${_csrf.headerName}">
	  <meta name="_csrf" content="${_csrf.token}">
    </head>
    
    <body>
    <div class="wrap">
	<div class="button_box">
		<a href="/wallet" class="btn_1">지갑</a> 
		<a href="/Alert" class="btn_2">정보 수정</a>
		<a href="/chat" class="btn_3">고객 상담</a>
	</div>
</div>
<jsp:include page="../include/header.jsp" />

	<input type="hidden" id="mail" value="${mail}">
	<input type="hidden" id="name" value="${name}">
	<input type="hidden" id="phone" value="${phone}">
	<input type="hidden" id="addr" value="${addr}">
	<input type="hidden" id="post" value="${post}">
	
      <!-- 결제하기 버튼 생성 -->
      <button onclick="requestPay()">결제하기</button>
      
      

<script src="/js/wallet.js"></script>	
    </body>
  </html>