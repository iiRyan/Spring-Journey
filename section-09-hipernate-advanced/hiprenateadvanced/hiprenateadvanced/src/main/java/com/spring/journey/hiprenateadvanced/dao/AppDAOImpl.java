package com.spring.journey.hiprenateadvanced.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.journey.hiprenateadvanced.entity.Instructor;

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

}
