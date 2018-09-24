package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to do stuffs

			// int studentId = 2;

			// start a transaction
			session.beginTransaction();
//			System.out.println("Getting student with ID: " + studentId);
//
//			Student theStudent = session.get(Student.class, studentId);
//			System.out.println("Deleting student...");
//			session.delete(theStudent);

			// delete student id=3
			System.out.println("Deleting student with id =3");
			session.createQuery("delete from Student where ID=3").executeUpdate();
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
