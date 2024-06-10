<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url('../images/walletback.jpg');
}
</style>
</head>
<body>
<jsp:include page="../include/header.jsp" />
	<div class="modal-content">
			<div class="login-form">
				<h2>Logout to Your Account</h2>
				<form action="logout_ok" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<br> 	
					<input type="submit" value="Logout"> 
				</form>
				<p>
				    <br>
					
					<br>					
				</p>
			</div>
		</div>
<jsp:include page="../include/logout_footer.jsp" />		
</body>
</html>