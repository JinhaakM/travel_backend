package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_sreply")
@EqualsAndHashCode(of="srno")
@SequenceGenerator( //시퀀스 생성기
		name="srno_seq_gename", //시퀀스 제너레이터 이름
		sequenceName="srno_seq", //시퀀스 이름
		initialValue=1, //시퀀스 번호 시작값
		allocationSize=1 //시퀀스 증가값
		)
public class ShareReplyVO {//댓글 테이블인 tbl_sreply 저장빈 클래스
	
	@Id//기본키 컬럼
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			generator = "srno_seq_gename" //시퀀스 생성기에 설정한 시퀀스 제너레이터
			)
	private int srno; //댓글번호(Share Reply No)
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "sboard_no", referencedColumnName = "sboard_no")
	private ShareSquareVO shareSquareVO;
	
	private String sreplyer; //댓글작성자
	private String replytext; //댓글 내용
	
	@CreationTimestamp
	private Timestamp regdate; //댓글 등록 날짜
}