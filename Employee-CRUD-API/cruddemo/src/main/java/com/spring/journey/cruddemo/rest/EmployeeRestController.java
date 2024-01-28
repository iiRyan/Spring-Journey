package com.spring.journey.cruddemo.rest;

import com.spring.journey.cruddemo.dao.EmployeeDAO;
import com.spring.journey.cruddemo.entity.Employee;
import com.spring.journey.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}
