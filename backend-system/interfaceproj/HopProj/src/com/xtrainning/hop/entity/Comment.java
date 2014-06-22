package com.xtrainning.hop.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.CommentResponse;
import com.xtrainning.hop.utils.DateUtils;


/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="comment"
    ,catalog="xtraining_db"
)
public class Comment extends AbstractComment implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Comment() {
    }

    
    /** full constructor */
    public Comment(Member member, String content, Timestamp createTime, Integer status, Timestamp updateTime) {
        super(member, content, createTime, status, updateTime);        
    }


	public CommentResponse toResponse() {
		CommentResponse r = new CommentResponse();
		r.setCommentId(getId());
		r.setContent(getContent());
		r.setCreateTime(DateUtils.dateToyyyyMMddHHmi(getCreateTime()));
		r.setMemberId(getMember().getId());
		r.setNickName(getMember().getNickName());
		r.setAvatarUrl(getMember().getAvatarUrl());
		return r;
	}
   
}
