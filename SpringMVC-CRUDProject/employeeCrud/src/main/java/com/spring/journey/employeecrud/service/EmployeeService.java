package com.spring.journey.employeecrud.service;

import java.util.List;

import com.spring.journey.employeecrud.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee thEmployee);

    void deleteEmployee(int theId);

}
