package net.daum.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.daum.vo.ShareReplyVO;
import net.daum.vo.ShareSquareVO;


@Repository
public class SReplyDAOImpl implements SReplyDAO {
	
	
	@Autowired
	private SReplyRepository sreplyRepo;
	
	@Autowired
	private ShareSquareRepository shareSquareRepo;
	
	
	@Transactional
	@Override
	public ShareReplyVO insertaddReply(ShareReplyVO rvo, int sboard_no) {
		System.out.println("\n 진짜 댓글 저장(JPA)=====>");
		ShareSquareVO cc= shareSquareRepo.findById(sboard_no).orElseThrow(()->new IllegalArgumentException("게시물 번호에 해당하는 글이 없습니다."));
		rvo.setShareSquareVO(cc);
			return this.sreplyRepo.save(rvo);			
	}

	@Override
	public List<ShareReplyVO> getshareReply(int sboard_no) {
		System.out.println("\n 댓글 리스트 불러오기(JPA)=====>");
		List<ShareReplyVO> list=new ArrayList<>();
	    	list=this.sreplyRepo.getAllReply(sboard_no);
	    return list;
	}

	
	
	
	



}