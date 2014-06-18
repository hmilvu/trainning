package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberWarning entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_warning"
    ,catalog="xtraining_db"
)
public class MemberWarning extends AbstractMemberWarning implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberWarning() {
    }

	/** minimal constructor */
    public MemberWarning(Member member, Question question, Integer status, Timestamp createTime, Timestamp dealTime) {
        super(member, question, status, createTime, dealTime);        
    }
    
    /** full constructor */
    public MemberWarning(Member member, SysUser sysUser, Question question, Integer status, Timestamp createTime, Timestamp dealTime) {
        super(member, sysUser, question, status, createTime, dealTime);        
    }
   
}
