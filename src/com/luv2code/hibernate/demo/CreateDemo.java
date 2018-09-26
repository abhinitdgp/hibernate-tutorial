package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to do stuffs

			// create the objects
			System.out.println("Creating a new instructor object...");
//			Instructor tempInstructor = new Instructor("Abhishek", "Aggarwal", "abhi@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
//					"Love 2 code !!!");

			Instructor tempInstructor = new Instructor("Nishant", "Verma", "nisgyan@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/nishant", "Music");

			// Associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the instructor... " + tempInstructor);
			session.save(tempInstructor); // this will also save the detail object because of cascade

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
