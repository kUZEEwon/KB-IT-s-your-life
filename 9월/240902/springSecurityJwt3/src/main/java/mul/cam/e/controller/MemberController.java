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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    // token 발행
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // 로그인
    private final MemberService service;

    // 비번 암호화
    private final PasswordEncoder passwordEncoder;

    public MemberController(JwtTokenProvider jwtTokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, MemberService service, PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/idCheck")
    public String idCheck(String username) {
        log.info("MemberController.idCheck");
        log.info("username: {}", username);

        boolean find = service.idCheck(username);
        if (find) { // ID를 찾으면 아이디가 존재하므로 사용불가능
            return "NO";
        }
        return "YES";
    }

    @PostMapping("/regi")
    public String regi( SecurityUser user) { // 객체를 받을 땐 @RequestBody
        log.info("MemberController.regi");

        // 회원 가입 시에는 인코딩(암호화)해서 db추가
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        boolean isS = service.regi(user);

        if(!isS){
            return "NO";
        }
        return "YES";
    }

    @PostMapping("/login")
    public String login(SecurityUser dto) {
        log.info("MemberController.login");
        log.info("UserInfo: {}", dto);

        SecurityUser user = service.login(dto.getUsername());
        if(user == null || user.getPassword().equals("")){
            // 회원 정보가 없는 경우
            return "NO_USER";
        }

        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())){
            // 암호화 되어 있는 것을 뒤에다가 집어 넣기
            System.out.println("아이디나 패스워드가 틀렸습니다");
            return "WRONG_PASSWORD";
        }

        // LOGIN 성공
        // 토큰을 발행한다.

        // 1. login id/pw 로 Authentication 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());

        // 2. 실제 검증
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증정보를 기반으로 JWT 토큰을 생성
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.createToken(user.getUsername(), authentication.getAuthorities().stream().map(arg -> arg.getAuthority()).collect(Collectors.toList()));

        return token;     // <- token or ""

    }
}
