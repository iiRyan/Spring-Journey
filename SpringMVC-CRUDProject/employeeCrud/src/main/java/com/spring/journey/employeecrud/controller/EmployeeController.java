
package com.spring.journey.employeecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.journey.employeecrud.entity.Employee;
import com.spring.journey.employeecrud.service.EmployeeService;

@Controller
// Base Mapping for URL Reest
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // since we have one constrouctor @Autowired is optional
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployee(Model theModel) {

        // get the employees from db
        List<Employee> thEmployees = employeeService.findAll();
        // add to the spring model
        theModel.addAttribute("employees", thEmployees);

        // redirect to the list-employees.html Page
        return "/employees/list-employees";
    }

    // Add new Employee
    @GetMapping("/showFormForAdd")
    public String addEmployee(Model theModel) {

        // create mopdel attribute to binde from data
        Employee thEmployee = new Employee();

        // Before you show the form, you must add a model attribute
        // thEmployee is a bean that will hold form data for the data binding
        theModel.addAttribute("employee", thEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee thEmployee) {

        employeeService.save(thEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);
        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);
        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteEmployee(theId);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}