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

	private int theId = 14;

	public static void main(String[] args) {
		SpringApplication.run(HiprenateadvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			System.out.println("App is Running...");

			// createInstructor(appDAO, theId);
			// findInstructor(appDAO,theId);
			// deleteInstructor(appDAO,theId);

			// findInstructor(appDAO, theId);
			deleteInstructorDetail(appDAO, theId);

		};
	}

	private void findInstructorDetail(AppDAO appDAO, int theId) {

		// get the instructor details object
		InstructorDetail thInstructorDetail = appDAO.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println("thInstructorDetail: " + thInstructorDetail);
		// print the associated instructor
		System.out.println("The Associated instructor: " + thInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO, int theId) {

		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!");
	}

	private void findInstructor(AppDAO appDAO, int theId) {

		System.out.println("Finding instructor id: " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("The Instructor : " + theInstructor);
		System.out.println("The associated Instructor : " + theInstructor.getInstructorDetail());

	}

	private void deleteInstructorDetail(AppDAO appDAO, int theId) {

		System.out.println("Deleting instructor detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("DONE!");
	}

	private void createInstructor(AppDAO appDAO, int theId) {

		// Create Instructor.
		Instructor tempInstructor = new Instructor("Faisal", "khalid",
				"Faisal@gmail.com");
		// create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Football");

		// associate the objects

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
