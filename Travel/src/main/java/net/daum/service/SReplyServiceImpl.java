package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.SReplyDAO;
import net.daum.dao.ShareSquareDAO;
import net.daum.vo.ShareReplyVO;


@Service
public class SReplyServiceImpl implements SReplyService {
	
	@Autowired
	private ShareSquareDAO sharesquareDao;
	
	@Autowired
	private SReplyDAO sreplyDao;

	@Override
	public ShareReplyVO insertaddReply(ShareReplyVO rvo, int sboard_no) {		
		return sreplyDao.insertaddReply(rvo,sboard_no);		
	}
		
	@Override
	public List<ShareReplyVO> getshareReply(int sboard_no) {
		return this.sreplyDao.getshareReply(sboard_no);
	}
	
	



}