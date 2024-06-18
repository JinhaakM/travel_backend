package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MessageVO;

public interface MessageRepository extends JpaRepository<MessageVO, Long> {

	@Query("select m from MessageVO m where m.chatVO.chatNo=?1")//order by m.messageNo asc
	List<MessageVO> getAllMessage(long chatNumber);

}
