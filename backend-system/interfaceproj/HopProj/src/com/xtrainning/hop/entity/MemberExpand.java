package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * MemberExpand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member_expand"
    ,catalog="xtraining_db"
)
public class MemberExpand extends AbstractMemberExpand implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public MemberExpand() {
    }

	/** minimal constructor */
    public MemberExpand(Member member, String uuid, Integer osType, String appVersion) {
        super(member, uuid, osType, appVersion);        
    }
    
    /** full constructor */
    public MemberExpand(Member member, String uuid, Integer osType, String baiduUserId, String baiduChannelId, String appVersion) {
        super(member, uuid, osType, baiduUserId, baiduChannelId, appVersion);        
    }
   
}
