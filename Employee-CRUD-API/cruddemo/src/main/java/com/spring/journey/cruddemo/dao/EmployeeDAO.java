package com.spring.journey.cruddemo.dao;

import com.spring.journey.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteEmployee(int TheId);
}
