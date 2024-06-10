<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오직 로그아웃을 성공적으로 시켜서 시큐리티로 전송하기 위한 목적의 jsp</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<form id="logoutForm" action="logout_ok" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<br> 	
					<input type="submit" value="Logout"> 
				</form>
				
<script type="text/javascript">
$(document).ready(function(){
	$("#logoutForm").submit(); // 즉시 전송
});
</script>
</body>
</html>