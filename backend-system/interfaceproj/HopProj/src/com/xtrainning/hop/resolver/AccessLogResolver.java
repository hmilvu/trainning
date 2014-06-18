package com.xtrainning.hop.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.AccessLogDAO;
import com.xtrainning.hop.entity.AccessLog;

@Service
public class AccessLogResolver {

	@Autowired private AccessLogDAO accessLogDao;
	
	public void save(AccessLog accessLog) {
		accessLogDao.save(accessLog);
	}

}
