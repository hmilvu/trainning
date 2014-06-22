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
 * AbstractAnswer entity provides the base persistence definition of the Answer entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractAnswer extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;
     private String content;
     private Timestamp createTime;
     private Timestamp updateTime;
     private Integer supportNum = 0;
     private Set<MemberSupportAnswer> memberSupportAnswers = new HashSet<MemberSupportAnswer>(0);
     private Set<News> newses = new HashSet<News>(0);


    // Constructors

    /** default constructor */
    public AbstractAnswer() {
    }

	/** minimal constructor */
    public AbstractAnswer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum) {
        this.member = member;
        this.question = question;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.supportNum = supportNum;
    }
    
    /** full constructor */
    public AbstractAnswer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum, Set<MemberSupportAnswer> memberSupportAnswers, Set<News> newses) {
        this.member = member;
        this.question = question;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.supportNum = supportNum;
        this.memberSupportAnswers = memberSupportAnswers;
        this.newses = newses;
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
    
    @Column(name="content", nullable=false, length=4000)

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
    
    @Column(name="support_num", nullable=false)

    public Integer getSupportNum() {
        return this.supportNum;
    }
    
    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="answer")

    public Set<MemberSupportAnswer> getMemberSupportAnswers() {
        return this.memberSupportAnswers;
    }
    
    public void setMemberSupportAnswers(Set<MemberSupportAnswer> memberSupportAnswers) {
        this.memberSupportAnswers = memberSupportAnswers;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="answer")

    public Set<News> getNewses() {
        return this.newses;
    }
    
    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }
   








}