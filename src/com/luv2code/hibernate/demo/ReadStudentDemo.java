package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to do stuffs

			// create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Dhanush", "Varanasi", "dhanush.rey@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			// find out the student's id:primary key
			System.out.println("Saved Student.Generated ID: " + tempStudent.getID());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve the student based on ID
			System.out.println("Getting student with id: " + tempStudent.getID());
			Student myStudent = session.get(Student.class, tempStudent.getID());

			System.out.println("Get Complete: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
