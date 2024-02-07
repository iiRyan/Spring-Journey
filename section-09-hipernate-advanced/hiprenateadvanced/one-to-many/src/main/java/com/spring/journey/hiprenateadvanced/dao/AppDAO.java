package com.spring.journey.hiprenateadvanced.dao;

import java.util.List;

import com.spring.journey.hiprenateadvanced.entity.Course;
import com.spring.journey.hiprenateadvanced.entity.Instructor;
import com.spring.journey.hiprenateadvanced.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theInt);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

}
