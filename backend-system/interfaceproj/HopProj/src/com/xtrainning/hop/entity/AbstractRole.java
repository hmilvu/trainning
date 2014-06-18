package com.xtrainning.hop.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractRole entity provides the base persistence definition of the Role entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractRole extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String description;
     private Integer status;
     private Set<SysUser> sysUsers = new HashSet<SysUser>(0);


    // Constructors

    /** default constructor */
    public AbstractRole() {
    }

	/** minimal constructor */
    public AbstractRole(String name, Integer status) {
        this.name = name;
        this.status = status;
    }
    
    /** full constructor */
    public AbstractRole(String name, String description, Integer status, Set<SysUser> sysUsers) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.sysUsers = sysUsers;
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
    
    @Column(name="name", unique=true, nullable=false, length=100)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="description", length=100)

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="role")

    public Set<SysUser> getSysUsers() {
        return this.sysUsers;
    }
    
    public void setSysUsers(Set<SysUser> sysUsers) {
        this.sysUsers = sysUsers;
    }
   








}