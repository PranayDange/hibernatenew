package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class Cascadeexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(790);
		q1.setQuestion("what is swing framework...");
		Answer a1 = new Answer(126, "It is a framework");
		Answer a2 = new Answer(127, "It is more useful ");
		Answer a3 = new Answer(128, "plz use it ");

		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);
		Transaction tx = session.beginTransaction();
		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);

		tx.commit();
		session.close();
		factory.close();
	}

}
