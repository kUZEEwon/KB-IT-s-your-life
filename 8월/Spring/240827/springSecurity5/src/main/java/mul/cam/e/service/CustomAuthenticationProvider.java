package mul.cam.e.service;

import lombok.AllArgsConstructor;
import mul.cam.e.model.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService service;

    public CustomAuthenticationProvider(UserDetailsService service) {
        this.service = service;
    }

    // username 와 password 를 비교
    @SuppressWarnings("unchecked")
    @Override // 인증함수
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();   // username
        String password = (String) authentication.getCredentials(); // password

        System.out.println("CustomAuthenticationProvider authenticate ::: 1");
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        System.out.println("CustomAuthenticationProvider authenticate ::: 2");
        CustomUserDetails user = (CustomUserDetails) service.loadUserByUsername(username);
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)user.getAuthorities();

        System.out.println("CustomAuthenticationProvider authenticate ::: 3");
        if(!matchPassword(password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
        if(!user.isEnabled()){
            throw new BadCredentialsException(username);
        }
        System.out.println("CustomAuthenticationProvider authenticate ::: 4");

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }
}
