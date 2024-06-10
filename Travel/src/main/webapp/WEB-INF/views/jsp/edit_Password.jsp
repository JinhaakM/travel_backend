<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/alert_css.css">
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<%--아작스로 토큰을 보내기 위해서 해놓는 초기 설정 > 이후에 아작스에서 값을 받아 보내줘야 한다. --%>
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}">
</head>
<body>
<jsp:include page="../include/header.jsp" />
<div class="wrap">
	<div class="button_box">
		<a href="wallet" class="btn_1">지갑</a> 
		<a href="/Alert" class="btn_2">정보 수정</a>
		<a href="/chat" class="btn_3">고객 상담</a>
	</div>
	
<!-- 내 정보를 홈페이지 중앙에 띄우는 jsp -->
<div id="Join_wrap">
		<h2 class="Join_title">비밀번호 변경하기</h2> 
		<div id="error-container" style="color:red; font-size:15px; position:fixed; right:35%;"></div>
		
		<form name="m" method="post" action="Alert_All"  onsubmit="return join_check();">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table id="Join_t">
				<tr>
					<th>기존 비밀번호</th>
					<td><input type="password" name="member_pwd" id="member_pwd" size="10" ></td>
				</tr>
				
				<tr>
					<th>새로운 비밀번호</th>
					<td><input type="password" name="new_pwd" id="new_pwd" size="10" ></td>
				</tr>
				
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="new_pwd2" id="new_pwd2" size="10" ></td>
				</tr>

				
			</table>
			<div id="Join_menu">
				 
				<input type="submit" value="변경" name="alert_A">
				
			</div>
		</form>
	</div>		
	
	
	
	</div>	
<jsp:include page="../include/footer.jsp" />
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/Join_Zip.js"></script>
<script src="../../js/edit_Password.js"></script>	
</body>
</html>
