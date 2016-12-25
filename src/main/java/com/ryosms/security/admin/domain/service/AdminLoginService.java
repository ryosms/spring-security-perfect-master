package com.ryosms.security.admin.domain.service;

import com.ryosms.security.admin.domain.model.AdminAccount;
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
    private AdminAccountRepository adminAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(adminAccountRepository.findOne(username))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }

    public AdminAccount save(AdminAccount entity) {
        return adminAccountRepository.save(entity);
    }
}
