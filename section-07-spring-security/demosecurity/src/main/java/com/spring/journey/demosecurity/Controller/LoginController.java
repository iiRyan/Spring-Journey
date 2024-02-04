package com.spring.journey.demosecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "plain-login";
    }

    // add request mapping for / access-denied
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
