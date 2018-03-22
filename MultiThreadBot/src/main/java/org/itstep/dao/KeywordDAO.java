package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Keyword;
import org.itstep.util.HibernateUtil;

public class KeywordDAO {

	private Session session;
	
	public synchronized void save(Keyword key) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.getTransaction().begin();
		
		session.save(key);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	public synchronized List<Keyword> getAll() {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		session.getTransaction().begin();
		
		String sql = "SELECT * FROM keywords";
		
		Query query = session.createNativeQuery(sql, Keyword.class);
		
		List<Keyword> result = query.getResultList();
				
		session.getTransaction().commit();
		
		session.close();
		
		return result;
	}
}