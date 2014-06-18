package com.xtrainning.hop.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
@Repository
public class BaseHibernateDAO extends HibernateDaoSupport{
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}