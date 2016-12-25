package com.ryosms.security.admin;

import com.ryosms.security.admin.domain.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by ryosms on 2016/12/24.
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AdminLoginService adminLoginService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/login/failure").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN");
        http.formLogin()
                .loginProcessingUrl("/admin/login")
                .failureForwardUrl("/admin/login/failure")
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin/menu")
                .usernameParameter("login_id")
                .passwordParameter("password")
                .permitAll();
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .logoutSuccessUrl("/admin/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminLoginService)
                .passwordEncoder(passwordEncoder());
    }
}
