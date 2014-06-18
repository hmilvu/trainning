package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberSmsHistory;

/**
 	* A data access object (DAO) providing persistence and search support for MemberSmsHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberSmsHistory
  * @author MyEclipse Persistence Tools 
 */

public class MemberSmsHistoryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberSmsHistoryDAO.class);
	

    
    public void save(MemberSmsHistory transientInstance) {
        log.debug("saving MemberSmsHistory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberSmsHistory persistentInstance) {
        log.debug("deleting MemberSmsHistory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberSmsHistory findById( java.lang.Long id) {
        log.debug("getting MemberSmsHistory instance with id: " + id);
        try {
            MemberSmsHistory instance = (MemberSmsHistory) getSession()
                    .get("com.hop.entity.MemberSmsHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberSmsHistory> findByExample(MemberSmsHistory instance) {
        log.debug("finding MemberSmsHistory instance by example");
        try {
            List<MemberSmsHistory> results = (List<MemberSmsHistory>) getSession()
                    .createCriteria("com.hop.entity.MemberSmsHistory")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding MemberSmsHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberSmsHistory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all MemberSmsHistory instances");
		try {
			String queryString = "from MemberSmsHistory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberSmsHistory merge(MemberSmsHistory detachedInstance) {
        log.debug("merging MemberSmsHistory instance");
        try {
            MemberSmsHistory result = (MemberSmsHistory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberSmsHistory instance) {
        log.debug("attaching dirty MemberSmsHistory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberSmsHistory instance) {
        log.debug("attaching clean MemberSmsHistory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}