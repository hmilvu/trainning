package com.xtrainning.hop.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.common.Constants.SYS_SESSION_STATUS;
import com.xtrainning.hop.entity.SysSession;

/**
 * A data access object (DAO) providing persistence and search support for
 * SysSession entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.xtrainning.hop.entity.hop.entity.SysSession
 * @author MyEclipse Persistence Tools
 */
@Repository
public class SysSessionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SysSessionDAO.class);

	public void save(SysSession transientInstance) {
		log.debug("saving SysSession instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public SysSession getValidSessionBySessionId(final String sessionId) {
		return getHibernateTemplate().execute(new HibernateCallback<SysSession>() {
			@Override
			public SysSession doInHibernate(Session session)
					throws HibernateException {		
				Criteria cr = session.createCriteria(SysSession.class);
				cr.add(Restrictions.ne("status", SYS_SESSION_STATUS.INACTIVE.getValue()));
				cr.add(Restrictions.eq("sessionId", sessionId));
				cr.setMaxResults(1);
				return (SysSession) cr.uniqueResult();
			}
		});
	}

	public Integer invalidSessionBySessionId(final String sessionId) {
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException {
				Query query = session
						.createQuery("delete from SysSession where sessionId = ?");
				query.setParameter(0, sessionId);
				return query.executeUpdate();
			}
		});
	}
}