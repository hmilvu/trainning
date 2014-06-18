package com.xtrainning.hop.entity;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractAccessLog entity provides the base persistence definition of the AccessLog entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractAccessLog extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private String ip;
     private String method;
     private String appkey;
     private Integer type;
     private Timestamp createTime;
     private String message;


    // Constructors

    /** default constructor */
    public AbstractAccessLog() {
    }

    
    /** full constructor */
    public AbstractAccessLog(String ip, String method, String appkey, Integer type, Timestamp createTime, String message) {
        this.ip = ip;
        this.method = method;
        this.appkey = appkey;
        this.type = type;
        this.createTime = createTime;
        this.message = message;
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
    
    @Column(name="ip", nullable=false, length=20)

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    @Column(name="method", nullable=false, length=40)

    public String getMethod() {
        return this.method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    @Column(name="appkey", nullable=false, length=100)

    public String getAppkey() {
        return this.appkey;
    }
    
    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
    
    @Column(name="type", nullable=false)

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="message", nullable=false, length=4000)

    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
   








}