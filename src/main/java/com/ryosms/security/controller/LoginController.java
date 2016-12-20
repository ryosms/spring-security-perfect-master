package com.ryosms.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryosms on 2016/12/21.
 */
@Controller
public class LoginController {

    @RequestMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

}
