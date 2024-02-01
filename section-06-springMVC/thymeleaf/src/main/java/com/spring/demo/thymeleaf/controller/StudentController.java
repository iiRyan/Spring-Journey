package com.spring.demo.thymeleaf.controller;

import com.spring.demo.thymeleaf.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // add an initbinder ... to convert trim input string
    // remove leading trailing whitespace
    // resolve issue form our validation

    // This method will be called for every web request coming into our controller.
    @InitBinder
    public void iniBinder(WebDataBinder dataBinder){

        // StringTrimmerEditor Remove whitespace - leading and trailing."Ëxtra whitespace"
        // when pass true - means trim empty string to null(convert the whitespace null).
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    // from the properties that you defined.
    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // Create new student Object
        Student thStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student", thStudent);
        // add th elist of countries to the model

        theModel.addAttribute("countries", countries);
        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult) {

        System.out.println("Last Name: |" + theStudent.getLastName() + "|");
        if (bindingResult.hasErrors()) {
            return "student-form";
        } else {
            return "student-confirmation";
        }

    }

}
