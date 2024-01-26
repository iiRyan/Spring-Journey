package com.hibernate.example.studentCRUD.dao;

import com.hibernate.example.studentCRUD.entity.Student;

public interface StudentDAO {

    void save(Student student);

    /**************Clarification*******************
     The Method return Null when no record found
     and since int is a primitive type it doesn't
     have the ability to be null hence we are using
     an object that has the ability to be null.
     **********************************************/
    Student findById(Integer id);
}
