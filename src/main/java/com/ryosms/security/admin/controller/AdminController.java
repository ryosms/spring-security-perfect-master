package com.ryosms.security.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ryosms on 2016/12/21.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping("/admin/login/failure")
    public String adminLoginFailure(@RequestParam("login_id") String loginId,
                                    Model model) {
        model.addAttribute("login_id", loginId);
        return "admin/login";
    }

    @RequestMapping("/admin/menu")
    public String adminMenu() {
        return "admin/menu";
    }
}
