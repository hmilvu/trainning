package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberSupportAnswer;

/**
 	* A data access object (DAO) providing persistence and search support for MemberSupportAnswer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberSupportAnswer
  * @author MyEclipse Persistence Tools 
 */

public class MemberSupportAnswerDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberSupportAnswerDAO.class);
	

    
    public void save(MemberSupportAnswer transientInstance) {
        log.debug("saving MemberSupportAnswer instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberSupportAnswer persistentInstance) {
        log.debug("deleting MemberSupportAnswer instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberSupportAnswer findById( java.lang.Long id) {
        log.debug("getting MemberSupportAnswer instance with id: " + id);
        try {
            MemberSupportAnswer instance = (MemberSupportAnswer) getSession()
                    .get("com.hop.entity.MemberSupportAnswer", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberSupportAnswer> findByExample(MemberSupportAnswer instance) {
        log.debug("finding MemberSupportAnswer instance by example");
        try {
            List<MemberSupportAnswer> results = (List<MemberSupportAnswer>) getSession()
                    .createCriteria("com.hop.entity.MemberSupportAnswer")
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
      log.debug("finding MemberSupportAnswer instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberSupportAnswer as model where model." 
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
		log.debug("finding all MemberSupportAnswer instances");
		try {
			String queryString = "from MemberSupportAnswer";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberSupportAnswer merge(MemberSupportAnswer detachedInstance) {
        log.debug("merging MemberSupportAnswer instance");
        try {
            MemberSupportAnswer result = (MemberSupportAnswer) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberSupportAnswer instance) {
        log.debug("attaching dirty MemberSupportAnswer instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberSupportAnswer instance) {
        log.debug("attaching clean MemberSupportAnswer instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}