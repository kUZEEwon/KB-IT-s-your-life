package mul.cam.e.security;

import lombok.AllArgsConstructor;
import mul.cam.e.config.WebConfig;
import mul.cam.e.jwt.JwtTokenFilter;
import mul.cam.e.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.stream.Collectors;

@Import(WebConfig.class)
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final SecurityService service;
    private final JwtTokenFilter jwtTokenFilter;        // 토큰 검사용
    private final JwtTokenProvider jwtTokenProvider;    // 토큰 발급용

    // 회원가입 시에 암호화할 클래스
    @Bean
    public BCryptPasswordEncoder encoderPwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1.권한 filter
        http.csrf(csrf -> csrf.disable())
                .authorizeRequests(authorizeHttpRequests -> authorizeHttpRequests
                        //      .antMatchers("/admin/**").hasRole("ADMIN")
                        //      .antMatchers("/user/**").hasRole("USER")
                        .antMatchers("/test").authenticated()   // (토큰)증명
                        .antMatchers("/home").permitAll() );   // (무조건)허용

        // 2. 세션을 사용하지 않음
        http.sessionManagement((sessionManagement)
                ->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS) );

        // 3. JWT 필터를 사용여부 설정
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 4. login form
        http.formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((request, response, auth) -> {
                    // login success
                    String ip = request.getRemoteAddr();
                    String user_id = auth.getName();

                    // JWT token 발급
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("Content-Type", "application/download; UTF-8");
                    String token = jwtTokenProvider.createToken(user_id, auth.getAuthorities().stream().map(arg -> arg.getAuthority()).collect(Collectors.toList()));

                    // 성공하면 여기서 생성된 토큰 값이 파일로 저장됨을 볼 수 있다
                    response.getWriter().write("{\"result\" : \"" + token + "\" }");
                })
                .failureHandler((request, response, exception) -> {
                    // login fail
                    // 처음으로
                    response.sendRedirect("/");
                });

        // 5. csrf 설정을 off 합니다
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}














