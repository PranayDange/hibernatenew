package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tuthibernate.Student;


public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //EhcacheRegionFactory

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();
		// first
		Student s1 = session1.get(Student.class, 7);
		System.out.println(s1);
		session1.close();

		Session session2 = factory.openSession();
		// second
		Student s2 = session2.get(Student.class, 7);
		System.out.println(s2);
		session2.close();

		//factory.close();

	}

}
