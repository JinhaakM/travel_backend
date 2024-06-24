package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.ChatVO;
import net.daum.vo.MemberVO;

public interface ChatRepository extends JpaRepository<ChatVO, Long> {

	@Query("SELECT c.chatNo FROM ChatVO c WHERE c.memberVO.member_id = ?1")
    long findChatNumberByMemberId(String member_id);	
}
