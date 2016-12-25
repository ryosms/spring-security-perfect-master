package com.ryosms.security.admin.domain.service;

import com.ryosms.security.admin.domain.model.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ryosms on 2016/12/24.
 */
@Repository
interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {
}
