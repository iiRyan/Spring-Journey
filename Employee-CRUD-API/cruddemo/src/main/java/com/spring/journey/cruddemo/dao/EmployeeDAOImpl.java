package com.spring.journey.cruddemo.dao;

import com.spring.journey.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // Define field for entityManager
    private EntityManager entityManager;

    // Set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
    this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {

        // Create Query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        // Execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        // return result
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // Get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        // If the id == 0 it will be inserted else it will update the given id
        Employee dbEmployee = entityManager.merge(theEmployee);
        //return employee
        return dbEmployee;
    }

    @Override
    public void deleteEmployee(int TheId) {

    }
}
