package com.ryosms.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ryosms on 2016/12/24.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String mainMenu() {
        return "menu";
    }

}
