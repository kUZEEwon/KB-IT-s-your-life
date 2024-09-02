package mul.cam.e.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("LoginSuccessHandler onAuthenticationSuccess >> ");

        if(authentication.getName().equals("admin")) {
            request.getRequestDispatcher("/admin/page").forward(request, response);
        }
        else if(authentication.getName().equals("user")) {
            request.getRequestDispatcher("/user/page").forward(request, response);
        }
    }
}
