package net.daum.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
@ToString
@Entity
@Table(name = "persistent_logins")
//시큐리티가 자동으로 인식하는 테이블 명 persistent_logins
//persistent_logins 가 아닌 다른 테이블 명을 쓴다면 시큐리티에서 테이블명 세팅을 해줘야 한다.
@EqualsAndHashCode(of="series")
public class RememberKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String series;
    private String username;
    private String token;
    
	@CreationTimestamp
    private Timestamp lastUsed;

	
	//@ToString을 쓰지 않았을 때 오버라이드 한다면
	
//    @Override
//    public String toString() {
//        return "RememberKey{" +
//                "series='" + series + '\'' +
//                ", username='" + username + '\'' +
//                ", token='" + token + '\'' +
//                ", lastUsed=" + lastUsed +
//                '}';
//    }
}

