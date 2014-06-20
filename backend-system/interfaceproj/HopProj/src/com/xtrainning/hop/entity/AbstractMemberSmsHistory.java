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
 * AbstractMemberSmsHistory entity provides the base persistence definition of the MemberSmsHistory entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberSmsHistory extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private String phoneNumber;
     private Integer type;
     private String content;
     private Timestamp createTime;
     private Integer status;
     private String vcode;

    // Constructors

    /** default constructor */
    public AbstractMemberSmsHistory() {
    }

	/** minimal constructor */
    public AbstractMemberSmsHistory(String phoneNumber, String content, Timestamp createTime, Integer status) {
        this.phoneNumber = phoneNumber;
        this.content = content;
        this.createTime = createTime;
        this.status = status;
    }
    
    /** full constructor */
    public AbstractMemberSmsHistory(Member member, String phoneNumber, Integer type, String content, Timestamp createTime, Integer status) {
        this.member = member;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.content = content;
        this.createTime = createTime;
        this.status = status;
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
    
    @Column(name="phone_number", nullable=false, length=20)

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Column(name="type")

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    @Column(name="content", nullable=false, length=400)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="status")

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name="vcode", nullable=false, length=6)
	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

}