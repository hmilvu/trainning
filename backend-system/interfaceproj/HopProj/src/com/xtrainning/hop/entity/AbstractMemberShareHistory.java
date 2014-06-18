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
 * AbstractMemberShareHistory entity provides the base persistence definition of the MemberShareHistory entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberShareHistory extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;
     private Integer targetWeb;
     private Timestamp createTime;
     private String content;


    // Constructors

    /** default constructor */
    public AbstractMemberShareHistory() {
    }

	/** minimal constructor */
    public AbstractMemberShareHistory(Member member, Question question, Integer targetWeb, Timestamp createTime) {
        this.member = member;
        this.question = question;
        this.targetWeb = targetWeb;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public AbstractMemberShareHistory(Member member, Question question, Integer targetWeb, Timestamp createTime, String content) {
        this.member = member;
        this.question = question;
        this.targetWeb = targetWeb;
        this.createTime = createTime;
        this.content = content;
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
        @JoinColumn(name="question_id", nullable=false)

    public Question getQuestion() {
        return this.question;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    @Column(name="target_web", nullable=false)

    public Integer getTargetWeb() {
        return this.targetWeb;
    }
    
    public void setTargetWeb(Integer targetWeb) {
        this.targetWeb = targetWeb;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="content", length=400)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
   








}