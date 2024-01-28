package com.spring.journey.cruddemo.service;

import com.spring.journey.cruddemo.dao.EmployeeDAO;
import com.spring.journey.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    // Inject employee dao (use constructor injection)
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    // Expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeDAO.findAll();
    }
}
