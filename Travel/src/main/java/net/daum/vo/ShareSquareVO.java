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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@SequenceGenerator( //시퀀스 생성기
		name="Share_Square_no_seq_gename",//시퀀스 제너레이터 이름
		sequenceName="Share_Square_no_seq", //시퀀스이름
		initialValue=1,
		allocationSize=1//1씩증가, 메모리에 할당된 기본값은 50
		)
@Table(name="Share_Square")
@EqualsAndHashCode(of="sboard_no")
public class ShareSquareVO { //ShareSquare 게시판

	@Id //기본키
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할전략을 시퀀스로 선택
			generator = "shareSquare_no_seq_gename"////시퀀스 생성기에서 설정해 놓은 시퀀스 제너레이터 이름
			)
		
	private int sboard_no; //게시글 번호
	
	private String sboard_title; //게시글 제목
	
	@Column(length = 4000)
	private String sboard_content; //게시글 내용
	
	private String sboard_file; //이미지 파일
	
	private int sboard_hit; // 게시글 조회수
	private int sboard_like; // 게시글 좋아요
	
	@OneToMany(mappedBy = "shareSquareVO",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ShareReplyVO> ShareReplyVO;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberVO memberVO;
	
	@CreationTimestamp
	private Timestamp sboard_Regdate; //게시글 날짜
}
