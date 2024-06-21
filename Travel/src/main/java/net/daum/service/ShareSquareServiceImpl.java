package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.ShareSquareDAO;
import net.daum.vo.PageVO;
import net.daum.vo.ShareSquareVO;

@Service
public class ShareSquareServiceImpl implements ShareSquareService {

	@Autowired
	private ShareSquareDAO sharesquareDao;

	@Override
	public void insertShare(ShareSquareVO s) {
		this.sharesquareDao.insertShare(s);
	}

	@Override
	public List<ShareSquareVO> getshareSquareList(ShareSquareVO s) {
		return sharesquareDao.getshareSquareList(s);
	}

	
	@Override
	public int getListCount(PageVO p) {
		return this.sharesquareDao.getListCount(p);
	}

	@Override
	public List<ShareSquareVO> getshareSquareList(PageVO p) {
		return this.sharesquareDao.getshareSquareList(p);
	}
	
	//조회수 증가 + 내용보기
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ShareSquareVO getshareSquareCont(int no) {
		this.sharesquareDao.updateHit(no);
		return this.sharesquareDao.getshareSquareCont(no);
	}
	
	

	
	




	



}
