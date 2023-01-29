package com.states;

import javax.net.ssl.SSLContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tuthibernate.Certificate;
import com.tuthibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Hibernate Object States
		System.out.println("STARTED......");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating Student object
		Student student = new Student();
		student.setId(1414);
		student.setName("Pranay");
		student.setCity("Rajura");
		student.setCerti(new Certificate("java hibernate course", "2 months"));
		// student object is in:Transient state

		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(student);
		// student object is now in:Persistent state
		// for now this object is associated with both session and database

		// when in persistance state when value is change value gets changes
		 student.setName("jhon");

		tx.commit();
		// tx.commit(); ------this will make data visisble in database
		
		// In detached state---We keep the value in database but remove the value from Session.
		//for this  ss.close(); or ss.clear() can be done
		ss.close();
		//this student has now come to detached state therefore it won't update any value now
		student.setName("cena");
		System.out.println("cena will not go in db as session is is closed and can't be updated");
		//here we can see cena will be printedas it is still in session
		System.out.println(student);
		
		
		factory.close();
		System.out.println("DONE......");

		

	}

}
