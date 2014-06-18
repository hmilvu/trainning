package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Answer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="answer"
    ,catalog="xtraining_db"
)
public class Answer extends AbstractAnswer implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Answer() {
    }

	/** minimal constructor */
    public Answer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum) {
        super(member, question, content, createTime, updateTime, supportNum);        
    }
    
    /** full constructor */
    public Answer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum, Set<MemberSupportAnswer> memberSupportAnswers, Set<News> newses) {
        super(member, question, content, createTime, updateTime, supportNum, memberSupportAnswers, newses);        
    }
   
}
