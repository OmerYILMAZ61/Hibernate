package com.ss.telefone.dao;

import java.util.Date;
import java.util.Formatter;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ss.telefone.entity.Person;
import com.ss.telefone.entity.SorgulaEnitity;

public class DAO {

	SessionFactory sessionFactory;
	
	public DAO() {
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public void add(Object obj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null){
				tx.rollback();
			}
		
		}finally{
			session.close();
		}
	}
	
	public List<Person> listele(SorgulaEnitity sorgulaEnitity){
		Session session = sessionFactory.openSession();
		List<Person > list = null;
		try {
			Criteria criteria = session.createCriteria(Person.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			if(sorgulaEnitity.getAdSoyad()!=null && sorgulaEnitity.getAdSoyad().length()>0)
			criteria.add(Restrictions.ilike("adSoyad", sorgulaEnitity.getAdSoyad()));
			
			if(sorgulaEnitity.getBasTar()!=null)
			criteria.add(Restrictions.ge("gorusmeZamani",sorgulaEnitity.getBasTar()));
			
			if(sorgulaEnitity.getBitTar()!=null )
			criteria.add(Restrictions.le("gorusmeZamani", sorgulaEnitity.getBitTar()));
			
			if(sorgulaEnitity.getGorTip()!=null)
			criteria.add(Restrictions.ilike("gorusmeTipi", sorgulaEnitity.getGorTip()));
			
			
			list = criteria.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return list;
	}
	
	public void formatla(Date date){
		Formatter form = new Formatter();
		
		
		
	}

}
