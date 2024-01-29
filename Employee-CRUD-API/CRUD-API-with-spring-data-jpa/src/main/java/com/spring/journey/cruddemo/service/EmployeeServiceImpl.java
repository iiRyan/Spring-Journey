package com.spring.journey.cruddemo.service;

import com.spring.journey.cruddemo.dao.EmployeeRepository;
import com.spring.journey.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

// Delegate the calls to the DAO
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // Inject employee dao (use constructor injection)
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeDAO) {
        employeeRepository = theEmployeeDAO;
    }

    @Override
    // Expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}
