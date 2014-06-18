package com.xtrainning.hop.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.dao.ClientAppkeyDAO;
import com.xtrainning.hop.entity.ClientAppkey;
@Service
public class ClientAppkeyResolver {

	@Autowired private ClientAppkeyDAO clientAppkeyDao;
	
	public List<ClientAppkey> findAllClientAppkey() {
		return clientAppkeyDao.findAll();
	}

}
