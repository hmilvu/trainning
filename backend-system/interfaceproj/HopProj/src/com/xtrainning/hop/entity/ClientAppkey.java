package com.xtrainning.hop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * ClientAppkey entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="client_appkey"
    ,catalog="xtraining_db"
)
public class ClientAppkey extends AbstractClientAppkey implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ClientAppkey() {
    }

    
    /** full constructor */
    public ClientAppkey(String appKey, String secretKey, Integer status) {
        super(appKey, secretKey, status);        
    }
   
}
