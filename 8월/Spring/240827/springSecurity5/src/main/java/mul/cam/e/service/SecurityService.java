package mul.cam.e.service;

import mul.cam.e.dao.UserDao;
import mul.cam.e.model.CustomUserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SecurityService implements UserDetailsService {

    private final UserDao userDao;

    public SecurityService(UserDao userDao) {
        this.userDao = userDao;
    }

    // Security 사용자 인증 -> Database 설정
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("~ loadUserByUsername()");

        /*
            username = user
            password = 1111

         */
        // Database 대용(임시)
        /*
        if(username.equals("user")){    // no operation == noop == 인코딩(암호화)을 하지 않겠다
            return User.builder().username("user").password("{noop}1111").authorities("ROLE_USER").build();
        }
        else if(username.equals("admin")){
            return User.builder().username("admin").password("{noop}1234").authorities("ROLE_ADMIN").build();
        }
        */

        CustomUserDetails user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }
}











