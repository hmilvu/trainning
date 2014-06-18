package com.xtrainning.hop.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.AccessPrivilege;

/**
 	* A data access object (DAO) providing persistence and search support for AccessPrivilege entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.hop.entity.AccessPrivilege
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class AccessPrivilegeDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(AccessPrivilegeDAO.class);

	@SuppressWarnings("unchecked")
	public List<AccessPrivilege> getByAppKey(String appkey) {
		return getHibernateTemplate().find("from AccessPrivilege where appKey = ?", appkey);
	}
	

    
    
    
}