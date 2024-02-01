package com.spring.demo.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(Model theModel) {
        return "welcomePage";
    }
}
