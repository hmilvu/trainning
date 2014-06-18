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
 * AbstractPushMessage entity provides the base persistence definition of the PushMessage entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractPushMessage extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private SysUser sysUser;
     private Integer iosType;
     private String baiduChannelId;
     private String name;
     private String description;
     private Timestamp createTime;
     private Integer type;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractPushMessage() {
    }

	/** minimal constructor */
    public AbstractPushMessage(Integer iosType, String baiduChannelId, String description, Timestamp createTime, Integer type, Integer status) {
        this.iosType = iosType;
        this.baiduChannelId = baiduChannelId;
        this.description = description;
        this.createTime = createTime;
        this.type = type;
        this.status = status;
    }
    
    /** full constructor */
    public AbstractPushMessage(Member member, SysUser sysUser, Integer iosType, String baiduChannelId, String name, String description, Timestamp createTime, Integer type, Integer status) {
        this.member = member;
        this.sysUser = sysUser;
        this.iosType = iosType;
        this.baiduChannelId = baiduChannelId;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.type = type;
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="sys_user_id")

    public SysUser getSysUser() {
        return this.sysUser;
    }
    
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
    
    @Column(name="ios_type", nullable=false)

    public Integer getIosType() {
        return this.iosType;
    }
    
    public void setIosType(Integer iosType) {
        this.iosType = iosType;
    }
    
    @Column(name="baidu_channel_id", nullable=false, length=100)

    public String getBaiduChannelId() {
        return this.baiduChannelId;
    }
    
    public void setBaiduChannelId(String baiduChannelId) {
        this.baiduChannelId = baiduChannelId;
    }
    
    @Column(name="name", length=100)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="description", nullable=false, length=200)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="type", nullable=false)

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}