package com.tuthibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get and load
		System.out.println("start.......");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		// get
		Student student = (Student) session.get(Student.class, 102);
		System.out.println(student);

		/*
		 * session.load(Student.class, 103); System.out.println(student);
		 */
		Address ad = (Address) session.get(Address.class, 2);
		System.out.println(ad);

		session.close();
		factory.close();
		System.out.println("Done.......");
	}

}
