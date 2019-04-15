package shichi.demo.components.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import shichi.demo.config.CorsFilter;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailService userDetailService;
    private AuthFilter authFilter;
    private AuthFail authFail;
    private AuthDenied authDenied;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CorsFilter corsFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public WebSecurityConfig(UserDetailService userDetailService, AuthFilter authFilter, AuthFail authFail, AuthDenied authDenied) {
        this.userDetailService = userDetailService;
        this.authFilter = authFilter;
        this.authFail = authFail;
        this.authDenied = authDenied;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().cacheControl();
        httpSecurity.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(corsFilter,UsernamePasswordAuthenticationFilter.class);
        httpSecurity.exceptionHandling()
                .authenticationEntryPoint(authFail)
                .accessDeniedHandler(authDenied);

    }

}
