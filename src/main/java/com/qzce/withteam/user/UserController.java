package com.qzce.withteam.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/sign")
    public String signPage() {
        return "login/sign";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

}
