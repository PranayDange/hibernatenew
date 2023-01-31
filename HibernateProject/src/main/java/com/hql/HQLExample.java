package com.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tuthibernate.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		// HQL SYNTAX
		String query = "from Student";
		// String query = "from Student where city=rajura";
		// String query = "from Student where city=:x";
		// aalius
		// String query = "from Student as s where s.city=:x and s.name=:n";
		Query q = s.createQuery(query);
		// q.setParameter("x", "lucknow");
		// q.setParameter("n", "peter");
		// single(unique)
		// multiple-list
		// q.uniqueResult();
		List<Student> list = q.list();
		for (Student d : list) {
			System.out.println(d.getName());
			System.out.println(d.getName() + ":" + d.getCerti().getCourse());
		}
		Transaction tx = s.beginTransaction();

		System.out.println("----------------------------------------------");
		// delete
		/*
		 * Query query2 = s.createQuery("delete from Student s where s.city=:c");
		 * query2.setParameter("c", "pune"); int r = query2.executeUpdate();
		 * System.out.println("DELETED:"); System.out.println(r);
		 */
		// updte
		Query query3 = s.createQuery("update Student set city =:c where name=:n ");

		query3.setParameter("c", "rajura");
		query3.setParameter("n", "mumbai");
		int r = query3.executeUpdate();
		System.out.println(r + "objects updated");

		tx.commit();
		s.close();
		factory.close();
	}

}
