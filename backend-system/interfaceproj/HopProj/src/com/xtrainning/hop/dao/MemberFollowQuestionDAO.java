package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.MemberFollowQuestion;

/**
 	* A data access object (DAO) providing persistence and search support for MemberFollowQuestion entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.MemberFollowQuestion
  * @author MyEclipse Persistence Tools 
 */

public class MemberFollowQuestionDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberFollowQuestionDAO.class);
	

    
    public void save(MemberFollowQuestion transientInstance) {
        log.debug("saving MemberFollowQuestion instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(MemberFollowQuestion persistentInstance) {
        log.debug("deleting MemberFollowQuestion instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberFollowQuestion findById( java.lang.Long id) {
        log.debug("getting MemberFollowQuestion instance with id: " + id);
        try {
            MemberFollowQuestion instance = (MemberFollowQuestion) getSession()
                    .get("com.hop.entity.MemberFollowQuestion", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<MemberFollowQuestion> findByExample(MemberFollowQuestion instance) {
        log.debug("finding MemberFollowQuestion instance by example");
        try {
            List<MemberFollowQuestion> results = (List<MemberFollowQuestion>) getSession()
                    .createCriteria("com.hop.entity.MemberFollowQuestion")
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
      log.debug("finding MemberFollowQuestion instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from MemberFollowQuestion as model where model." 
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
		log.debug("finding all MemberFollowQuestion instances");
		try {
			String queryString = "from MemberFollowQuestion";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public MemberFollowQuestion merge(MemberFollowQuestion detachedInstance) {
        log.debug("merging MemberFollowQuestion instance");
        try {
            MemberFollowQuestion result = (MemberFollowQuestion) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(MemberFollowQuestion instance) {
        log.debug("attaching dirty MemberFollowQuestion instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberFollowQuestion instance) {
        log.debug("attaching clean MemberFollowQuestion instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}