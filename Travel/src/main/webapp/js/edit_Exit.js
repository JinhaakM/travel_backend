/**
 * 
 */

function join_check(){
	
	//비밀번호 검증
	if($.trim($('#member_pwd').val())==''){
		var errorMessage='* 비밀번호를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_pwd').val('').focus();
		 return false;
	}
	if (!(/^[a-z0-9!@]+$/.test($.trim($('#member_pwd').val())))) {
   		 var errorMessage = '* 비밀번호는 영문 소문자와 숫자, !,@만 가능합니다';
    	 $('#error-container').html(errorMessage); 
    	 $('#member_pwd').focus();
    	 return false;
	 }
	if($.trim($('#member_pwd2').val())==''){
		var errorMessage='* 비밀번호를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_pwd2').val('').focus();
		 return false;
	}
	if (!(/^[a-z0-9!@]+$/.test($.trim($('#member_pwd').val())))) {
   		 var errorMessage = '* 비밀번호는 영문 소문자와 숫자, !,@만 가능합니다';
    	 $('#error-container').html(errorMessage); 
    	 $('#member_pwd').focus();
    	 return false;
	 }
	
	if($.trim($('#member_pwd').val()) != $.trim($('#member_pwd2').val())){
		var errorMessage='* 비밀번호가 다릅니다'
		$('#error-container').html(errorMessage); 
		$('#member_pwd2').focus();
		 return false;
	}

 }//join_check()
