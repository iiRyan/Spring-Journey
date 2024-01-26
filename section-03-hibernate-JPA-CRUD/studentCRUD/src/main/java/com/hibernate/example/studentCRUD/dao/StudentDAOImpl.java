package com.hibernate.example.studentCRUD.dao;

import com.hibernate.example.studentCRUD.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAll() {
        // Create query                              NOTE That this is the Entity Name NOT The Table Name from Database.
         TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        //TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName",Student.class);
        // return query results.
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query                                                                              placeholder
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        // set query parameter.
        theQuery.setParameter("theData",lastName);
        // return query results.
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        // retrieve the student
       Student theStudent = entityManager.find(Student.class,id);
        // delete the student
        entityManager.remove(theStudent);
    }
}
