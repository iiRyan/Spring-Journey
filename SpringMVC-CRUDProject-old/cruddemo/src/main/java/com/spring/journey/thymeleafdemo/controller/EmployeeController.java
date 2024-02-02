package com.spring.journey.thymeleafdemo.controller;

import com.spring.journey.thymeleafdemo.entity.Employee;
import com.spring.journey.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
// Base mapping for URL request
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Constructor injection and since only one construct , @Autowired is optional
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list" --> List of employees.
    @GetMapping("/list")
    public String listEmployeesS(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeService.findAll();
        // add the spring model
        theModel.addAttribute("employees", theEmployees);

        // return the name of the view

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // Create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-from";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {

        // save the employee
        employeeService.save(thEmployee);
        // use a redirect tp prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);
        // redirect to /employye/list
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model thModel) {

        // get the employee from service
        Employee theEmployee = employeeService.findById(theId);
        // set employee in the Model to repopulate the form
        thModel.addAttribute("employee", theEmployee);
        // send over to our form

        return "employees/employee-from";
    }


}
