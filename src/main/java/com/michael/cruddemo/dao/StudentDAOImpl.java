package com.michael.cruddemo.dao;

import com.michael.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define the field for entitymanager
    private EntityManager entityManager;

    //inject entitymanager using constructor injection so we can use it
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String theFirstName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);

        theQuery.setParameter("theData", theFirstName);

        return theQuery.getResultList();
    }

}
