package net.daum.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import net.daum.vo.MemberVO;

@Setter
@Getter
public class TravleSecurityUser extends User {

    private static final String ROLE_PREFIX = "ROLE_";//권한을 ROLE_ 로 하는 것이 관례화. hasRole() 앞부분에도 자동으로 설정되어 있음.
    private MemberVO member;
    
    @Override
    public void eraseCredentials() {
        //  this.password = null; 
    	
    	//	기본으로 위 코드가 되어 있기 때문에, 오버라이딩해서 지워주면 컨트롤러에서도 비밀번호를 받을 수 있음.
    	//	하지만 보안에 좋지 않으니 이렇게 사용하지 말것.
    }
    
    public TravleSecurityUser(MemberVO member, HttpServletRequest request) {
        
        super(member.getMember_id(), member.getMember_pwd(), makeGrantedAuthority(member.getRole()));
        
        HttpSession session = request.getSession(); // 세션 객체 생성
        session.setAttribute("id", member.getMember_id());
        session.setAttribute("name", member.getMember_name());        
        session.setAttribute("auth", ROLE_PREFIX + member.getRole());
      
    }

    private static List<GrantedAuthority> makeGrantedAuthority(String role) {
        
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
        
        return list;
    }
}


