package com.ryosms.security.user.domain.service;

import com.ryosms.security.user.domain.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by ryosms on 2016/12/25.
 */
@Component
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userAccountRepository.findOne(username))
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
    }

    public UserAccount save(UserAccount entity) {
        return userAccountRepository.save(entity);
    }
}
