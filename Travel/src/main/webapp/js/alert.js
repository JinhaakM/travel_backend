/**
 * alert.js
 */


function join_check(){
	
	//이름 검증
	if($.trim($('#member_name').val())==''){
		var errorMessage='* 이름을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_name').val('').focus();
		 return false;
	}
	if (!/^[가-힣]+$/.test($('#member_name').val())) {
    	var errorMessage = '* 한글만 입력하세요';
    	$('#error-container').html(errorMessage);
    	$('#member_name').focus();
    	return false;
	}

	//주민등록번호 검증
	var residentId1 = $.trim($('#resident_id').val());
	var residentId2 = $.trim($('#resident_id2').val());
	var fullResidentId = residentId1 + residentId2;

	if (residentId1 === '' || residentId2 === '') {
		var errorMessage = '* 주민번호를 입력하세요';
    	$('#error-container').html(errorMessage);
    	$('#resident_id').focus();
    	return false;
	}
	if (!/^[0-9]{6}[1-4][0-9]{6}$/.test(fullResidentId)) {
    	var errorMessage = '* 올바른 주민번호 형식이 아닙니다';
    	$('#error-container').html(errorMessage);
    	$('#resident_id').focus();
    	return false;
	}
	
	//휴대폰 번호 검증
	if($.trim($('#member_phone01').val())==''){
		var errorMessage='* 휴대폰 번호를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_phone01').val('').focus();
		 return false;
	}
	if (!(/^[0-9]+$/.test($.trim($('#member_phone01').val())))) {
   		 var errorMessage = '* 휴대폰 번호는 숫자만 입력 가능합니다';
    	 $('#error-container').html(errorMessage); 
    	 $('#member_phone01').focus();
    	 return false;
	 }
	if($.trim($('#member_phone02').val())==''){
		var errorMessage='* 휴대폰 번호를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_phone02').val('').focus();
		 return false;
	}
	if (!(/^[0-9]+$/.test($.trim($('#member_phone02').val())))) {
   		 var errorMessage = '* 휴대폰 번호는 숫자만 입력 가능합니다';
    	 $('#error-container').html(errorMessage); 
    	 $('#member_phone02').focus();
    	 return false;
	 }
	if($.trim($('#member_phone03').val())==''){
		var errorMessage='* 휴대폰 번호를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#member_phone03').val('').focus();
		 return false;
	}
	if (!(/^[0-9]+$/.test($.trim($('#member_phone03').val())))) {
   		 var errorMessage = '* 휴대폰 번호는 숫자만 입력 가능합니다';
    	 $('#error-container').html(errorMessage); 
    	 $('#member_phone03').focus();
    	 return false;
	 }
	  
	//이메일 검증 
	if($.trim($('#mail_id').val())==''){
		var errorMessage='* 이메일을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#mail_id').val('').focus();
		 return false;
	}
	if($.trim($('#mail_domain').val())==''){
		var errorMessage='* 이메일 주소를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#mail_domain').val('').focus();
		 return false;
	}
	if(!(/^[a-zA-Z0-9_-]+$/.test($('#mail_id').val()))){
		var errorMessage='* 정확한 이메일 형식을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#mail_id').focus();
		 return false;
	}
	if(!(/^[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/.test($('#mail_domain').val()))){
		var errorMessage='* 정확한 이메일 형식을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#mail_domain').focus();
		 return false;
	}
	//주소 검증
	if($.trim($('#sample6_address').val())==''){
		var errorMessage='* 주소를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#sample6_address').val('').focus();
		 return false;
	}
	if($.trim($('#sample6_detailAddress').val())==''){
		var errorMessage='* 상세주소를 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#sample6_detailAddress').val('').focus();
		 return false;
	}
	if($.trim($('#sample6_extraAddress').val())==''){
		var errorMessage='* 참고항목을 입력하세요'
		$('#error-container').html(errorMessage); 
		$('#sample6_extraAddress').val('').focus();
		 return false;
	}
	
 }//join_check()
 
	//메일 주소 선택과 직접입력
	function domain_list(){
  		var num=m.mail_list.selectedIndex;
  		if(num == -1){
	  	return true;
  	}
  	if(m.mail_list.value =="직접입력"){
	  	m.mail_domain.value = "";
	  	m.mail_domain.readOnly=false;
	  	m.mail_domain.focus();
  	}else{
	 	m.mail_domain.value=m.mail_list.options[num].value;
	 	m.mail_domain.readOnly=true;
  	}

	}