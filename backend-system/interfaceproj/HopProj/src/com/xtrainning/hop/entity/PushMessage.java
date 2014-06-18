package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * PushMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="push_message"
    ,catalog="xtraining_db"
)
public class PushMessage extends AbstractPushMessage implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public PushMessage() {
    }

	/** minimal constructor */
    public PushMessage(Integer iosType, String baiduChannelId, String description, Timestamp createTime, Integer type, Integer status) {
        super(iosType, baiduChannelId, description, createTime, type, status);        
    }
    
    /** full constructor */
    public PushMessage(Member member, SysUser sysUser, Integer iosType, String baiduChannelId, String name, String description, Timestamp createTime, Integer type, Integer status) {
        super(member, sysUser, iosType, baiduChannelId, name, description, createTime, type, status);        
    }
   
}
