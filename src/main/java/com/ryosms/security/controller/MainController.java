package com.ryosms.security.controller;

import com.ryosms.security.admin.domain.model.AdminAccount;
import com.ryosms.security.admin.domain.service.AdminLoginService;
import com.ryosms.security.form.UserForm;
import com.ryosms.security.user.domain.model.UserAccount;
import com.ryosms.security.user.domain.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ryosms on 2016/12/24.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String mainMenu() {
        return "menu";
    }

    @Autowired
    private AdminLoginService adminLoginService;

    @Autowired
    private UserLoginService userLoginService;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping(value = "/demo/create", method = RequestMethod.GET)
    public String createForm(@ModelAttribute UserForm formData) {
        return "register";
    }

    @RequestMapping(value = "/demo/create", method = RequestMethod.POST, params = "admin")
    public String createAdming(@Validated UserForm formData,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        AdminAccount account = AdminAccount.builder()
                .loginId(formData.getLoginId())
                .password(passwordEncoder().encode(formData.getPassword()))
                .adminName(formData.getUserName())
                .build();
        adminLoginService.save(account);

        return "redirect:/demo/create";
    }

    @RequestMapping(value = "/demo/create", method = RequestMethod.POST, params = "user")
    public String createUser(@Validated UserForm formData,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        UserAccount account = UserAccount.builder()
                .loginId(formData.getLoginId())
                .password(passwordEncoder().encode(formData.getPassword()))
                .adminName(formData.getUserName())
                .build();
        userLoginService.save(account);

        return "redirect:/demo/create";
    }

}
