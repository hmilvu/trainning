package com.xtrainning.hop.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="role"
    ,catalog="xtraining_db"
)
public class Role extends AbstractRole implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String name, Integer status) {
        super(name, status);        
    }
    
    /** full constructor */
    public Role(String name, String description, Integer status, Set<SysUser> sysUsers) {
        super(name, description, status, sysUsers);        
    }
   
}
