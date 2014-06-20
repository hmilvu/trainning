package com.xtrainning.hop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractClientAppkey entity provides the base persistence definition of the ClientAppkey entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractClientAppkey extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String appKey;
     private String secretKey;
     private Integer status;
     private Integer osType;

    // Constructors

    /** default constructor */
    public AbstractClientAppkey() {
    }

    
    /** full constructor */
    public AbstractClientAppkey(String appKey, String secretKey, Integer status) {
        this.appKey = appKey;
        this.secretKey = secretKey;
        this.status = status;
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
    
    @Column(name="app_key", unique=true, nullable=false, length=50)

    public String getAppKey() {
        return this.appKey;
    }
    
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
    
    @Column(name="secret_key", unique=true, nullable=false, length=100)

    public String getSecretKey() {
        return this.secretKey;
    }
    
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="os_type", nullable=false)
	public Integer getOsType() {
		return osType;
	}


	public void setOsType(Integer osType) {
		this.osType = osType;
	}
   

}