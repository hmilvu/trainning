package com.xtrainning.hop.entity;

import java.sql.Timestamp;
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
 * AbstractTopic entity provides the base persistence definition of the Topic entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractTopic extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Integer status;
     private Timestamp createTime;
     private Integer followNum;
     private String typeCode;
     private Set<QuestionTopic> questionTopics = new HashSet<QuestionTopic>(0);
     private Set<MemberFollowTopic> memberFollowTopics = new HashSet<MemberFollowTopic>(0);


    // Constructors

    /** default constructor */
    public AbstractTopic() {
    }

	/** minimal constructor */
    public AbstractTopic(String name, Integer status, Timestamp createTime, Integer followNum) {
        this.name = name;
        this.status = status;
        this.createTime = createTime;
        this.followNum = followNum;
    }
    
    /** full constructor */
    public AbstractTopic(String name, Integer status, Timestamp createTime, Integer followNum, String typeCode, Set<QuestionTopic> questionTopics, Set<MemberFollowTopic> memberFollowTopics) {
        this.name = name;
        this.status = status;
        this.createTime = createTime;
        this.followNum = followNum;
        this.typeCode = typeCode;
        this.questionTopics = questionTopics;
        this.memberFollowTopics = memberFollowTopics;
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
    
    @Column(name="name", nullable=false, length=400)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    
    @Column(name="follow_num", nullable=false)

    public Integer getFollowNum() {
        return this.followNum;
    }
    
    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }
    
    @Column(name="type_code", length=6)

    public String getTypeCode() {
        return this.typeCode;
    }
    
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="topic")

    public Set<QuestionTopic> getQuestionTopics() {
        return this.questionTopics;
    }
    
    public void setQuestionTopics(Set<QuestionTopic> questionTopics) {
        this.questionTopics = questionTopics;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="topic")

    public Set<MemberFollowTopic> getMemberFollowTopics() {
        return this.memberFollowTopics;
    }
    
    public void setMemberFollowTopics(Set<MemberFollowTopic> memberFollowTopics) {
        this.memberFollowTopics = memberFollowTopics;
    }
   








}