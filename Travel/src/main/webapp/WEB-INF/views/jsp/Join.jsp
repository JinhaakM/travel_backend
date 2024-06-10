<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/member.css">
<%--아작스로 토큰을 보내기 위해서 해놓는 초기 설정 > 이후에 아작스에서 값을 받아 보내줘야 한다. --%>
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}"> 
<style>
body {
	background-image: url('../images/4.jpg');
}
</style>
</head>

<body>
<jsp:include page="../include/header.jsp" />
<script type="text/javascript">
$(document).ready(function(){
	$('#signup-btn').prop('disabled', true);
});
</script>

	<div id="Join_wrap">
		<h2 class="Join_title">회원가입</h2> 
		<div id="error-container" style="color:red; font-size:15px; position:fixed; right:35%;"></div>
		
		<form name="m" method="post" action="Join_Clear" onsubmit="return join_check();">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table id="Join_t">
				<tr>
					<th>회원이름</th>
					<td><input name="member_name" id="member_name" size="10"></td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td><input name="resident_id" id="resident_id" size="8" maxlength="6">- 
					    <input type="password" name="resident_id2" id="resident_id2" size="8" maxlength="7">
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input name="member_id" id="member_id" size="14">
						<input type="button" value="아이디중복체크" onclick="id_check();"><br>
					</td>		
				</tr>

				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="member_pwd" id="member_pwd"size="14"></td>
				</tr>

				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="member_pwd2" id="member_pwd2"size="14"></td>
				</tr>

				<tr>
					<th>폰번호</th>
					<td><input name="member_phone01" id="member_phone01" size="3"maxlength="3"> -
						<input name="member_phone02" id="member_phone02" size="4" maxlength="4"> -
						<input name="member_phone03" id="member_phone03" size="4" maxlength="4">
					</td>
				</tr>

				<tr>
					<th>이메일</th>
					<td><input name="mail_id" id="mail_id" size="14" class="input_box">@ 
						<input name="mail_domain" id="mail_domain" size="18" class="input_box" readonly> 
						<select name="mail_list" onchange="domain_list();">
							<c:forEach var="mail" items="${email}">
								<option value="${mail}">${mail}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></td>
				</tr>
				<tr>
					<th>우편 번호</th>
					<td><input type="text" name="sample6_postcode" id="sample6_postcode"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="sample6_address" id="sample6_address" size="30"></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><input type="text" name="sample6_detailAddress" id="sample6_detailAddress" size="30"></td>
				</tr>
				<tr>
					<th>참고항목</th>
					<td><input type="text" name="sample6_extraAddress" id="sample6_extraAddress"></td>
				</tr>
			</table>
			<div id="Join_menu">
				<input type="submit" value="가입" id="signup-btn">&nbsp;&nbsp;&nbsp; 
				<input type="reset" value="취소">
			</div>
		</form>
	</div>	
<jsp:include page="../include/footer.jsp" />	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../js/Join_Zip.js"></script>
<script src="../../js/member.js"></script>	
</body>
</html>