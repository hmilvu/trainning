package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberFollowTopic;

/**
 	* A data access object (DAO) providing persistence and search support for MemberFollowTopic entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberFollowTopic
  * @author MyEclipse Persistence Tools 
 */

public class MemberFollowTopicDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberFollowTopicDAO.class);
	

    
    public void save(MemberFollowTopic transientInstance) {
        log.debug("saving MemberFollowTopic instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberFollowTopic persistentInstance) {
        log.debug("deleting MemberFollowTopic instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberFollowTopic findById( java.lang.Long id) {
        log.debug("getting MemberFollowTopic instance with id: " + id);
        try {
            MemberFollowTopic instance = (MemberFollowTopic) getSession()
                    .get("com.hop.entity.MemberFollowTopic", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberFollowTopic> findByExample(MemberFollowTopic instance) {
        log.debug("finding MemberFollowTopic instance by example");
        try {
            List<MemberFollowTopic> results = (List<MemberFollowTopic>) getSession()
                    .createCriteria("com.hop.entity.MemberFollowTopic")
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
      log.debug("finding MemberFollowTopic instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberFollowTopic as model where model." 
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
		log.debug("finding all MemberFollowTopic instances");
		try {
			String queryString = "from MemberFollowTopic";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberFollowTopic merge(MemberFollowTopic detachedInstance) {
        log.debug("merging MemberFollowTopic instance");
        try {
            MemberFollowTopic result = (MemberFollowTopic) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberFollowTopic instance) {
        log.debug("attaching dirty MemberFollowTopic instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberFollowTopic instance) {
        log.debug("attaching clean MemberFollowTopic instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}