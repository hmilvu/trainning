package com.xtrainning.hop.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.xtrainning.hop.entity.ClientAppkey;

/**
 	* A data access object (DAO) providing persistence and search support for ClientAppkey entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.xtrainning.hop.entity.hop.entity.ClientAppkey
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class ClientAppkeyDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(ClientAppkeyDAO.class);

	@SuppressWarnings("unchecked")
	public List<ClientAppkey> findAll() {
		return getHibernateTemplate().find("from ClientAppkey");
	}
}