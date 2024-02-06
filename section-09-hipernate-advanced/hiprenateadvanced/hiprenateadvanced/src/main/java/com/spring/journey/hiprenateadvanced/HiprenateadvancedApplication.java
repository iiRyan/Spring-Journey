package com.spring.journey.hiprenateadvanced;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.journey.hiprenateadvanced.dao.AppDAO;
import com.spring.journey.hiprenateadvanced.entity.Instructor;
import com.spring.journey.hiprenateadvanced.entity.InstructorDetail;

@SpringBootApplication
public class HiprenateadvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiprenateadvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			System.out.println("App is Running...");

			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		// Create Instructor.
		Instructor tempInstructor = new Instructor("Rayan", "Salah", "rayan@gmail.com");
		// create the instructor details

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "Programming");

		// asspciate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		/*
		 * save the instructor
		 * NOTE: this will ALSO save th details object
		 * because of Cascade.ALL
		 */
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("DONE!");
	}

}
