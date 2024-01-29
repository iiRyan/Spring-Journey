package com.spring.journey.cruddemo.service;


import com.spring.journey.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteEmployee(int theId);


}
