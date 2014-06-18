package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberFollowQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_follow_question"
    ,catalog="xtraining_db"
)
public class MemberFollowQuestion extends AbstractMemberFollowQuestion implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberFollowQuestion() {
    }

    
    /** full constructor */
    public MemberFollowQuestion(Member member, Question question) {
        super(member, question);        
    }
   
}
