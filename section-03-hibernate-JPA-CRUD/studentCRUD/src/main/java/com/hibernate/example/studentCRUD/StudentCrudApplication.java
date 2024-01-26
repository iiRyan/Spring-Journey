package com.hibernate.example.studentCRUD;

import com.hibernate.example.studentCRUD.dao.StudentDAO;
import com.hibernate.example.studentCRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentCrudApplication {


	public static void main(String[] args) {
		SpringApplication.run(StudentCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//getAllStudents(studentDAO);
			//getStudentByLastName(studentDAO,"Salah");
			//updateStudent(studentDAO,1);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO, Integer id) {
		// retrieve student based on the id
		Student theStudent = studentDAO.findById(id);
		// change first name
		theStudent.setFirstName("Mohammed");
		// update the student
		studentDAO.update(theStudent);
		// display the updated student
		System.out.println("New Updated Student: "+ theStudent);
	}

	private void getStudentByLastName(StudentDAO studentDAO,String lastName) {
		// get a list of student.
		List<Student> studentList = studentDAO.findByLastName(lastName);
		// display list of students.
		for (Student student:studentList){
			System.out.println("Student Info: "+student);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		// get a list of students.
		List<Student> studentList = studentDAO.findAll();
		// display list of students.
		for (Student student:studentList){
			System.out.println("Student Info: "+student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// retrieve student based on the id
		System.out.println("Retrieving the student by id... ");
		Student myStudent = studentDAO.findById(2);
		// display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating the Student Object...");
		Student student = new Student("Abdallah","Khaled","abdallah@gmail.com");
		// Save the student object
		System.out.println("Saving the Student Object...");
		studentDAO.save(student);
		// display id of the saved student
		System.out.println("The Student Id is ==> "+ student.getId());
	}
}
