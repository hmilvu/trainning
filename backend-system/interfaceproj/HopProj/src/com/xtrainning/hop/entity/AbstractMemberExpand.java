package com.xtrainning.hop.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractMemberExpand entity provides the base persistence definition of the MemberExpand entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberExpand extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private String uuid;
     private Integer osType;
     private String baiduUserId;
     private String baiduChannelId;
     private String appVersion;


    // Constructors

    /** default constructor */
    public AbstractMemberExpand() {
    }

	/** minimal constructor */
    public AbstractMemberExpand(Member member, String uuid, Integer osType, String appVersion) {
        this.member = member;
        this.uuid = uuid;
        this.osType = osType;
        this.appVersion = appVersion;
    }
    
    /** full constructor */
    public AbstractMemberExpand(Member member, String uuid, Integer osType, String baiduUserId, String baiduChannelId, String appVersion) {
        this.member = member;
        this.uuid = uuid;
        this.osType = osType;
        this.baiduUserId = baiduUserId;
        this.baiduChannelId = baiduChannelId;
        this.appVersion = appVersion;
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
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="member_id", nullable=false)
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    @Column(name="uuid", unique=true, nullable=false, length=100)

    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    @Column(name="os_type", nullable=false)

    public Integer getOsType() {
        return this.osType;
    }
    
    public void setOsType(Integer osType) {
        this.osType = osType;
    }
    
    @Column(name="baidu_user_id", length=100)

    public String getBaiduUserId() {
        return this.baiduUserId;
    }
    
    public void setBaiduUserId(String baiduUserId) {
        this.baiduUserId = baiduUserId;
    }
    
    @Column(name="baidu_channel_id", length=20)

    public String getBaiduChannelId() {
        return this.baiduChannelId;
    }
    
    public void setBaiduChannelId(String baiduChannelId) {
        this.baiduChannelId = baiduChannelId;
    }
    
    @Column(name="app_version", nullable=false, length=20)

    public String getAppVersion() {
        return this.appVersion;
    }
    
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
   








}