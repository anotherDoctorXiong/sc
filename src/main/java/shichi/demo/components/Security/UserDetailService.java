package shichi.demo.components.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.TestMapper;
import shichi.demo.mapper.autoMapper.AdminMapper;
import shichi.demo.model.autoModel.Admin;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Admin admin = adminMapper.findById(id);
        if (admin == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", id));
        } else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(admin.getRole()));
            return new User(admin.getAdminId(), admin.getPassword(),authorities);
        }
    }

}