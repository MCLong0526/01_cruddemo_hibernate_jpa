package com.michael.cruddemo.dao;

import com.michael.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int theId);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);
}
