/**
 *  비밀번호 찾을 때 아이디와 이메일 검증
 */
 //아이디 검증 
 function find_check(){
	
	if($.trim($('#member_id').val())==''){
		var errorMessage='* 아이디를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_id').val('').focus();
		 return false;
	}
	if($('#member_id').val().length < 5){
		var errorMessage='* 아이디를 5자 이상으로 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_id').focus();
		return false;
	};
	if($('#member_id').val().length > 12){
		var errorMessage='* 아이디를 12자 이내로 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_id').focus();
		return false;
	};
	if(!(/^[a-z0-9]+$/.test($('#member_id').val()))){
		var errorMessage='* 아이디는 영문소문자,숫자 조합만 가능합니다'
		$('#error-container').html(errorMessage); 
		$('#member_id').focus();
		return false;
	};
	if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/.test($('#mail').val()))){
		var errorMessage='* 정확한 이메일 형식을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#mail').focus();
		 return false;
	}
}