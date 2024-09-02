package mul.cam.e.security;

import lombok.AllArgsConstructor;
import mul.cam.e.config.WebConfig;
import mul.cam.e.service.CustomAuthenticationProvider;
import mul.cam.e.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Import(WebConfig.class)
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final SecurityService service;

    private final AuthenticationFailureHandler customFailureHandler;

    // 회원가입 시에 암호화할 클래스
    @Bean
    public BCryptPasswordEncoder encoderPwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // filter
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .antMatchers("/user/**").hasRole("USER")
                        .antMatchers("/**").permitAll());

        // login form
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/loginPage")
                .loginProcessingUrl("/login")
                .successHandler(new LoginSuccessHandler())
                .failureHandler(customFailureHandler);

        // login 인증
        http.userDetailsService(service);

        // logout
        http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");

        // 접근되지 않은 경우
        http.exceptionHandling().accessDeniedPage("/access_denied_page");

        http.headers(headers ->
                headers.frameOptions(options ->
                        options.sameOrigin()
                )
        );

        return http.build();
    }

    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~ CustomAuthenticationProvider");
        return new CustomAuthenticationProvider(service);
    }
}














