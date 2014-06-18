package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberSupportAnswer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_support_answer"
    ,catalog="xtraining_db"
)
public class MemberSupportAnswer extends AbstractMemberSupportAnswer implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberSupportAnswer() {
    }

    
    /** full constructor */
    public MemberSupportAnswer(Member member, Answer answer, Integer status) {
        super(member, answer, status);        
    }
   
}
