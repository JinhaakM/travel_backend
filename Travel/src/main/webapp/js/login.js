/**
 *  서버로 넘어가기 전 아이디와 비밀번호 체크
 */

 function login_check(){
	if($.trim($('#member_id').val())==''){
		var errorMessage='아이디를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_id').val('').focus();
		 return false;
	}
	if($.trim($('#member_pwd').val())==''){
		 var errorMessage='비밀번호를 입력하세요'
		 $('#error-container').html(errorMessage); 
		 $('#member_pwd').val('').focus();
		 return false;
	 }
 }
 
 window.onload = function() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.has('error')) {
                alert('가입된 회원이 아닙니다.\n아이디와 비밀번호를 다시 확인하세요.');   
            }
        }
 
 
 
        