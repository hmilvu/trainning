package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="sys_user"
    ,catalog="xtraining_db"
)
public class SysUser extends AbstractSysUser implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public SysUser() {
    }

	/** minimal constructor */
    public SysUser(Role role, String userName, Integer status, String email, String phoneNumber, Timestamp createTime, String password) {
        super(role, userName, status, email, phoneNumber, createTime, password);        
    }
    
    /** full constructor */
    public SysUser(Role role, String userName, Integer status, String email, String phoneNumber, Timestamp createTime, String password, Set<Member> members, Set<PushMessage> pushMessages, Set<MemberWarning> memberWarnings) {
        super(role, userName, status, email, phoneNumber, createTime, password, members, pushMessages, memberWarnings);        
    }
   
}
