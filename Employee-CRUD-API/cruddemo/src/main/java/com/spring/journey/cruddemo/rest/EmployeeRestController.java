package com.spring.journey.cruddemo.rest;

import com.spring.journey.cruddemo.dao.EmployeeDAO;
import com.spring.journey.cruddemo.entity.Employee;
import com.spring.journey.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{employeeId}")
    public Employee getEpmloyee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee Not Found! - "+ employeeId);
        }
        return theEmployee;
    }

    // Add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // Also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);
         Employee dbEmployee = employeeService.save(theEmployee);

         return dbEmployee;
    }

    // Add mapping for PUT / employee - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Add mapping for DELETE / employee - delete existing employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee thEmployee = employeeService.findById(employeeId);
        if(thEmployee == null){
            throw new RuntimeException("Employee Id not Found! - "+ employeeId);
        }
        employeeService.deleteEmployee(employeeId);

        return " Deleted Employee Id ==> " + employeeId;
    }

}
