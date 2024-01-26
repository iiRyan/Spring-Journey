package com.hibernate.example.studentCRUD.dao;

import com.hibernate.example.studentCRUD.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 *Specialized annotation for repositories
 *Supports component Scanning
 *Translate JDBC exceptions
 */

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define field for entity manger
    private EntityManager entityManager;
    // Inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Transactional// Add @Transactional since we are performing an update "Storing" an object in the Database It will handle for you. Make sure it is imported from the springframework
    @Override
    public void save(Student student) {
    entityManager.persist(student);
    }

    // no Need to add @Transactional since we are doing a query.
    @Override
    public Student findById(Integer id) {
    return entityManager.find(Student.class,id);
    }
}
