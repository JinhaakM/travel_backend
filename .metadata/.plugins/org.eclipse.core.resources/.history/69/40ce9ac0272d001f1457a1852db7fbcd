package net.daum.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(// 오라클 시퀀스 생성기
		name = "mate_noseq_gename", 
		sequenceName = "mate_no_seq", // 시퀀스 이름
		initialValue = 1, // 시퀀스 시작값
		allocationSize = 1

)
@EqualsAndHashCode(of="mateno")
@Table(name = "community_board")
public class Community_boardVO {

	@Id // 기본키
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_noseq_gename")
	
	private Long mateno;// 기본키 게시글 번호


	private String mate_title; //제목
	
	@Column(length=4000)
	private String mate_cont; // 내용
	
	@CreationTimestamp //하이버네이트 기능으로 등록시점 날짜를 기록
	private Timestamp makedate;//등록 날짜
	
	@UpdateTimestamp
	private Timestamp updatedate;//하이버네이트 기능으로 업데이트 날짜 자동 기록
	
	
	private String mt_hashtag; //해시태그
	
	@OneToMany(mappedBy="communityBoard", cascade = CascadeType.ALL)
	private List<Cm_CommentVO> comments;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="mateno2")//왜 이걸로 연결한 거지?
	private List<Cm_ImgVO> images;//외래키로 게시판 이미지 테이블에  게시판의 기본키 참조 
	
	@ManyToOne
    @JoinColumn(name = "member_id")
    private MemberVO memberVO;

}