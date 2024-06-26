package net.daum.vo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동생성
@Getter //getter()메서드 자동생성
@ToString //toString()메서드 자동생성
@Entity //엔티티빈
@Table(name="national") //member 테이블 생성
@EqualsAndHashCode(of="nationalCode")
//equals(), hashCode(), canEqual() 메서드 자동생성
public class NationalVO {

	@Id
	@Column(name= "national_code")
	private String nationalCode;// 국가코드
	
	@Column(name= "national_name", nullable = false)
	private String nationalName;// 국가명
	
	@Column(name= "time_difference", nullable = false)
	private String timeDifference;// 시차
	
	@Column(name= "flag_path", nullable= true)
	private String flagPath;// 국기 이미지파일 경로
	
	@OneToMany(mappedBy= "nationalCode", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CityVO> city= new ArrayList<>();
	
	// 도시 추가 메소드
	public void addCity(CityVO city) {
		this.city.add(city);
		city.setNationalCode(this);// cityVO의 국가정보컬럼에 값을 DB에도 저장
	}
}