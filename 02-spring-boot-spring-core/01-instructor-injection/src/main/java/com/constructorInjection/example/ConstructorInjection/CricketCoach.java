package com.constructorInjection.example.ConstructorInjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("I'm Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice fast bowling for 15 minutes</h1>";
    }
}
