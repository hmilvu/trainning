package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.ClientAppkey;

/**
 	* A data access object (DAO) providing persistence and search support for ClientAppkey entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.ClientAppkey
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class ClientAppkeyDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(ClientAppkeyDAO.class);

	@SuppressWarnings("unchecked")
	public List<ClientAppkey> findAll() {
		return getHibernateTemplate().find("from ClientAppkey");
	}

	public Integer getOsTypeByAppkey(final String appKey) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("select osType from ClientAppkey where appKey = ?");
				q.setString(0, appKey);
				q.setMaxResults(1);
				return (Integer) q.uniqueResult();
			}
		});
	}
}