package com.constructorInjection.example.ConstructorInjection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RayanCoach implements Coach{

    public RayanCoach(){
        System.out.println("I'm Constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>I'm Your Coach!</h1>";
    }
}
