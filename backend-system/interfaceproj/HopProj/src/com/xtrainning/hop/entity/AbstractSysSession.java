package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractSysSession entity provides the base persistence definition of the SysSession entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractSysSession extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Timestamp lastAccessTime;
     private Integer status;
     private String sessionId;


    // Constructors

    /** default constructor */
    public AbstractSysSession() {
    }

	/** minimal constructor */
    public AbstractSysSession(Timestamp lastAccessTime, Integer status, String sessionId) {
        this.lastAccessTime = lastAccessTime;
        this.status = status;
        this.sessionId = sessionId;
    }
    
    /** full constructor */
    public AbstractSysSession(Member member, Timestamp lastAccessTime, Integer status, String sessionId) {
        this.member = member;
        this.lastAccessTime = lastAccessTime;
        this.status = status;
        this.sessionId = sessionId;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="member_id")

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    @Column(name="last_access_time", nullable=false, length=19)

    public Timestamp getLastAccessTime() {
        return this.lastAccessTime;
    }
    
    public void setLastAccessTime(Timestamp lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="session_id", unique=true, nullable=false, length=100)

    public String getSessionId() {
        return this.sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
   








}