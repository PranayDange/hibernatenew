package com.tuthibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!Project started.....");
		// hibernate maven
		// https://mvnrepository.com/artifact/org.hibernate/hibernate-core

		// mysql connector maven
		// https://mvnrepository.com/artifact/mysql/mysql-connector-java

		Configuration cfg = new Configuration();
		cfg.configure();

		// sessionfactory is an interface therefore we cannot create an object of it
		// therefore we need a class to make an object
		SessionFactory factory = cfg.buildSessionFactory();

		/*
		 * System.out.println(factory); System.out.println(factory.isClosed());
		 */

		Student student = new Student();
		Address ad = new Address();
		student.setId(102);
		student.setName("Chaitanya");
		student.setCity("Rajura");

		ad.setStreet("fc street");
		ad.setCity("Rajura");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(123.25);

		// reading image by using FileInputStream
		FileInputStream fis = new FileInputStream("src/main/java/image1.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		System.out.println(student);  

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		session.save(ad);
		// session.getTransaction().commit();
		tx.commit();

		session.close();
		System.out.println("Done.......");

	}
}
