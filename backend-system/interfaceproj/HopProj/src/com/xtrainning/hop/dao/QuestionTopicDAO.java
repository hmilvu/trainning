package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.QuestionTopic;

/**
 	* A data access object (DAO) providing persistence and search support for QuestionTopic entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.QuestionTopic
  * @author MyEclipse Persistence Tools 
 */

public class QuestionTopicDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(QuestionTopicDAO.class);
	

    
    public void save(QuestionTopic transientInstance) {
        log.debug("saving QuestionTopic instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(QuestionTopic persistentInstance) {
        log.debug("deleting QuestionTopic instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public QuestionTopic findById( java.lang.Long id) {
        log.debug("getting QuestionTopic instance with id: " + id);
        try {
            QuestionTopic instance = (QuestionTopic) getSession()
                    .get("com.hop.entity.QuestionTopic", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<QuestionTopic> findByExample(QuestionTopic instance) {
        log.debug("finding QuestionTopic instance by example");
        try {
            List<QuestionTopic> results = (List<QuestionTopic>) getSession()
                    .createCriteria("com.hop.entity.QuestionTopic")
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
      log.debug("finding QuestionTopic instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from QuestionTopic as model where model." 
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
		log.debug("finding all QuestionTopic instances");
		try {
			String queryString = "from QuestionTopic";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public QuestionTopic merge(QuestionTopic detachedInstance) {
        log.debug("merging QuestionTopic instance");
        try {
            QuestionTopic result = (QuestionTopic) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(QuestionTopic instance) {
        log.debug("attaching dirty QuestionTopic instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(QuestionTopic instance) {
        log.debug("attaching clean QuestionTopic instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}