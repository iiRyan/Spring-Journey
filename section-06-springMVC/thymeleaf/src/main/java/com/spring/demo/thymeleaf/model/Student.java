package com.spring.demo.thymeleaf.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName;
    private String country;

    public Student() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
