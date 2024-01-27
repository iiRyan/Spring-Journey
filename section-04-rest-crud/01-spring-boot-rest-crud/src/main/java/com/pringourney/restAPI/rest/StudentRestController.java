package com.pringourney.restAPI.rest;

import com.pringourney.restAPI.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;


import java.util.*;



@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    // Define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();

        studentList.add(new Student("Rayan","Salah"));
        studentList.add(new Student("ALjohara","Khaled"));
        studentList.add(new Student("Abdullah","Olyan"));
        studentList.add(new Student("Faisal","Salah"));
    }

    // Define endpoint for("/students")

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // Check the studentId again list size
        if ( (studentId >= studentList.size()) || (studentId < 0) ){
            throw new StudentNotFoundException("Student id not found! - "+ studentId);
        }
        return studentList.get(studentId);
    }


}
