package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();
		e1.setEid(34);
		e1.setName("Pranay");

		e2.setEid(35);
		e2.setName("Chaitanya");

		Projects p1 = new Projects();
		Projects p2 = new Projects();

		p1.setPid(1221);
		p1.setProjectName("libraray management");

		p2.setPid(1222);
		p2.setProjectName("gym management");

		List<Emp> empList = new ArrayList<Emp>();
		List<Projects> projList = new ArrayList<Projects>();

		empList.add(e1);
		empList.add(e2);

		projList.add(p1);
		projList.add(p2);
		
		
		e1.setProjects(projList);
		
		
		p1.setEmps(empList);
		
		
		
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(e1);
		ss.save(e2);
		ss.save(p1);
		ss.save(p2);
		
		
		
		tx.commit();
		ss.close();
		factory.close();
	}

}
