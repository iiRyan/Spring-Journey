package com.constructorInjection.example.ConstructorInjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency.
    private Coach myCoach;
    private Coach theAnothermyCoach;

    // Define a constructor for dependency injection.
    public DemoController(
                            @Qualifier("rayanCoach") Coach theCoach
                            ,@Qualifier("rayanCoach") Coach theAnothermyCoach){
        myCoach = theCoach;
        this.theAnothermyCoach =theAnothermyCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public  String check(){
        return "<h1>Comparing beans: myCoach == antoherCoach," + (myCoach == theAnothermyCoach) + "</h1>";
    }
}
