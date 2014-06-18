package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractSysUser entity provides the base persistence definition of the SysUser entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractSysUser extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Role role;
     private String userName;
     private Integer status;
     private String email;
     private String phoneNumber;
     private Timestamp createTime;
     private String password;
     private Set<Member> members = new HashSet<Member>(0);
     private Set<PushMessage> pushMessages = new HashSet<PushMessage>(0);
     private Set<MemberWarning> memberWarnings = new HashSet<MemberWarning>(0);


    // Constructors

    /** default constructor */
    public AbstractSysUser() {
    }

	/** minimal constructor */
    public AbstractSysUser(Role role, String userName, Integer status, String email, String phoneNumber, Timestamp createTime, String password) {
        this.role = role;
        this.userName = userName;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createTime = createTime;
        this.password = password;
    }
    
    /** full constructor */
    public AbstractSysUser(Role role, String userName, Integer status, String email, String phoneNumber, Timestamp createTime, String password, Set<Member> members, Set<PushMessage> pushMessages, Set<MemberWarning> memberWarnings) {
        this.role = role;
        this.userName = userName;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createTime = createTime;
        this.password = password;
        this.members = members;
        this.pushMessages = pushMessages;
        this.memberWarnings = memberWarnings;
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="role_id", nullable=false)

    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    @Column(name="user_name", unique=true, nullable=false, length=64)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="email", nullable=false, length=100)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="phone_number", nullable=false, length=20)

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="password", nullable=false, length=100)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sysUser")

    public Set<Member> getMembers() {
        return this.members;
    }
    
    public void setMembers(Set<Member> members) {
        this.members = members;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sysUser")

    public Set<PushMessage> getPushMessages() {
        return this.pushMessages;
    }
    
    public void setPushMessages(Set<PushMessage> pushMessages) {
        this.pushMessages = pushMessages;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="sysUser")

    public Set<MemberWarning> getMemberWarnings() {
        return this.memberWarnings;
    }
    
    public void setMemberWarnings(Set<MemberWarning> memberWarnings) {
        this.memberWarnings = memberWarnings;
    }
   








}