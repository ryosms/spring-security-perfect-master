package com.ryosms.security.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryosms on 2016/12/21.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping("/admin/menu")
    public String adminMenu() {
        return "admin/menu";
    }
}
