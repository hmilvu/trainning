package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.Topic;

/**
 	* A data access object (DAO) providing persistence and search support for Topic entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Topic
  * @author MyEclipse Persistence Tools 
 */

public class TopicDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TopicDAO.class);
	

    
    public void save(Topic transientInstance) {
        log.debug("saving Topic instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Topic persistentInstance) {
        log.debug("deleting Topic instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Topic findById( java.lang.Long id) {
        log.debug("getting Topic instance with id: " + id);
        try {
            Topic instance = (Topic) getSession()
                    .get("com.hop.entity.Topic", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Topic> findByExample(Topic instance) {
        log.debug("finding Topic instance by example");
        try {
            List<Topic> results = (List<Topic>) getSession()
                    .createCriteria("com.hop.entity.Topic")
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
      log.debug("finding Topic instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Topic as model where model." 
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
		log.debug("finding all Topic instances");
		try {
			String queryString = "from Topic";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Topic merge(Topic detachedInstance) {
        log.debug("merging Topic instance");
        try {
            Topic result = (Topic) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Topic instance) {
        log.debug("attaching dirty Topic instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Topic instance) {
        log.debug("attaching clean Topic instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}