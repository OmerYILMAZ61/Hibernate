package com.ss.secim.islem;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ss.secim.entity.Parti;
import com.ss.secim.entity.Secmen;

public class DAO {

	SessionFactory sessionFactory;
	public DAO() {
		sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	//ekleme
	public void add(Object obj){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
	//seçmen listesi
	public List<Secmen> getSecmenList(){
		Session session = sessionFactory.openSession();
		List<Secmen > list = null;
		try {
			Criteria criteria = session.createCriteria(Secmen.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return list;
	}
	//sonuclar için
	public List<Parti> getPartiList(){
		Session session = sessionFactory.openSession();
		List<Parti > list = null;
		try {
			Criteria criteria = session.createCriteria(Parti.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return list;
	}
	//parti çekme
	public Parti getParti(int id){
		Session session = sessionFactory.openSession();
		Parti parti = null;
		try {
			parti = session.get(Parti.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return parti;
	}
	
	//güncelleme
	public void updateParti(Object obj){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			session.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if(tx != null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
}
