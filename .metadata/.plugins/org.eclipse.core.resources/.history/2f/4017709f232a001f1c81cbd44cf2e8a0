package net.daum.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.daum.dao.MemberRepository;

@Service
public class TravleUserService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.memberRepo.findById(username)
                .filter(member -> member != null)
                .map(member -> new TravleSecurityUser(member, request))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
