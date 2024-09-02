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

    // token filter
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(JwtTokenProvider.httpHeaderKey);
        if (token != null) {
            System.out.println("token ===> "+ BearerRemove(token));
            token = BearerRemove(token);
        }


        // 유효한 토큰인지 확인
        if (token != null && jwtTokenProvider.validateToken(token)) {

            // token을 통해서 user정보를 취득
            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            // SecurityContextHolder에 Authentication 객체를 저장한다.
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("유효한 토큰입니다.");
        }
        else {
            System.out.println("유효 하지 않은 토큰입니다.");
        }

        filterChain.doFilter(request, response);
    }

    // 토큰을 만들면 앞에 문자열이 추가된다. "Bearer" 를 제거해 주는 함수
    private String BearerRemove(String token) {
        return token.substring("Bearer ".length());
    }
}
