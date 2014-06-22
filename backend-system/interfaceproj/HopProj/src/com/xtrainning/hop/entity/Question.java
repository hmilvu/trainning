package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.response.mobile.QuestionResponse;
import com.xtrainning.hop.utils.DateUtils;


/**
 * Question entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="question"
    ,catalog="xtraining_db"
)
public class Question extends AbstractQuestion implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Question() {
    }

	/** minimal constructor */
    public Question(Member member, String name, Integer status, Timestamp createTime, Integer followNum, Integer commentCount) {
        super(member, name, status, createTime, followNum, commentCount);        
    }
    
    /** full constructor */
    public Question(Member member, String name, String description, Integer status, Timestamp createTime, Integer followNum, Integer commentCount, Set<Answer> answers, Set<MemberWarning> memberWarnings, Set<MemberFollowQuestion> memberFollowQuestions, Set<QuestionTopic> questionTopics, Set<News> newses, Set<MemberShareHistory> memberShareHistories) {
        super(member, name, description, status, createTime, followNum, commentCount, answers, memberWarnings, memberFollowQuestions, questionTopics, newses, memberShareHistories);        
    }

	public QuestionResponse toResponse() {
		QuestionResponse r = new QuestionResponse();
		r.setQuestionId(getId());
		r.setQuestionTopic(getName());
		return r;
	}

//	public QuestionDetailResponse toDetailResponse() {
//		QuestionDetailResponse r = new QuestionDetailResponse();
//		r.setQuestionId(getId());
//		r.setMemberId(getMember().getId());
//		r.setCreateTime(DateUtils.dateToyyyyMMddHHmi(getCreateTime()));
//		r.setDescription(getDescription());
//		r.setQuestionTopic(getName());
//		r.setFollowedNum(getFollowNum());
//		r.setNickName(getMember().getNickName());
//		r.setCommentNum(getCommentCount());
//		return r;
//	}
   
}
