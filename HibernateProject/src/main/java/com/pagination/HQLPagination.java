package com.pagination;

import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tuthibernate.Student;

public class HQLPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Query<Student> query = s.createQuery("from Student", Student.class);

		// implimentintng pagination using hibernate
		query.setFirstResult(0);
		query.setMaxResults(2);

		List<Student> list = query.list();
		for (Student st : list) {
			System.out.println(st.getId() + " : " + st.getName() + " : " + st.getCity());
		}

		s.close();
		factory.close();
	}

}
