package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberWarning;

/**
 	* A data access object (DAO) providing persistence and search support for MemberWarning entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberWarning
  * @author MyEclipse Persistence Tools 
 */

public class MemberWarningDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberWarningDAO.class);
	

    
    public void save(MemberWarning transientInstance) {
        log.debug("saving MemberWarning instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberWarning persistentInstance) {
        log.debug("deleting MemberWarning instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberWarning findById( java.lang.Long id) {
        log.debug("getting MemberWarning instance with id: " + id);
        try {
            MemberWarning instance = (MemberWarning) getSession()
                    .get("com.hop.entity.MemberWarning", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberWarning> findByExample(MemberWarning instance) {
        log.debug("finding MemberWarning instance by example");
        try {
            List<MemberWarning> results = (List<MemberWarning>) getSession()
                    .createCriteria("com.hop.entity.MemberWarning")
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
      log.debug("finding MemberWarning instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberWarning as model where model." 
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
		log.debug("finding all MemberWarning instances");
		try {
			String queryString = "from MemberWarning";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberWarning merge(MemberWarning detachedInstance) {
        log.debug("merging MemberWarning instance");
        try {
            MemberWarning result = (MemberWarning) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberWarning instance) {
        log.debug("attaching dirty MemberWarning instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberWarning instance) {
        log.debug("attaching clean MemberWarning instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}