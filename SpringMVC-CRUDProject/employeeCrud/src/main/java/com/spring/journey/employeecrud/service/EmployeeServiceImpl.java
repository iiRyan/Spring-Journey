package com.spring.journey.employeecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.journey.employeecrud.dao.EmployeeRepository;
import com.spring.journey.employeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // inject EmployeeDAO
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee thEmployee = null;

        if (result.isPresent()) {
            thEmployee = result.get();
        } else {
            // we didn't finde the employee
            throw new RuntimeException("Did not finde employee 0d - " + theId);
        }

        return thEmployee;
    }

    @Override
    public Employee save(Employee thEmployee) {

        return employeeRepository.save(thEmployee);
    }

    @Override
    public void deleteEmployee(int theId) {

        employeeRepository.deleteById(theId);
    }

}
