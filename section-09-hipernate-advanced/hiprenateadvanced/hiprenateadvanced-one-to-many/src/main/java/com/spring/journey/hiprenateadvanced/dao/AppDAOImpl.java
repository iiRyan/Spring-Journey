package com.spring.journey.hiprenateadvanced.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.journey.hiprenateadvanced.entity.Instructor;
import com.spring.journey.hiprenateadvanced.entity.InstructorDetail;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

    // Define field for entity manege

    // inject entity manager using constructor injection.

    private EntityManager thEntityManager;

    public AppDAOImpl(EntityManager thEntityManager) {
        this.thEntityManager = thEntityManager;
    }

    @Transactional
    @Override
    public void save(Instructor theInstructor) {
        thEntityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theInt) {

        return thEntityManager.find(Instructor.class, theInt);
    }

    @Transactional
    @Override
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor theInstructor = findInstructorById(theId);

        // Delete theInstructor.
        thEntityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {

        return thEntityManager.find(InstructorDetail.class, theId);
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
        thEntityManager.remove(theInstructorDetail);
    }

}
