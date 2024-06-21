    //댓글 등록
    $('#sreplyAddBtn').on('click',function(){
    	 var sboard_no=$('#sboard_no').val();
		 var sreplyer=$('#sreplyer').val();
		  //console.log(sreplyer);  
		  //console.log(sboard_no);
		 var sreplytext=$('#newReplyText').val();
							 
	 	$.ajax({ //jQuery 비동기식 아작스 함수
    		type:'POST', //메서드 보내는 양식
    		url:'/replies/addReply/' +sboard_no, //매핑주소 경로
    		contentType:'application/json',
	
    		data:JSON.stringify({				
    			sboard_no:sboard_no,
    			sreplyer:sreplyer,
    			replytext:sreplytext
    			}),
    		success:function(response){//받아오기 성공 시 호출되는 콜백함수, 받아온 데이터는 response매개변수에 저장
				alert('댓글이 등록되었습니다!');
   				location.reload(); //새로고침 => 단축키 F5
				getAllList(); //댓글목록 함수 호출    					    s			
		   		},
	    	error : function(xhr,status,error){
				console.error('ajax 호출 불가',error);
		    	}
	    	});
	    	// console.log(sreplyer);
    });
    
    




	
	
	