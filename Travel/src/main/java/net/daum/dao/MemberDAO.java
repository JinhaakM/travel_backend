package net.daum.dao;

import java.util.ArrayList;
import java.util.List;

import net.daum.vo.ChatVO;
import net.daum.vo.MemberVO;
import net.daum.vo.MessageVO;

public interface MemberDAO {

	void insertMember(MemberVO m);
	MemberVO loginCheck(String member_id);
	MemberVO idCheck(String id);
	MemberVO idAndMailCheck(String member_id, String mail_id, String mail_domain);
	void updatePwd(MemberVO m);
	void update_Edit(MemberVO m);
	void deldeteUser(String userId);
	long getChatNumber(String member_id);
	List<String> getAllUserId();
	void setMessage(MessageVO msg);
	List<MessageVO> getAllMessage(long chatNumber);

	
}
