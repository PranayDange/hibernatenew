package com.map;

import java.util.ArrayList;
import java.util.List;

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
		ans1.setAnswerId(601);
		ans1.setAnswer("java is programmming language");
		ans1.setQuestion(q1);

		Answer ans2 = new Answer();
		ans2.setAnswerId(602);
		ans2.setAnswer("java is statically typed language");
		ans2.setQuestion(q1);

		Answer ans3 = new Answer();
		ans3.setAnswerId(603);
		ans3.setAnswer("In java we are learning hibernate");
		ans3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);

		q1.setAnswers(list);

		/*
		 * // creating question Question q2 = new Question(); q2.setQuestionId(1213);
		 * q2.setQuestion("what is ios");
		 * 
		 * // creating answer Answer ans2 = new Answer(); ans2.setAnswerId(344);
		 * ans2.setAnswer("ios is operating system"); ans2.setQuestion(q2);
		 * q2.setAnswer(ans2);
		 */
		// session
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		// save
		/*
		 * ss.save(q1); ss.save(ans1); ss.save(ans2); ss.save(ans3);
		 */

		// commit is used to get changes in physical database
		Question q = (Question) ss.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		// System.out.println();
		for (Answer ans : q.getAnswers()) {
			System.out.println(ans.getAnswer());
		}
		tx.commit();

		// fetching
		/*
		 * Question newQ = ss.get(Question.class, 1212);
		 * System.out.println(newQ.getQuestion()); //
		 * System.out.println(newQ.getAnswer().getAnswer());
		 */
		ss.close();
		factory.close();
		System.out.println("MAP DONE>>>>");
	}

}
