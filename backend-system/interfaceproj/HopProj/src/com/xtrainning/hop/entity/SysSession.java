package com.xtrainning.hop.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.rop.session.Session;
import com.rop.session.SimpleSession;


/**
 * SysSession entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_session"
    ,catalog="xtraining_db"
)
public class SysSession extends AbstractSysSession implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public SysSession() {
    }

	/** minimal constructor */
    public SysSession(Timestamp lastAccessTime, Integer status, String sessionId) {
        super(lastAccessTime, status, sessionId);        
    }
    
    /** full constructor */
    public SysSession(Member member, Timestamp lastAccessTime, Integer status, String sessionId) {
        super(member, lastAccessTime, status, sessionId);        
    }

	public Session toSession() {
		SimpleSession session = new SimpleSession();
		session.setAttribute("id", getId());
		session.setAttribute("memberId", getMember().getId());
		session.setAttribute("sessionid", getSessionId());
		return session;
	}
   
}
