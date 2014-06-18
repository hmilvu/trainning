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
 * AbstractMemberFollowTopic entity provides the base persistence definition of the MemberFollowTopic entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMemberFollowTopic extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Topic topic;
     private Member member;


    // Constructors

    /** default constructor */
    public AbstractMemberFollowTopic() {
    }

    
    /** full constructor */
    public AbstractMemberFollowTopic(Topic topic, Member member) {
        this.topic = topic;
        this.member = member;
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
        @JoinColumn(name="topic_id", nullable=false)

    public Topic getTopic() {
        return this.topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="member_id", nullable=false)

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
   








}