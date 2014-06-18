package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.Question;

/**
 	* A data access object (DAO) providing persistence and search support for Question entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Question
  * @author MyEclipse Persistence Tools 
 */

public class QuestionDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(QuestionDAO.class);
	

    
    public void save(Question transientInstance) {
        log.debug("saving Question instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Question persistentInstance) {
        log.debug("deleting Question instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Question findById( java.lang.Long id) {
        log.debug("getting Question instance with id: " + id);
        try {
            Question instance = (Question) getSession()
                    .get("com.hop.entity.Question", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Question> findByExample(Question instance) {
        log.debug("finding Question instance by example");
        try {
            List<Question> results = (List<Question>) getSession()
                    .createCriteria("com.hop.entity.Question")
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
      log.debug("finding Question instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Question as model where model." 
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
		log.debug("finding all Question instances");
		try {
			String queryString = "from Question";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Question merge(Question detachedInstance) {
        log.debug("merging Question instance");
        try {
            Question result = (Question) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Question instance) {
        log.debug("attaching dirty Question instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Question instance) {
        log.debug("attaching clean Question instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}