package com.spring.journey.hiprenateadvanced;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

import com.spring.journey.hiprenateadvanced.dao.AppDAO;
import com.spring.journey.hiprenateadvanced.entity.Course;
import com.spring.journey.hiprenateadvanced.entity.Instructor;
import com.spring.journey.hiprenateadvanced.entity.InstructorDetail;

@SpringBootApplication
public class HiprenateadvancedApplication {

	private int theId = 1;
	private int courseId = 10;

	private AppDAO appDAO;

	public HiprenateadvancedApplication(AppDAO appDAO) {
		this.appDAO = appDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(HiprenateadvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			System.out.println("App is Running...");

			/* Instructor Methods */
			// createInstructor();
			// findInstructor(appDAO,theId);
			// deleteInstructor(appDAO,theId);

			/* InstructorDetails Methods */
			// findInstructor(appDAO, 1);
			// deleteInstructorDetail(appDAO, theId);

			/* Course Methods */
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses();
			findCoursesForInstructor();

		};
	}

	private void findCoursesForInstructor() {

		// Retrieve the Instructor.
		Instructor temInstructor = findInstructor(theId);
		// find courses associated with the instructor.
		List<Course> theCourseList = appDAO.findCoursesByInstructorId(theId);
		// associate the objects.
		temInstructor.setCourses(theCourseList);
		System.out.println("The Associated Courses: " + temInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses() {

		Instructor temInstructor = findInstructor(theId);
		System.out.println("The Associated Courses: " + temInstructor.getCourses());
		System.out.println("Done!");

	}

	private void createInstructorWithCourses() {

		// Create Instructor.
		Instructor tempInstructor = new Instructor("Fahad", "Saleh",
				"fahad@gmail.com");
		// create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "Football");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Creating the courses...");
		// Create Course
		Course dance = new Course("Learn Dancing with Shakira");
		Course math = new Course("Principal of Mathematical");
		Course since = new Course("Inner if Since");
		Course database = new Course("Database in Action");
		Course dataStructure = new Course("How to store your Data");

		// add courses to instructors
		tempInstructor.add(dance);
		tempInstructor.add(math);
		tempInstructor.add(since);
		tempInstructor.add(database);
		tempInstructor.add(dataStructure);

		// Saving to the database
		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("The Courses: " + tempInstructor.getCourses());
		// NOTE : this will ALSO Save the course
		// because of CascadeType.PERSIST
		appDAO.save(tempInstructor);
		System.out.println("DONE!");
	}

	private void findInstructorDetail(int theId) {

		// get the instructor details object
		InstructorDetail thInstructorDetail = appDAO.findInstructorDetailById(theId);
		// print the instructor detail
		System.out.println("thInstructorDetail: " + thInstructorDetail);
		// print the associated instructor
		System.out.println("The Associated instructor: " + thInstructorDetail.getInstructor());
	}

	private void deleteInstructor(int theId) {

		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("DONE!");
	}

	private Instructor findInstructor(int theId) {

		System.out.println("Finding instructor id: " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("The Instructor : " + theInstructor);
		System.out.println("The associated Instructor : " + theInstructor.getInstructorDetail());

		return theInstructor;
	}

	private void deleteInstructorDetail(AppDAO appDAO, int theId) {

		System.out.println("Deleting instructor detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("DONE!");
	}

	private void createInstructor() {

		// Create Instructor.
		Instructor tempInstructor = new Instructor("Ali", "Mumhood",
				"ali@gmail.com");
		// create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "Video Game");

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
