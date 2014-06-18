package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberShareHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_share_history"
    ,catalog="xtraining_db"
)
public class MemberShareHistory extends AbstractMemberShareHistory implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberShareHistory() {
    }

	/** minimal constructor */
    public MemberShareHistory(Member member, Question question, Integer targetWeb, Timestamp createTime) {
        super(member, question, targetWeb, createTime);        
    }
    
    /** full constructor */
    public MemberShareHistory(Member member, Question question, Integer targetWeb, Timestamp createTime, String content) {
        super(member, question, targetWeb, createTime, content);        
    }
   
}
