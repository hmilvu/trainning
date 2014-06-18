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
 * AbstractMemberFollowQuestion entity provides the base persistence definition of the MemberFollowQuestion entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberFollowQuestion extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;


    // Constructors

    /** default constructor */
    public AbstractMemberFollowQuestion() {
    }

    
    /** full constructor */
    public AbstractMemberFollowQuestion(Member member, Question question) {
        this.member = member;
        this.question = question;
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
   








}