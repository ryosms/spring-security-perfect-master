package com.ryosms.security.admin.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ryosms on 2016/12/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "admin_accounts", catalog = "spring_security")
public class AdminAccounts {
    @Id
    @Column(name = "login_id")
    String loginId;

    @Column(name = "password")
    String password;

    @Column(name = "admin_name")
    String adminName;
}
