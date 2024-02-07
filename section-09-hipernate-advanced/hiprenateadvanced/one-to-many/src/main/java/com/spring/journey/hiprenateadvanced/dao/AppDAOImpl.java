package com.spring.journey.hiprenateadvanced.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.journey.hiprenateadvanced.entity.Course;
import com.spring.journey.hiprenateadvanced.entity.Instructor;
import com.spring.journey.hiprenateadvanced.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

    // Define field for entity manege

    // inject entity manager using constructor injection.

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theInt) {

        return entityManager.find(Instructor.class, theInt);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor theInstructor = findInstructorById(theId);

        // Delete theInstructor.
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return entityManager.find(InstructorDetail.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int theId) {

        // retrieve the InstructorDetails
        InstructorDetail theInstructorDetail = findInstructorDetailById(theId);

        // remove the associated object reference
        // break bi-directional link
        theInstructorDetail.getInstructor().setInstructorDetail(null);

        // Delete the theInstructorDetail
        entityManager.remove(theInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        // Create query
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> coursesList = query.getResultList();

        return coursesList;
    }

}
