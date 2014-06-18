package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * AccessPrivilege entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="access_privilege"
    ,catalog="xtraining_db"
)
public class AccessPrivilege extends AbstractAccessPrivilege implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public AccessPrivilege() {
    }

    
    /** full constructor */
    public AccessPrivilege(String appKey, String methodName) {
        super(appKey, methodName);        
    }
   
}
