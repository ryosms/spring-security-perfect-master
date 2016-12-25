package com.ryosms.security.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ryosms on 2016/12/25.
 */
@Controller
public class UserController {

    @RequestMapping("/user/login")
    public String userLogin() {
        return "user/login";
    }

    @RequestMapping("/user/login/failure")
    public String userLoginFailure(@RequestParam("login_id") String loginId,
                                   Model model) {
        model.addAttribute("login_id", loginId);
        return "user/login";
    }

    @RequestMapping("/user/menu")
    public String userMenu() {
        return "user/menu";
    }

}
