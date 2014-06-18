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
 * AbstractMemberSupportAnswer entity provides the base persistence definition of the MemberSupportAnswer entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberSupportAnswer extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Answer answer;
     private Integer status;


    // Constructors

    /** default constructor */
    public AbstractMemberSupportAnswer() {
    }

    
    /** full constructor */
    public AbstractMemberSupportAnswer(Member member, Answer answer, Integer status) {
        this.member = member;
        this.answer = answer;
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
        @JoinColumn(name="member_id", nullable=false)

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="answer_id", nullable=false)

    public Answer getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
   








}