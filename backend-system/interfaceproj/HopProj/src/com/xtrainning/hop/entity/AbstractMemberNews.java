package com.xtrainning.hop.entity;
// default package

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
 * AbstractMemberNews entity provides the base persistence definition of the MemberNews entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberNews extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;
     private Member anotherMember;
     private Answer answer;
     private Integer type;
     private Timestamp createTime;


    // Constructors

    /** default constructor */
    public AbstractMemberNews() {
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
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="another_member_id", nullable=false)

    public Member getAnotherMember() {
        return this.anotherMember;
    }
    
    public void setAnotherMember(Member anotherMember) {
        this.anotherMember = anotherMember;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="answer_id")

    public Answer getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(Answer answer) {
        this.answer = answer;
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
   








}