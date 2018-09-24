package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to do stuffs

			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent = new Student("Abhishek", "Aggarwal", "abhi@gmail.com");
			Student tempStudent1 = new Student("Aakash", "Kumar", "akki@gmail.com");
			Student tempStudent2 = new Student("Nishant", "Verma", "nisgyan@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}

	}

}
