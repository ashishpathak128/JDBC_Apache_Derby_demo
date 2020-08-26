package org.ashish.pack.dao;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatedaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}
	
	public int getCircleCount() {
		String hql = "select count(*) from Circle";
		Query query = getSessionfactory().openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
		
	}
	
	
}
