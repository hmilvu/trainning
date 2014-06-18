package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberShareHistory;

/**
 	* A data access object (DAO) providing persistence and search support for MemberShareHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberShareHistory
  * @author MyEclipse Persistence Tools 
 */

public class MemberShareHistoryDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberShareHistoryDAO.class);
	

    
    public void save(MemberShareHistory transientInstance) {
        log.debug("saving MemberShareHistory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberShareHistory persistentInstance) {
        log.debug("deleting MemberShareHistory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberShareHistory findById( java.lang.Long id) {
        log.debug("getting MemberShareHistory instance with id: " + id);
        try {
            MemberShareHistory instance = (MemberShareHistory) getSession()
                    .get("com.hop.entity.MemberShareHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberShareHistory> findByExample(MemberShareHistory instance) {
        log.debug("finding MemberShareHistory instance by example");
        try {
            List<MemberShareHistory> results = (List<MemberShareHistory>) getSession()
                    .createCriteria("com.hop.entity.MemberShareHistory")
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
      log.debug("finding MemberShareHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberShareHistory as model where model." 
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
		log.debug("finding all MemberShareHistory instances");
		try {
			String queryString = "from MemberShareHistory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberShareHistory merge(MemberShareHistory detachedInstance) {
        log.debug("merging MemberShareHistory instance");
        try {
            MemberShareHistory result = (MemberShareHistory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberShareHistory instance) {
        log.debug("attaching dirty MemberShareHistory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberShareHistory instance) {
        log.debug("attaching clean MemberShareHistory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}