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
 * AbstractMemberWarning entity provides the base persistence definition of the MemberWarning entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberWarning extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private SysUser sysUser;
     private Question question;
     private Integer status;
     private Timestamp createTime;
     private Timestamp dealTime;


    // Constructors

    /** default constructor */
    public AbstractMemberWarning() {
    }

	/** minimal constructor */
    public AbstractMemberWarning(Member member, Question question, Integer status, Timestamp createTime, Timestamp dealTime) {
        this.member = member;
        this.question = question;
        this.status = status;
        this.createTime = createTime;
        this.dealTime = dealTime;
    }
    
    /** full constructor */
    public AbstractMemberWarning(Member member, SysUser sysUser, Question question, Integer status, Timestamp createTime, Timestamp dealTime) {
        this.member = member;
        this.sysUser = sysUser;
        this.question = question;
        this.status = status;
        this.createTime = createTime;
        this.dealTime = dealTime;
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
        @JoinColumn(name="member_id", nullable=false)

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="sys_user_id")

    public SysUser getSysUser() {
        return this.sysUser;
    }
    
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="question_id", nullable=false)

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="deal_time", nullable=false, length=19)

    public Timestamp getDealTime() {
        return this.dealTime;
    }
    
    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }
   








}