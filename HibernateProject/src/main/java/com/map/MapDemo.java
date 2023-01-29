package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		System.out.println("MAP START>>>>");
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("what is java");

		// creating answer
		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswer("java is programmming language");
		ans1.setQuestion(q1);

		q1.setAnswer(ans1);

		// creating question
		Question q2 = new Question();
		q2.setQuestionId(1213);
		q2.setQuestion("what is ios");

		// creating answer
		Answer ans2 = new Answer();
		ans2.setAnswerId(344);
		ans2.setAnswer("ios is operating system");
		ans2.setQuestion(q2);
		q2.setAnswer(ans2);

		// session
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		// save
		ss.save(q1);
		ss.save(q2);
		ss.save(ans1);
		ss.save(ans2);

		// commit is used to get changes in physical database
		tx.commit();
		ss.close();
		factory.close();
		System.out.println("MAP DONE>>>>");
	}

}
