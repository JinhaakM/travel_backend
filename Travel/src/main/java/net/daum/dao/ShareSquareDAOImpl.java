package net.daum.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.PageVO;
import net.daum.vo.ShareSquareVO;

@Repository
public class ShareSquareDAOImpl implements ShareSquareDAO {

	@Autowired
	private ShareSquareRepository sharesquareRepo;
		
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void insertShare(ShareSquareVO s) {
		System.out.println("/n 공유 후기 저장(JPA)=====>");		
		this.sharesquareRepo.save(s);		
	}
	

	@Override
	public List<ShareSquareVO> getshareSquareList(ShareSquareVO s) {
		System.out.println("/n 공유 후기 목록 리스트(JPA)=====>");
		return this.sharesquareRepo.findAll();
	}

	@Override
	public int getListCount(PageVO p) {
		return this.sqlsession.selectOne("ss_count",p);
	}//검색전후 레코드 개수


	@Override
	public List<ShareSquareVO> getshareSquareList(PageVO p) {
		return this.sqlsession.selectList("ss_list",p);
	}//검색전후 목록


	@Override
	public ShareSquareVO getshareSquareCont(int no) {
		System.out.println("\n 공유후기 내용보기(JPA) ==============>");
	    ShareSquareVO ssc = this.sharesquareRepo.getReferenceById(no);
	    
		return ssc;
	}

	@Override
	public void updateHit(int no) {
		this.sqlsession.update("s_hit",no);
	}


	

























	



}
