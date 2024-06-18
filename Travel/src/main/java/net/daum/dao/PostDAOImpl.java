package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;


@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired  
	private CmImgRepository cmImgRepo;
	
	@Autowired private SqlSession sqlSession;
	 

	@Override
	public void insertboard(Community_boardVO b) {
		
		
		System.out.println(" \n 게시물 저장과 업로드된 이미지 저장 =========>");
		Long mate_no=this.sqlSession.selectOne("mateNoSeq_Find");
		b.setMateno(mate_no);
		this.postRepo.save(b);		
	}


	@Override
	public void insertboard(Cm_ImgVO cm) {
		System.out.println(" \n 다중 파일 업로드 저장(JPA) ==========>");
		
		cm.setMateno2(postRepo.getMaxMateNo());
		this.cmImgRepo.save(cm);		
	}	
	
	
	
	@Override
	public Page<Community_boardVO> getAllposts(Pageable pageable) {
		System.out.println(" \n 페이징된 게시물 요소 가져오기");
	
		return this.postRepo.getAllPosts(pageable);
	}


	@Override// 게시된 게시글 번호를 기준으로 값 조회하기
	public Community_boardVO getPostInfo(Long mateno) {
		System.out.println(" \n 게시된 게시글 번호를 기준으로 값 조회하기");
		return this.postRepo.getPostInfo(mateno);
	}


	  @Override
	    public void editBoard(Community_boardVO updatedBoard) {
	        System.out.println(" \n 게시글 수정");
	        Community_boardVO existingBoard = postRepo.findById(updatedBoard.getMateno())
	                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + updatedBoard.getMateno()));

	        existingBoard.setMate_title(updatedBoard.getMate_title());
	        existingBoard.setMate_cont(updatedBoard.getMate_cont());
	        existingBoard.setMt_hashtag(updatedBoard.getMt_hashtag());

	        // 기존 댓글 목록 유지, 필요 시 추가적인 처리 수행
	        if (updatedBoard.getComments() != null) {
	            existingBoard.getComments().clear();
	            existingBoard.getComments().addAll(updatedBoard.getComments());
	            updatedBoard.getComments().forEach(comment -> comment.setCommunityBoard(existingBoard));
	        }

	        postRepo.save(existingBoard);
	    }

	  @Override
		public void editImages(Long mateno, List<String> newImages) {
			
			
			System.out.println("\n 이미지 새로 저장");
			//새 이미지 저장
			for(String fileDBName : newImages) {
				Cm_ImgVO newImage = new Cm_ImgVO();
				newImage.setMateno2(mateno);
				newImage.setUploadFile(fileDBName);
				cmImgRepo.save(newImage);
				
			}
			
		}


		@Override
		public void deleteImages(Long mateno, List<String> deleteImages) {
			
			//게시글 번호에 맞는 이미지 삭제
			for(String fileDBName:deleteImages) {
				System.out.println("\n 이미지 삭제");
				cmImgRepo.deleteByuploadFileAndMateno2(fileDBName,mateno);
			}
			
		}
		
	@Override
	public void delpost(Long mateno) {
		System.out.println(" \n 게시물 삭제");
		this.postRepo.deleteById(mateno);
		
	}

	@Override
	public Page<Community_boardVO> searchPosts(String searchInput, Pageable pageable) {
		System.out.println(" \n 전체 검색");
		return postRepo.searchPosts("%"+searchInput+"%", pageable);
	}


	@Override
	public Page<Community_boardVO> searchPostsByTitle(String searchInput, Pageable pageable) {
		System.out.println(" \n 제목으로 검색");
		return postRepo.searchPostsByTitle(searchInput, pageable);
	}


	@Override
	public Page<Community_boardVO> searchPostsByContent(String searchInput, Pageable pageable) {
		System.out.println(" \n 글내용으로 검색");
		return postRepo.searchPostsByContent(searchInput,pageable);
	}




	

	



	


	


	


	



	

	

	

	 
	}

	



	
	
	
	
	

	
	

	
	

