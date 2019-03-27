package shichi.demo.components.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类，返回401
 * Author: JoeTao
 * createAt: 2018/9/20
 */
@Component
public class AuthFail implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException{
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(401);
        response.getWriter().print("auth fail");
    }

}