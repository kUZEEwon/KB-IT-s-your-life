package mul.cam.e.security;

import lombok.AllArgsConstructor;
import mul.cam.e.config.WebConfig;
import mul.cam.e.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Import(WebConfig.class)
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    // WEBconfig가 호출되면 자동적으로 생성
    private final SecurityService service;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // filter
        http.csrf(csrf -> csrf.disable()) // csrf로 사용하지 않겠다!
                .authorizeRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .antMatchers("/admin/**").hasRole("ADMIN")  // ~> ROLE_ADMIN
                        .antMatchers("/user/**").hasRole("USER")    // ~> ROLE_USER
                        .antMatchers("/**").permitAll());//( 이것 외의 모든 경로를 모든 사람들이 접근 가능하다. )

        // login form
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/loginPage")
                .loginProcessingUrl("/login")
                .successHandler(new LoginSuccessHandler());

        // login 인증
        http.userDetailsService(service);

        // logout
        http.logout().logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/");

        http.headers(headers ->
                headers.frameOptions(options ->
                        options.sameOrigin()
                )
        );

        return http.build();
    }
}
