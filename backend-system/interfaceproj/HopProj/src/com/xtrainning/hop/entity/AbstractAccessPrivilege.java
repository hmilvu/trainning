package com.xtrainning.hop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractAccessPrivilege entity provides the base persistence definition of the AccessPrivilege entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractAccessPrivilege extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String appKey;
     private String methodName;


    // Constructors

    /** default constructor */
    public AbstractAccessPrivilege() {
    }

    
    /** full constructor */
    public AbstractAccessPrivilege(String appKey, String methodName) {
        this.appKey = appKey;
        this.methodName = methodName;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="app_key", nullable=false, length=20)

    public String getAppKey() {
        return this.appKey;
    }
    
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    
    @Column(name="method_name", nullable=false, length=100)

    public String getMethodName() {
        return this.methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
   








}