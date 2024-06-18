package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.daum.dao.PostDAO;
import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;




@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDao;
	
	
	@Override
	public void insertboard(Community_boardVO b) {
		this.postDao.insertboard(b);		
	}

	@Override
	public void insertboard(Cm_ImgVO cm) {
		this.postDao.insertboard(cm);		
	}
	

	
	@Override
	public Page<Community_boardVO> getAllPosts(Pageable pageable) {
		
		return this.postDao.getAllposts(pageable);
	}

	@Transactional
	@Override
	public void editBoard(Community_boardVO cb) {
		
		this.postDao.editBoard(cb);
		
	}

	@Transactional
	@Override
	public void editImages(Long mateno, List<String> newImages, List<String> deleteImages) {
		if(deleteImages != null && !deleteImages.isEmpty()) {
			postDao.deleteImages(mateno,deleteImages);
		}
		if(newImages!=null && !newImages.isEmpty()) {
			postDao.editImages(mateno, newImages);
		}
		
	}
	@Transactional
	@Override
	public void deleteImages(Long mateno, List<String> deleteImages) {
		postDao.deleteImages(mateno, deleteImages);
		
	}
	


	@Override
	public Community_boardVO getPostInfo(Long mateno) {
		
		return this.postDao.getPostInfo(mateno);
	}


	@Override
	public void delpost(Long mateno) {
		this.postDao.delpost(mateno);
		
	}

	
	@Override
	public Page<Community_boardVO> searchPosts(String searchInput, Pageable pageable) {
		
		return this.postDao.searchPosts(searchInput,pageable);
	}

	@Override
	public Page<Community_boardVO> searchPostsByTitle(String searchInput, Pageable pageable) {
		return this.postDao.searchPostsByTitle(searchInput,pageable);
	}

	@Override
	public Page<Community_boardVO> searchPostsByContent(String searchInput, Pageable pageable) {
		
		return this.postDao.searchPostsByContent(searchInput,pageable);
	}

	

	
	


	

	

	
	

	
	

	
	

	
	

	




}




