package net.daum.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.Cm_CommentVO;


public interface CommentRepository extends JpaRepository<Cm_CommentVO, Long> {

	List<Cm_CommentVO> findByCommunityBoardMateno(Long mateno);
	
	void deleteByCommentNo(Long commentNo);;

	





	


}
