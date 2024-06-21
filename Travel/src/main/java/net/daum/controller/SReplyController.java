package net.daum.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.SReplyService;
import net.daum.vo.ShareReplyVO;


@RestController
@RequestMapping("/replies") 
public class SReplyController {

	@Autowired
	private SReplyService sreplyService;
	
	//댓글 등록
	@PostMapping("/addReply/{sboard_no}")
	public ResponseEntity<ShareReplyVO> addReply(@RequestBody ShareReplyVO rvo,@PathVariable int sboard_no){
		
		//System.out.println(rvo.getReplytext());
		//System.out.println(rvo);
		//System.out.println(sboard_no);
		//System.out.println("1111");
		try {
			ShareReplyVO sreply = this.sreplyService.insertaddReply(rvo,sboard_no); //이거추가(댓글)
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}		
	
	//댓글 목록
	@GetMapping("/all/{sboard_no}")	
	public ResponseEntity<List<ShareReplyVO>> getAllList(@PathVariable int sboard_no) {
		        // sboard_no에 해당하는 게시물의 모든 댓글을 가져오는 서비스 메서드 호출
	try {
		List<ShareReplyVO> replies = sreplyService.getshareReply(sboard_no);
		return ResponseEntity.ok(replies); // JSON 형태로 반환됨
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
		
	}
		
		
		
		
		
		
	
			

	

}		
    		
 

