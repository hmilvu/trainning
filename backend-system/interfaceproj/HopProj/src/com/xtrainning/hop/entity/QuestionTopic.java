package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * QuestionTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="question_topic"
    ,catalog="xtraining_db"
)
public class QuestionTopic extends AbstractQuestionTopic implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public QuestionTopic() {
    }

    
    /** full constructor */
    public QuestionTopic(Topic topic, Question question) {
        super(topic, question);        
    }
   
}
