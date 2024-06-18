package net.daum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;



public interface PostService {

	void insertboard(Community_boardVO b);
	
	void insertboard(Cm_ImgVO cm);
	
	Page<Community_boardVO> getAllPosts(Pageable pageable);

	

	

	void editBoard(Community_boardVO cb);

	void editImages(Long mateno, List<String> newImages, List<String> deleteImages);
	
	void deleteImages(Long mateno, List<String>deleteImages);
	
	Community_boardVO getPostInfo(Long mateno);
	
	void delpost(Long mateno);
	

	

	Page<Community_boardVO> searchPosts(String searchInput, Pageable pageable);

	Page<Community_boardVO> searchPostsByTitle(String searchInput, Pageable pageable);

	Page<Community_boardVO> searchPostsByContent(String searchInput, Pageable pageable);

	

	



	
}
