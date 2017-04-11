package com.ss.okul.islem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ss.okul.entitiy.Ogrenci;
import com.ss.okul.entitiy.Okul;

public class DOA {

	SessionFactory sessionFactory;

	public DOA() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void addOgrenci(Ogrenci ogrenci) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.beginTransaction();
			session.save(ogrenci);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}

	}

	public void addOkul(Okul okul) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			session.beginTransaction();
			session.save(okul);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		
	}

}
