package shichi.demo.components.Security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthDenied implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e)throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(403);
        response.getWriter().print("auth denied!");
    }
}
