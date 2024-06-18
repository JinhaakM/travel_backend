package net.daum.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Long> {
	// 전체 게시물 조회
	@Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM community_board a ORDER BY mateno DESC) WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize} AND rnum > :#{#pageable.offset}",
	       countQuery = "SELECT COUNT(*) FROM community_board",
	       nativeQuery = true)
	Page<Community_boardVO> getAllPosts(Pageable pageable);
 
	 
	// 게시물 번호 조회
	@Query("select max(c.mateno) from Community_boardVO c ")
	public Long getMaxMateNo();

	// 게시물 이미지 조회
	@Query("select p from Community_boardVO p WHERE p.mateno = :mateno")
	public Community_boardVO getPostInfo(@Param("mateno") Long mateno);
	

	    // 전체 검색
	    @Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM community_board WHERE mate_title LIKE %:searchInput% OR mate_cont LIKE %:searchInput% OR mt_hashtag LIKE %:searchInput% ORDER BY mateno DESC) a WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize}) WHERE rnum > :#{#pageable.offset}", 
	           countQuery = "SELECT COUNT(*) FROM community_board WHERE mate_title LIKE %:searchInput% OR mate_cont LIKE %:searchInput% OR mt_hashtag LIKE %:searchInput%", 
	           nativeQuery = true)
	    Page<Community_boardVO> searchPosts(@Param("searchInput") String searchInput, Pageable pageable);

	    // 제목 검색
	    @Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM community_board WHERE mate_title LIKE %:searchInput% ORDER BY mateno DESC) a WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize}) WHERE rnum > :#{#pageable.offset}", 
	           countQuery = "SELECT COUNT(*) FROM community_board WHERE mate_title LIKE %:searchInput%", 
	           nativeQuery = true)
	    Page<Community_boardVO> searchPostsByTitle(@Param("searchInput") String searchInput, Pageable pageable);

	    // 내용 검색
	    @Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM community_board WHERE mate_cont LIKE %:searchInput% ORDER BY mateno DESC) a WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize}) WHERE rnum > :#{#pageable.offset}", 
	           countQuery = "SELECT COUNT(*) FROM community_board WHERE mate_cont LIKE %:searchInput%", 
	           nativeQuery = true)
	    Page<Community_boardVO> searchPostsByContent(@Param("searchInput") String searchInput, Pageable pageable);


	


		


		


		
	}


	

	

	

	

	
