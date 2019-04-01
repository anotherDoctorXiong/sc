package shichi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shichi.demo.components.Security.JwtUtils;
import shichi.demo.components.Security.UserDetailService;
import shichi.demo.mapper.autoMapper.AdminMapper;
import shichi.demo.model.autoModel.Admin;


@Service
public class AdminerService {
    private AuthenticationManager authenticationManager;
    private UserDetailService userDetailService;
    private JwtUtils jwtUtils;
    @Autowired
    private AdminMapper adminMapper;

    public AdminerService(AuthenticationManager authenticationManager, UserDetailService userDetailService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtils = jwtUtils;
    }


    public String login(String id, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, password));
        UserDetails userDetail=userDetailService.loadUserByUsername(id);
        System.out.println(userDetail.getAuthorities());
        String token=jwtUtils.generateToken(userDetail);
        return token;
    }


    public String register(Admin admin) {
        String id = admin.getAdminId();
        if (adminMapper.findById(id) != null) {
            return "id was exited";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = admin.getPassword();
        admin.setPassword(encoder.encode(rawPassword));
        adminMapper.insert(admin);
        return "success";
    }


    public String refreshToken(String oldToken) {
        String token = oldToken.substring("Bearer ".length());
        if (!jwtUtils.isTokenExpired(token)) {
            return jwtUtils.refreshToken(token);
        }
        return "error";
    }

}
