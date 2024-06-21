package net.daum.service;

import java.util.List;

import net.daum.vo.ShareReplyVO;

public interface SReplyService {

	ShareReplyVO insertaddReply(ShareReplyVO rvo, int sboard_no);

	List<ShareReplyVO> getshareReply(int sboard_no);



	
	
	
	
	
	





}
