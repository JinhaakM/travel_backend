package net.daum.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동생성
@Getter //getter()메서드 자동생성
@ToString(exclude = "nationalCode") //toString()메서드 자동생성
@Entity //엔티티빈

@Table(name="city") //member 테이블 생성
@EqualsAndHashCode(of="cityCode")
//equals(), hashCode(), canEqual() 메서드 자동생성
public class CityVO {
	@Id
	@Column(name= "city_code", nullable= true)
	private String cityCode;
	
	@Column(name= "city_name", nullable = false)
	private String cityName;
	
	@Column(name= "latitude", nullable= false)
	private double latitude;// 위도
	
	@Column(name= "longitude", nullable= false)
	private double longitude;// 경도
	
	@Column(name= "capital_city", nullable= true)
	private String capitalCity;
	
	@Column(name= "city_image", nullable= true)
	private String cityImage;// 도시 대표 이미지
	
	@JsonIgnore
	@ManyToOne (cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn (name="national_code")
	private NationalVO nationalCode;
}
