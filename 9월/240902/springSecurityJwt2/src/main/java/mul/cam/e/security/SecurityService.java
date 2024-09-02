package mul.cam.e.security;

import mul.cam.e.service.MemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SecurityService implements UserDetailsService {
    private final MemberService service;

    public SecurityService(MemberService service) {
        this.service = service;
    }


    // Security 사용자 인증 -> Database 설정
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("~ loadUserByUsername()");

        // DB로 접근 <- dto
        SecurityUser securityUser = service.findByUsername(username);


/*        SecurityUser securityUser = new SecurityUser();
        securityUser.setUsername("admin");
        securityUser.setPassword("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC");*/

        return securityUser;
    }
}











