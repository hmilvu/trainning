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
 * AbstractQuestion entity provides the base persistence definition of the Question entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractQuestion extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private String name;
     private String description;
     private Integer status;
     private Timestamp createTime;
     private Integer followNum;
     private Integer commentCount;
     private Set<Answer> answers = new HashSet<Answer>(0);
     private Set<MemberWarning> memberWarnings = new HashSet<MemberWarning>(0);
     private Set<MemberFollowQuestion> memberFollowQuestions = new HashSet<MemberFollowQuestion>(0);
     private Set<QuestionTopic> questionTopics = new HashSet<QuestionTopic>(0);
     private Set<News> newses = new HashSet<News>(0);
     private Set<MemberShareHistory> memberShareHistories = new HashSet<MemberShareHistory>(0);


    // Constructors

    /** default constructor */
    public AbstractQuestion() {
    }

	/** minimal constructor */
    public AbstractQuestion(Member member, String name, Integer status, Timestamp createTime, Integer followNum, Integer commentCount) {
        this.member = member;
        this.name = name;
        this.status = status;
        this.createTime = createTime;
        this.followNum = followNum;
        this.commentCount = commentCount;
    }
    
    /** full constructor */
    public AbstractQuestion(Member member, String name, String description, Integer status, Timestamp createTime, Integer followNum, Integer commentCount, Set<Answer> answers, Set<MemberWarning> memberWarnings, Set<MemberFollowQuestion> memberFollowQuestions, Set<QuestionTopic> questionTopics, Set<News> newses, Set<MemberShareHistory> memberShareHistories) {
        this.member = member;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.followNum = followNum;
        this.commentCount = commentCount;
        this.answers = answers;
        this.memberWarnings = memberWarnings;
        this.memberFollowQuestions = memberFollowQuestions;
        this.questionTopics = questionTopics;
        this.newses = newses;
        this.memberShareHistories = memberShareHistories;
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
    
    @Column(name="name", nullable=false, length=400)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="description", length=2000)

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
    
    @Column(name="comment_count", nullable=false)

    public Integer getCommentCount() {
        return this.commentCount;
    }
    
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<Answer> getAnswers() {
        return this.answers;
    }
    
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<MemberWarning> getMemberWarnings() {
        return this.memberWarnings;
    }
    
    public void setMemberWarnings(Set<MemberWarning> memberWarnings) {
        this.memberWarnings = memberWarnings;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<MemberFollowQuestion> getMemberFollowQuestions() {
        return this.memberFollowQuestions;
    }
    
    public void setMemberFollowQuestions(Set<MemberFollowQuestion> memberFollowQuestions) {
        this.memberFollowQuestions = memberFollowQuestions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<QuestionTopic> getQuestionTopics() {
        return this.questionTopics;
    }
    
    public void setQuestionTopics(Set<QuestionTopic> questionTopics) {
        this.questionTopics = questionTopics;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<News> getNewses() {
        return this.newses;
    }
    
    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="question")

    public Set<MemberShareHistory> getMemberShareHistories() {
        return this.memberShareHistories;
    }
    
    public void setMemberShareHistories(Set<MemberShareHistory> memberShareHistories) {
        this.memberShareHistories = memberShareHistories;
    }
   








}