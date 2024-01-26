package com.hibernate.example.studentCRUD;

import com.hibernate.example.studentCRUD.dao.StudentDAO;
import com.hibernate.example.studentCRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
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
