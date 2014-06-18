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
 * AbstractQuestionTopic entity provides the base persistence definition of the QuestionTopic entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractQuestionTopic extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private Topic topic;
     private Question question;


    // Constructors

    /** default constructor */
    public AbstractQuestionTopic() {
    }

    
    /** full constructor */
    public AbstractQuestionTopic(Topic topic, Question question) {
        this.topic = topic;
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
        @JoinColumn(name="topic_id", nullable=false)

    public Topic getTopic() {
        return this.topic;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
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