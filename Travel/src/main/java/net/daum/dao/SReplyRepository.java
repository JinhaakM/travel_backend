package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.ShareReplyVO;

public interface SReplyRepository extends JpaRepository<ShareReplyVO, Integer> {

	@Query("select m from ShareReplyVO m where m.shareSquareVO.sboard_no=?1")
	List<ShareReplyVO> getAllReply(int no);

	
	

	

}
