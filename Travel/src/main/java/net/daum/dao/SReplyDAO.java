package net.daum.dao;


import java.util.List;

import net.daum.vo.ShareReplyVO;

public interface SReplyDAO {

	
	ShareReplyVO insertaddReply(ShareReplyVO rvo, int sboard_no);
	
	List<ShareReplyVO> getshareReply(int sboard_no);

	


	
	
	
	


}
