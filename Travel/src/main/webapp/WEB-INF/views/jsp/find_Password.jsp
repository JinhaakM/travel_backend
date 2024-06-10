<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url('../images/4.jpg');
}
</style>
</head>
<body>	
<jsp:include page="../include/header.jsp" />	
		<div class="modal-content">		
			<div class="login-form">
				<h2>비밀번호 찾기</h2>	
				<p id="error-container" style="color:red; font-size:15px; position:fixed; top:58%; right:45%;">
				<form action="Find_Password_ok" method="post" onsubmit="return find_check();">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="text" id="member_id" name="member_id" placeholder="ID">
					<br> 
					<input type="text" name="mail" id="mail" placeholder="Email">
					<input type="submit" value="Find password"> <br>	  	 
				</form>				
				<span id="error-container" style="color:red; font-size:20px;"></span>
				<p>
					더 많은 기능을 이용하고 싶으신가요?&nbsp;&nbsp;<input type="button" value="Join" onclick="location='C_Join';">					
				</p>
			</div>
		</div>
<jsp:include page="../include/footer.jsp" />
<script src="../../js/find_Password.js"></script>		
</body>
</html>		 



