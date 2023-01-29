package com.tuthibernate;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("START........");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("Pranay");
		s1.setCity("Rajura");
		Certificate c1 = new Certificate();
		c1.setCourse("android");
		c1.setDuration("2months");
		s1.setCerti(c1);

		Student s2 = new Student();
		s2.setId(2);
		s2.setName("Chaitanya");
		s2.setCity("Rajura");
		Certificate c2 = new Certificate();
		c2.setCourse("Spring");
		c2.setDuration("3months");
		s2.setCerti(c2);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		// save objects
		s.save(s1);
		s.save(s2);

		tx.commit();
		s.close();
		factory.close();
		System.out.println("DONE........");

	}

}
