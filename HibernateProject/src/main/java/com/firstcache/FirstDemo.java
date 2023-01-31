package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tuthibernate.Student;

public class FirstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		// by default enabled
		Student student = session.get(Student.class, 7);
		System.out.println(student);
		System.out.println("working stundet");

		Student student2 = session.get(Student.class, 7);
		System.out.println(student2);

		System.out.println(session.contains(student));
		session.close();

	}

}
