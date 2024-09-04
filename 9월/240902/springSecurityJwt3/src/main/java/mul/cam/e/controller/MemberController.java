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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final MemberService service;

    private final PasswordEncoder passwordEncoder;

    public MemberController(JwtTokenProvider jwtTokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, MemberService service, PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/idCheck")
    public String idCheck(String username) {
        log.info("MemberController idCheck");
        log.info("username: {}", username);

        boolean find = service.idCheck(username);
        if (find) {
            return "NO";
        }
        return "YES";
    }

    @PostMapping("/regi")
    public String regi(SecurityUser user) {
        log.info("MemberController regi");
        log.info(user.toString());

        // 회원가입 시에는 인코딩(암호화)해서 DB에 추가한다
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean isS = service.regi(user);
        if (!isS) {
            return "NO";
        }
        return "YES";
    }

    @PostMapping("/login")
    public String login(SecurityUser dto) {
        log.info("MemberController login");
        log.info(dto.toString());

        SecurityUser user = service.login(dto.getUsername());
        log.info(user.toString());
        if (user == null || user.getUsername().equals("")) {    // 회원정보가 없음
            return "NO_USER";
        }

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return "LOGIN_FAIL";
        }


        // login이 되었을 경우
        // token을 발행한다
        // 1. login id/pw 로 Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        // 2. 실제 검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증정보를 기반으로 JWT 토큰을 생성
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.createToken(dto.getUsername(), authentication.getAuthorities().stream().map(arg -> arg.getAuthority()).collect(Collectors.toList()));

        return token;
    }

}








