package net.daum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.service.CommentService;
import net.daum.vo.Cm_CommentVO;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	  // 댓글 추가 기능
    @PostMapping("/add/{mateno}")
    public ResponseEntity<Cm_CommentVO> addComment(@RequestBody Cm_CommentVO comment, @PathVariable Long mateno) {
        try {
            Cm_CommentVO savedComment = commentService.saveComment(comment, mateno);
            
            return ResponseEntity.ok(savedComment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
 // 특정 게시물의 댓글 조회
    @GetMapping("/list/{mateno}")
    public ResponseEntity<List<Cm_CommentVO>> getCommentsByMateno(@PathVariable Long mateno) {
        try {
            List<Cm_CommentVO> comments = commentService.getCommentByMateno(mateno);
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
    // 댓글 수정 기능
    @PutMapping("/update/{commentNo}")
    public ResponseEntity<Cm_CommentVO> updateComment(@PathVariable Long commentNo, @RequestBody Cm_CommentVO comment) {
        try {
            Cm_CommentVO updatedComment = commentService.updateComment(commentNo, comment);
            return ResponseEntity.ok(updatedComment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	
    // 댓글 삭제 기능
    @DeleteMapping("/delete/{commentNo}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentNo) {
        try {
            commentService.deleteComment(commentNo);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}