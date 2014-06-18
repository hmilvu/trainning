package com.xtrainning.hop.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.MemberExpand;

/**
 	* A data access object (DAO) providing persistence and search support for Member entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.Member
  * @author MyEclipse Persistence Tools 
 */

public class MemberDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
	

    
    public void save(Member transientInstance) {
        log.debug("saving Member instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    
    public Member findById( java.lang.Long id) {
        log.debug("getting Member instance with id: " + id);
        try {
            Member instance = (Member) getHibernateTemplate()
                    .get("com.hop.entity.Member", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

}