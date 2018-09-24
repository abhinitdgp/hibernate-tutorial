package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to do stuffs

			// start a transaction
			session.beginTransaction();

			// query the student
			List<Student> theStudents = session.createQuery("from Student").list();

			// display the student
			displayStudents(theStudents);

			// query student: last name='Aggarwal'
			theStudents = session.createQuery("from Student s where s.lastName='Aggarwal'").list();

			// display the students
			System.out.println("Students with last name Aggarwal");
			displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

	public static void displayStudents(List<Student> theStudents) {
		for (Student st : theStudents) {
			System.out.println(st);
		}
	}

}
