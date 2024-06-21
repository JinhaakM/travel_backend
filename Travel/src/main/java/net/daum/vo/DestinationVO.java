package net.daum.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter //setter()메서드 자동생성
@Getter //getter()메서드 자동생성
@ToString //toString()메서드 자동생성
@Entity //엔티티빈

@Table(name="destination") //destination 테이블 생성
@EqualsAndHashCode(of="plan")
//equals(), hashCode(), canEqual() 메서드 자동생성
public class DestinationVO {
	@Id
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator= "Destination_seq"
			)
	@Column(name= "Destination_no", nullable = false)
	private int destinationNo;// 일정번호
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "plan_no", referencedColumnName= "plan_no")
	private PlanVO plan;
	
	@Column(name= "place_name", nullable= false)
	private String placeName;
	
	@Column(name= "place_latitude", nullable= false)
	private double placeLatitude;
	
	@Column(name= "place_longitude", nullable= false)
	private double placeLongitude;
}
