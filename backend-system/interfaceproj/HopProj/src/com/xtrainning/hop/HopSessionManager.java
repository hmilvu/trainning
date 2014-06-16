/**
 * 版权声明：中国电信号百信息服务有限公司 版权所有 违者必究 2013 
 * 日    期：137-17
 */
package com.xtrainning.hop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rop.session.Session;
import com.rop.session.SessionManager;
import com.xtrainning.hop.resolver.SysSessionResolver;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 张志鹏
 * @version 1.0
 */
public class HopSessionManager implements SessionManager{
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final Map<String, Session> sessionCache = new ConcurrentHashMap<String, Session>(128, 0.75f, 32);
    
    @Autowired private SysSessionResolver sessionResolver;

    @Override
    public void addSession(String sessionId, Session session) {
    	sessionCache.put(sessionId, session);
    }

    @Override
    public Session getSession(String sessionId) {
    	Session session = sessionCache.get(sessionId);
    	return session;
    	/*if(session != null){
    		return session;
    	} else {
	    	SysSession sysSession = sessionResolver.getValidSessionBySessionId(sessionId);
	    	if(sysSession == null){
	    		return null;
	    	} else {
	    		 Session tempSession = sysSession.toSession();
	    		 sessionCache.put(sessionId, tempSession);
	    		 return tempSession;
	    	}
    	}*/
    }

    @Override
    public void removeSession(String sessionId) {
    	sessionCache.remove(sessionId);
//    	sessionResolver.invalidSessionBySessionId(sessionId);
    }
}

