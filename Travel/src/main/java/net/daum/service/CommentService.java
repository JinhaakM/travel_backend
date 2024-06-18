package net.daum.service;

import java.util.List;

import net.daum.vo.Cm_CommentVO;
import net.daum.vo.Community_boardVO;

public interface CommentService {


	List<Cm_CommentVO> getCommentByMateno(Long mateno);

	Cm_CommentVO saveComment(Cm_CommentVO comment, Long mateno);

	Cm_CommentVO updateComment(Long commentNo, Cm_CommentVO comment);

	

	void deleteComment(Long commentNo);

	








	

}
