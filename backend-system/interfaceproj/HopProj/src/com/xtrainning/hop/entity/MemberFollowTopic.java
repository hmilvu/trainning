package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberFollowTopic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_follow_topic"
    ,catalog="xtraining_db"
)
public class MemberFollowTopic extends AbstractMemberFollowTopic implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberFollowTopic() {
    }

    
    /** full constructor */
    public MemberFollowTopic(Topic topic, Member member) {
        super(topic, member);        
    }
   
}
