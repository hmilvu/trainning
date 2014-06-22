package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.TopicResponse;


/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="topic"
    ,catalog="xtraining_db"
)
public class Topic extends AbstractTopic implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Topic() {
    }

	/** minimal constructor */
    public Topic(String name, Integer status, Timestamp createTime, Integer followNum) {
        super(name, status, createTime, followNum);        
    }
    
    /** full constructor */
    public Topic(String name, Integer status, Timestamp createTime, Integer followNum, String typeCode, Set<QuestionTopic> questionTopics, Set<MemberFollowTopic> memberFollowTopics) {
        super(name, status, createTime, followNum, typeCode, questionTopics, memberFollowTopics);        
    }

	public TopicResponse toResponse() {
		TopicResponse r = new TopicResponse();
		r.setTopicId(getId());
		r.setTopicName(getName());
		r.setFollowedNum(getFollowNum());
		return r;
	}
   
}
