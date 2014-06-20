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

import com.xtrainning.hop.entity.Topic;

/**
 	* A data access object (DAO) providing persistence and search support for Topic entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Topic
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class TopicDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TopicDAO.class);
	

    
    public void save(Topic transientInstance) {
        log.debug("saving Topic instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

	public List<Long> filterIds(final List<Long> topicIdList) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Long>>() {
			@Override
			public List<Long> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session.createQuery("select distinct id from Topic where id in (:idList)");
				q.setParameterList("idList", topicIdList);
				return q.list();
			}
		});
	}
}