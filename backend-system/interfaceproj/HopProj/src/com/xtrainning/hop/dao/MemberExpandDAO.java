package com.xtrainning.hop.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberExpand;

/**
 	* A data access object (DAO) providing persistence and search support for MemberExpand entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberExpand
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberExpandDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(MemberExpandDAO.class);
    public void save(MemberExpand transientInstance) {
        log.debug("saving MemberExpand instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public MemberExpand getByOpenuuid(final String openuuid) {
		return getHibernateTemplate().execute(new HibernateCallback<MemberExpand>() {
			@SuppressWarnings("unchecked")
			@Override
			public MemberExpand doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query q = session.createQuery("from MemberExpand where uuid = ?");
				q.setString(0, openuuid);
				List<MemberExpand> list = q.list();
				if(list.size() > 0){
					return list.get(0);
				}
				return null;
			}
		});
	}
}