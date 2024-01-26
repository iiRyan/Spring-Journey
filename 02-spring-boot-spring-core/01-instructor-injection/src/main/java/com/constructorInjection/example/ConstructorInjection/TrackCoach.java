package com.constructorInjection.example.ConstructorInjection;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("I'm Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout( ) {
        return "<h1>Push Up 5 sets</h1>";
    }
}
