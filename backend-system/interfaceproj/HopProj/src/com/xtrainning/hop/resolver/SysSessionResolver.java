package com.xtrainning.hop.resolver;

import org.springframework.stereotype.Service;

@Service
public class SysSessionResolver {
	/*@Autowired private SysSessionDAO sessionDao;

	public SysSession getValidSessionBySessionId(String sessionId) {
		return sessionDao.getValidSessionBySessionId(sessionId);
	}

	public void invalidSessionBySessionId(String sessionId) {
		sessionDao.invalidSessionBySessionId(sessionId);		
	}

	public SysSession buildSession(SysUser sysUser) {
		SysSession session = new SysSession();
		session.setLastAccessTime(new Timestamp(new Date().getTime()));
		session.setStatus(SYS_SESSION_STATUS.ACTIVE.getValue());
		session.setSysUser(sysUser);
		session.setSessionid(RopUtils.getUUID());
		sessionDao.save(session);
		return session;
	}

	public SysSession buildMemberSession(Member m) {
		SysSession session = new SysSession();
		session.setLastAccessTime(new Timestamp(new Date().getTime()));
		session.setStatus(SYS_SESSION_STATUS.ACTIVE.getValue());
		session.setMember(m);
		session.setSessionid(RopUtils.getUUID());
		sessionDao.save(session);
		return session;
	}*/
}
