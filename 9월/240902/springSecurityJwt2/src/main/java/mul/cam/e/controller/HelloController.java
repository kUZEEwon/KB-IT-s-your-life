package mul.cam.e.controller;

import mul.cam.e.jwt.JwtTokenProvider;
import mul.cam.e.security.SecurityUser;
import mul.cam.e.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberService service;

    public HelloController(JwtTokenProvider jwtTokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, MemberService service) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.service = service;
    }

    @GetMapping("/home")
    public String home(Locale locale, Model model){
        log.info("HelloController home {}", locale);

        return "home";
    }


    @PostMapping("/test")
    public String test(){
        log.info("HelloController test {}");

        return "test success";
    }

    @PostMapping("/login")
    public String login(SecurityUser user){
        log.info("HelloController login");
        log.info(user.toString());

        SecurityUser mem = service.findByUsername(user.getUsername());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // login 실패
        if(!encoder.matches(user.getPassword(), mem.getPassword())){
            System.out.println("아이디나 패스워드가 틀렸습니다.");
            return "login Fail";
        }

        // login 성공
        // 1. login id/pw 로 Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        // 2. 실제 검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증정보를 기반으로 JWT 토큰을 생성
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.createToken(user.getUsername(), authentication.getAuthorities().stream().map(arg -> arg.getAuthority()).collect(Collectors.toList()));

        return token;     // <- token or ""
    }



}













