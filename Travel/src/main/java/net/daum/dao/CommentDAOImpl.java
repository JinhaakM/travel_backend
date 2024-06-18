package net.daum.dao;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import net.daum.vo.Cm_CommentVO;
import net.daum.vo.Community_boardVO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;
	
	
	@Override
	public List<Cm_CommentVO> getCommentByMateno(Long mateno) {
		
		return this.commentRepo.findByCommunityBoardMateno(mateno);
	}


	@Override
	public Cm_CommentVO saveComment(Cm_CommentVO comment, Long mateno) {
		//Community_boardVO를 데이터 베이스에서 조회
		System.out.println("\n 댓글 추가하기");
		Community_boardVO communityBoard=postRepo.findById(mateno)
				.orElseThrow(()->new IllegalArgumentException("게시물 번호에 해당하는 게시물이 없습니다. mateno: " + mateno));
		comment.setCommunityBoard(communityBoard);
		return commentRepo.save(comment);
	}


	@Override
	public Cm_CommentVO updateComment(Long commentNo, Cm_CommentVO updatedComment) {
	    Cm_CommentVO comment = commentRepo.findById(commentNo)
	            .orElseThrow(() -> new NoSuchElementException("댓글 번호에 해당하는 댓글이 없습니다. commentNo: " + commentNo));
	    comment.setCommentText(updatedComment.getCommentText());
	    return this.commentRepo.save(comment);
	}


	@Override
	public void deleteComment(Long commentNo) {
		try {
			//게시글 번호에 해당하는 댓글 번호만 삭제
			commentRepo.deleteById(commentNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	

	
	



	
	
}
