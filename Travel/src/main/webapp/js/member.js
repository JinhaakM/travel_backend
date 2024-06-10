/**
 * member.js
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

	//아이디 검증
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
	if($.trim($('#member_pwd2').val()) != $.trim($('#member_pwd').val())){
		var errorMessage='* 비밀번호가 다릅니다'
		$('#error-container').html(errorMessage); 
		$('#member_pwd2').focus();
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
 	//서버와 연결해 중복 검사	
 	function id_check(){
	
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
	//jsp에서 설정한 토큰을 아작스로 보내기 위해서 값을 저장한다.
	var header = $("meta[name='_csrf_header']").attr('content');
    var token = $("meta[name='_csrf']").attr('content');  
    
 	//서버로 아이디를 보내 중복체크
    $.ajax({
        type:"POST",   
        url:"Idcheck", 
        beforeSend: function(xhr){
         xhr.setRequestHeader(header, token);
        },
        //아작스 요청을 보내기 전에 헤더에 토큰을 담아놓는다.
        data: {"id":$('#member_id').val()},  
        datatype:"int",
        success: function (data) {
      	  if(data==1){
      		var errorMessage='* 사용 불가능한 아이디 입니다'
			$('#error-container').html(errorMessage); 
			$('#member_id').focus();
          	return false;	
      	  }else{
      		var errorMessage='* 사용 가능한 아이디 입니다'
			$('#error-container').html(errorMessage); 
			$('#member_id').focus();
			$('#signup-btn').prop('disabled', false);
			
      	  }  	    	  
        },
    	  error:function(){
    		  alert("이거 참 곤란합니다...");
    		  
    	  }
      });
	}//id_check()