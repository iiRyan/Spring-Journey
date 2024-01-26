package com.constructorInjection.example.ConstructorInjection;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach(){

    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Today is Off Go Home!</h1>";
    }
}
