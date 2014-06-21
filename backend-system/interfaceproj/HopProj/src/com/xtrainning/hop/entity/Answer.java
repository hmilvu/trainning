package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.AnswerResponse;
import com.xtrainning.hop.utils.DateUtils;


/**
 * Answer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="answer"
    ,catalog="xtraining_db"
)
public class Answer extends AbstractAnswer implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Answer() {
    }

	/** minimal constructor */
    public Answer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum) {
        super(member, question, content, createTime, updateTime, supportNum);        
    }
    
    /** full constructor */
    public Answer(Member member, Question question, String content, Timestamp createTime, Timestamp updateTime, Integer supportNum, Set<MemberSupportAnswer> memberSupportAnswers, Set<News> newses) {
        super(member, question, content, createTime, updateTime, supportNum, memberSupportAnswers, newses);        
    }

	public AnswerResponse toResponse() {
		AnswerResponse r = new AnswerResponse();
		r.setAnswerContent(getContent());
		r.setAnswerId(getId());
		r.setCreateTime(DateUtils.dateToyyyyMMddHHmi(getCreateTime()));
		r.setMemberId(getMember().getId());
		r.setMemberIntroduction(getMember().getIntroduction());
		r.setNickName(getMember().getNickName());
		r.setSupportNum(getSupportNum());
		return r;
	}
   
}
