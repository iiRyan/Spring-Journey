package com.spring.journey.thymeleafdemo.dao;

import com.spring.journey.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // add a method sort by last name

    public List<Employee> findAllByOrderByLastNameAsc();
}
