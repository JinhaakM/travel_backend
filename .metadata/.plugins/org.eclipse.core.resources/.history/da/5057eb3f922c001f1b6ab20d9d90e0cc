package net.daum.vo;

import java.sql.Timestamp;

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

@Setter
@Getter
@ToString
@Entity
@SequenceGenerator(
		name = "cmimg_no_seq_gename",
		sequenceName ="cmimg_no_seq",
		initialValue = 1,
		allocationSize = 1
		)
@Table(name="cm_img")
@EqualsAndHashCode(of="cmimg_no")
public class Cm_ImgVO {
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "cmimg_no_seq_gename"
			)
	private Long cmimg_no; //이미지 번호
	
	private String uploadFile; // 파일의 저장 경로를 저장하는 필드

	
	@CreationTimestamp
	private Timestamp uploaddate;	
	
	private Long mateno2;
}