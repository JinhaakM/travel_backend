package net.daum.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.daum.config.MyEntityListener;

@Setter 
@Getter 
@ToString 
@Entity 
@SequenceGenerator( 
		  name="plan_seq" , 
		  sequenceName="plan_no_seq",
		  initialValue= 1 , 
		  allocationSize = 1 
		)
@Table(name="plan") 
@EqualsAndHashCode(of="planNo")
@EntityListeners(MyEntityListener.class)
public class PlanVO {
	
	@Id
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator= "plan_seq"
			)
	@Column(name= "plan_no", nullable = false)
	private int planNo;
	
	@Column(name = "departure_date", nullable = false)
	private Date departureDate;
	
	@Column(name= "arrival_date", nullable = false)
	private Date arrivalDate;

	@CreationTimestamp
	@Column(name= "plan_date", nullable = false)
    private Timestamp planDate;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberVO memberVO;
	
	   @ManyToMany
	   @JoinTable(
	         name= "plan_city",
	         joinColumns= @JoinColumn(name= "plan_no"),
	         inverseJoinColumns= @JoinColumn(name= "city_code")
	         )
	   private List<CityVO>cities= new ArrayList<>();
}
