package com.xtrainning.hop.entity;
// default package

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_news"
    ,catalog="xtraining_db"
)
public class MemberNews extends AbstractMemberNews implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberNews() {
    }

   
}
