package com.ryosms.security.user.domain.service;

import com.ryosms.security.user.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ryosms on 2016/12/25.
 */
@Repository
interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
