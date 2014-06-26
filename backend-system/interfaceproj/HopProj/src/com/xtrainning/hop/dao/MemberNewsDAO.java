package com.xtrainning.hop.dao;
// default package

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.MemberNews;

/**
 	* A data access object (DAO) providing persistence and search support for MemberNews entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .MemberNews
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class MemberNewsDAO extends BaseHibernateDAO  {
    private static final Logger log = LoggerFactory.getLogger(MemberNewsDAO.class);
	

    
    public void save(MemberNews transientInstance) {
        log.debug("saving MemberNews instance");
        try {
            getHibernateTemplate().save(transientInstance);
            getHibernateTemplate().flush();
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
}