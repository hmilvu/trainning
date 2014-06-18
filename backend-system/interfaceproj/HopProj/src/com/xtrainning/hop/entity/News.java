package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="news"
    ,catalog="xtraining_db"
)
public class News extends AbstractNews implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public News() {
    }

	/** minimal constructor */
    public News(Member member, Question question, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String questionName) {
        super(member, question, actionType, supportNum, createTime, followedMark, status, questionName);        
    }
    
    /** full constructor */
    public News(Member member, Question question, Answer answer, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String memberNickname, String memberIntroduction, String questionName, String answerContent) {
        super(member, question, answer, actionType, supportNum, createTime, followedMark, status, memberNickname, memberIntroduction, questionName, answerContent);        
    }
   
}
