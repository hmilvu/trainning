package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.NewsResponse;
import com.xtrainning.hop.utils.DateUtils;


/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="news"
    ,catalog="xtraining_db"
)
public class News extends AbstractNews implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public News() {
    }

	/** minimal constructor */
    public News(Member member, Question question, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String questionName) {
        super(member, question, actionType, supportNum, createTime, followedMark, status, questionName);        
    }
    
    /** full constructor */
    public News(Member member, Question question, Answer answer, Integer actionType, Integer supportNum, Timestamp createTime, Integer followedMark, Integer status, String memberNickname, String memberIntroduction, String questionName, String answerContent) {
        super(member, question, answer, actionType, supportNum, createTime, followedMark, status, memberNickname, memberIntroduction, questionName, answerContent);        
    }

	public NewsResponse toResponse() {
		NewsResponse r = new NewsResponse();
		r.setNewId(getId());
		r.setActionType(getActionType());
		if(getAnswerContent() != null && getAnswerContent().length() > 100){
			r.setAnswerContent(getAnswerContent().substring(100));
		} else{
			r.setAnswerContent(getAnswerContent());
		}
		r.setAnswerId(getAnswer().getId());
		r.setCreateTime(DateUtils.dateToyyyyMMddHHmiss(getCreateTime()));
//		r.setFollowedMark(getFollowedMark());
		r.setMemberId(getMember().getId());
		r.setNickName(getMemberNickname());
		r.setQuestionId(getQuestion().getId());
		if(getQuestionName() != null && getQuestionName().length() > 100){
			r.setQuestionTopic(getQuestionName().substring(100));
		} else{
			r.setQuestionTopic(getQuestionName());
		}
		r.setSupportNum(getSupportNum());
		return null;
	}
   
}
