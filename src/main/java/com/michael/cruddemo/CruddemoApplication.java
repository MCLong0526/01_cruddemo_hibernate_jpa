package com.michael.cruddemo;

import com.michael.cruddemo.dao.StudentDAO;
import com.michael.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			findAllStudents(studentDAO);
//			findByFirstName(studentDAO);
//			update(studentDAO);
//			updateTogether(studentDAO);
//			delete(studentDAO);
//			multiDelete(studentDAO);
		};
	}
	private void findByFirstName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByFirstName("John");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

//		theStudents.forEach(System.out::println);
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Doe", "daffy@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

		//get the student using the id
		Student newStudent = studentDAO.findById(tempStudent.getId());

		//display the student
		System.out.println("Found the student: " + newStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the multiple student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("John", "Doe", "john@gmail.com");
		Student tempStudent2 = new Student("Michael", "Doe", "michael@gmail.com");
		Student tempStudent3 = new Student("Kelly", "Doe", "kelly@gmail.com");

		//save the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		//display id of the saved student
		System.out.println("Saved students. Generated ids: " + tempStudent.getId() + ", " + tempStudent2.getId() + ", " + tempStudent3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void update(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		Student tempStudent = new Student();
		tempStudent.setId(1);

		Student myStudent = studentDAO.findById(tempStudent.getId());

		myStudent.setFirstName("Testing");
		myStudent.setLastName("Test");
		myStudent.setEmail("testEmail@gmail.com");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void updateTogether(StudentDAO studentDAO){
		Student tempStudent = new Student();
		tempStudent.setLastName("TogetherName");
		studentDAO.updateTogether(tempStudent);
	}

	private void delete(StudentDAO studentDAO){
		int theId = 3;
		studentDAO.delete(theId);
		System.out.println("Deleted student id: " + theId);
	}

	private void multiDelete(StudentDAO studentDAO){
		String theLastName = "TogetherName";
		studentDAO.multiDelete(theLastName);
	}

}
