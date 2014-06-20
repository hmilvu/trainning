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
 * AbstractNews entity provides the base persistence definition of the News entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractNews extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Member member;
     private Question question;
     private Answer answer;
     private Integer actionType;
     private Integer supportNum;
     private Timestamp createTime;
     private Integer status;
     private String memberNickname;
     private String memberIntroduction;
     private String questionName;
     private String answerContent;


    // Constructors

    /** default constructor */
    public AbstractNews() {
    }

	/** minimal constructor */
    public AbstractNews(Member member, Question question, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String questionName) {
        this.member = member;
        this.question = question;
        this.actionType = actionType;
        this.supportNum = supportNum;
        this.createTime = createTime;
        this.status = status;
        this.questionName = questionName;
    }
    
    /** full constructor */
    public AbstractNews(Member member, Question question, Answer answer, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String memberNickname, String memberIntroduction, String questionName, String answerContent) {
        this.member = member;
        this.question = question;
        this.answer = answer;
        this.actionType = actionType;
        this.supportNum = supportNum;
        this.createTime = createTime;
        this.status = status;
        this.memberNickname = memberNickname;
        this.memberIntroduction = memberIntroduction;
        this.questionName = questionName;
        this.answerContent = answerContent;
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
        @JoinColumn(name="answer_id")

    public Answer getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
    @Column(name="action_type", nullable=false)

    public Integer getActionType() {
        return this.actionType;
    }
    
    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }
    
    @Column(name="support_num", nullable=false)

    public Integer getSupportNum() {
        return this.supportNum;
    }
    
    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="member_nickname", length=100)

    public String getMemberNickname() {
        return this.memberNickname;
    }
    
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }
    
    @Column(name="member_introduction", length=400)

    public String getMemberIntroduction() {
        return this.memberIntroduction;
    }
    
    public void setMemberIntroduction(String memberIntroduction) {
        this.memberIntroduction = memberIntroduction;
    }
    
    @Column(name="question_name", nullable=false, length=400)

    public String getQuestionName() {
        return this.questionName;
    }
    
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
    
    @Column(name="answer_content", length=4000)

    public String getAnswerContent() {
        return this.answerContent;
    }
    
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
   








}