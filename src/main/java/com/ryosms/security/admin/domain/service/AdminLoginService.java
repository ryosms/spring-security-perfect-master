package com.ryosms.security.admin.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ryosms on 2016/12/24.
 */
@Component
public class AdminLoginService implements UserDetailsService {
    @Autowired
    private AdminAccountsRepository adminAccountsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(adminAccountsRepository.findOne(username))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}
