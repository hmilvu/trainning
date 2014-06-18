package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberSmsHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_sms_history"
    ,catalog="xtraining_db"
)
public class MemberSmsHistory extends AbstractMemberSmsHistory implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberSmsHistory() {
    }

	/** minimal constructor */
    public MemberSmsHistory(String phoneNumber, String content, Timestamp createTime, Integer status) {
        super(phoneNumber, content, createTime, status);        
    }
    
    /** full constructor */
    public MemberSmsHistory(Member member, String phoneNumber, Integer type, String content, Timestamp createTime, Integer status) {
        super(member, phoneNumber, type, content, createTime, status);        
    }
   
}
