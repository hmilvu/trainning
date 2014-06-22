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
 * AbstractComment entity provides the base persistence definition of the Comment entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractComment extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;
     private String content;
     private Timestamp createTime;
     private Timestamp updateTime;


    // Constructors

    /** default constructor */
    public AbstractComment() {
    }

    
    /** full constructor */
    public AbstractComment(Member member, String content, Timestamp createTime, Integer status, Timestamp updateTime) {
        this.member = member;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
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
    
    @Column(name="content", nullable=false, length=2000)

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    
    @Column(name="update_time", nullable=false, length=19)

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="question_id", nullable=false)
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}