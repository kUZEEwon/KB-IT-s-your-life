package mul.cam.e.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

    // Security 사용자 인증 -> Database 설정
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(">> loadUserByUsername");

        /*
        * username = user
        * password = 1111
        * {noop} = 암호화 하지 x
        * */

        // database 대용 (임시)
        if(username.equals("user"))
        {   // no operation == noop == 인코딩(암호화) 하지 않겠다
           return User.builder().username("user").password("{noop}1111").authorities("ROLE_USER").build();
        } else if(username.equals("admin")){
            return User.builder().username("admin").password("{noop}1234").authorities("ROLE_ADMIN").build();
        }

        return null;
    }
}
