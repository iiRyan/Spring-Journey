package com.pringourney.restAPI.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    // Add code for the "/hello" endpoint.
    @GetMapping("/hello")
    public String sayHello(){
        return "<h1>Hello Rayan.</h1>";
    }
}
