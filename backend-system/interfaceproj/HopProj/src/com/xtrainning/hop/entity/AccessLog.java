package com.xtrainning.hop.entity;
// default package

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AccessLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="access_log"
    ,catalog="xtraining_db"
)
public class AccessLog extends AbstractAccessLog implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public AccessLog() {
    }

    
    /** full constructor */
    public AccessLog(String ip, String method, String appkey, Integer type, Timestamp createTime, String message) {
        super(ip, method, appkey, type, createTime, message);        
    }
   
}
