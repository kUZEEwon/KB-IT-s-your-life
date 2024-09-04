package mul.cam.e.jwt;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // token filter -> 토큰 검사
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(JwtTokenProvider.httpHeaderKey);
        if (token != null) {
            System.out.println("token:" + BearerRemove(token));
            token = BearerRemove(token);
        }

        /// 토큰 검사
        // 만료된 토큰
        if(token != null && !jwtTokenProvider.validateToken(token)) {
            System.out.println("만료된 토큰입니다");

            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print("EXPIRED_TOKEN");
            return;     // return 하지 않으면 403 에러가 나온다
        }
        // 유효한 토큰
        else if(token != null && jwtTokenProvider.validateToken(token)) {
            System.out.println("유효한 토큰입니다");
            // 토큰을 통해서 유저 정보를 취득
            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            // SecurityContextHolder 에 Authentication 객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        else{
            System.out.println("유효하지 않은 토큰입니다");
        }

        filterChain.doFilter(request, response);
    }

    // 토큰을 만들면 앞에 문자열이 추가된다. "Bearer" 를 제거해 주는 함수
    private String BearerRemove(String token) {
        return token.substring("Bearer ".length());
    }
}



