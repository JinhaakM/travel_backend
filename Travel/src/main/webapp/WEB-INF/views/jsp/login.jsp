<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-image: url('../images/4.jpg');
}
</style>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp" />
		<div class="modal-content">		
			<div class="login-form">
				<h2>Login to Your Account</h2>
				<form action="login_ok" method="post" onsubmit="return login_check();">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
					<input type="text" id="member_id" name="member_id" placeholder="ID">
					<br> 
					
					<input type="password" id="member_pwd" name="member_pwd" placeholder="PW"><br>
					<input type="submit" value="Login"> <br>
					  	 <tr>
  	  						<td colspan="2">
  	   							로그인 유지 : 
  	   							<input type="checkbox" id="remember-me" name="remember-me">
  	  							</td>
  						 </tr>
				</form>	
	
				<span id="error-container" style="color:red; font-size:20px;"></span>
				<p>
					더 많은 기능을 이용하고 싶으신가요?&nbsp;&nbsp;<input type="button" value="Join" onclick="location='C_Join';">
					<br>
					비밀번호를 잃어버리셨나요?&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Find Password" onclick="location='Find_Password';">
				</p>
			</div>
		</div>	
<jsp:include page="../include/footer.jsp" />
<script src="../../js/login.js"></script> 
</body>
</html>