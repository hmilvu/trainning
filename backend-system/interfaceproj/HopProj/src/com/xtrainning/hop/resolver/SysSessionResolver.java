package com.xtrainning.hop.resolver;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rop.utils.RopUtils;
import com.xtrainning.hop.common.Constants.SYS_SESSION_STATUS;
import com.xtrainning.hop.dao.SysSessionDAO;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.SysSession;

@Service
public class SysSessionResolver {
	@Autowired private SysSessionDAO sessionDao;

	public SysSession getValidSessionBySessionId(String sessionId) {
		return sessionDao.getValidSessionBySessionId(sessionId);
	}

	public void invalidSessionBySessionId(String sessionId) {
		sessionDao.invalidSessionBySessionId(sessionId);		
	}

	public SysSession buildMemberSession(Long memberId) {
		SysSession session = new SysSession();
		session.setLastAccessTime(new Timestamp(new Date().getTime()));
		session.setStatus(SYS_SESSION_STATUS.ACTIVE.getValue());
		Member m = new Member();
		m.setId(memberId);
		session.setMember(m);
		session.setSessionId(RopUtils.getUUID());
		sessionDao.save(session);
		return session;
	}
}
