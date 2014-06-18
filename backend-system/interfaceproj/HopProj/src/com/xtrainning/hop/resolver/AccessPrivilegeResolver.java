package com.xtrainning.hop.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.AccessPrivilegeDAO;
import com.xtrainning.hop.entity.AccessPrivilege;
@Service
public class AccessPrivilegeResolver {
	@Autowired AccessPrivilegeDAO accessPrivilegeDao;
	public List<AccessPrivilege> findClientPrivilege(String appkey) {
		return accessPrivilegeDao.getByAppKey(appkey);
	}

}
