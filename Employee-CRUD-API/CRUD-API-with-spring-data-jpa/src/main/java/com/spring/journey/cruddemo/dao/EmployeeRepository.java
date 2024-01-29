package com.spring.journey.cruddemo.dao;

import com.spring.journey.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // That's no need to write any code!
}
