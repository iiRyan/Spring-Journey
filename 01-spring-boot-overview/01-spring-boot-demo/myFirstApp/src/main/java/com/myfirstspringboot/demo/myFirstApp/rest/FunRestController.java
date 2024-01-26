package com.myfirstspringboot.demo.myFirstApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose a new endpoint ("/")
    @GetMapping("/")
    public String sayHello(){
        return "Hello Rayawdan!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
}
