package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.xtrainning.hop.response.mobile.ProfileResponse;


/**
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="member"
    ,catalog="xtraining_db"
)
public class Member extends AbstractMember implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Member() {
    }

	/** minimal constructor */
    public Member(Integer type, Integer status, Integer registerStatus, Integer followQaNum, Integer followTopicNum, Integer askQaNum, Integer answerQaNum, Timestamp createTime, Integer sex, Integer supportNum, Integer pushStatus, Timestamp codeTime) {
        super(type, status, registerStatus, followQaNum, followTopicNum, askQaNum, answerQaNum, createTime, sex, supportNum, pushStatus, codeTime);        
    }
    
    /** full constructor */
    public Member(SysUser sysUser, String nickName, String phoneNumber, String email, String password, String avatarUrl, Integer type, Integer status, String thirdPartyId, Integer thirdPartyType, Integer registerStatus, Integer followQaNum, Integer followTopicNum, Integer askQaNum, Integer answerQaNum, Integer isDefault, Timestamp createTime, String introduction, Integer sex, Integer supportNum, Integer pushStatus, String code, Timestamp codeTime, Set<Answer> answers, Set<Question> questions, Set<MemberSmsHistory> memberSmsHistories, Set<MemberFollowQuestion> memberFollowQuestions, Set<MemberFollowTopic> memberFollowTopics, Set<MemberShareHistory> memberShareHistories, Set<Comment> comments, Set<MemberWarning> memberWarnings, Set<News> newses, Set<MemberExpand> memberExpands, Set<PushMessage> pushMessages, Set<MemberSupportAnswer> memberSupportAnswers, Set<SysSession> sysSessions) {
        super(sysUser, nickName, phoneNumber, email, password, avatarUrl, type, status, thirdPartyId, thirdPartyType, registerStatus, followQaNum, followTopicNum, askQaNum, answerQaNum, isDefault, createTime, introduction, sex, supportNum, pushStatus, code, codeTime, answers, questions, memberSmsHistories, memberFollowQuestions, memberFollowTopics, memberShareHistories, comments, memberWarnings, newses, memberExpands, pushMessages, memberSupportAnswers, sysSessions);        
    }

	public ProfileResponse toResponse() {
		ProfileResponse r = new ProfileResponse();
		r.setMemberId(getId());
		r.setAnswerNum(getAnswerQaNum());
		r.setAskNum(getAskQaNum());
		r.setAvatarUrl(getAvatarUrl());
		r.setFollowQuestionNum(getFollowQaNum());
		r.setFollowTopicNum(getFollowQaNum());
		r.setMemberIntroduction(getIntroduction());
		r.setNickName(getNickName());
		r.setSex(getSex());
		r.setSupportNum(getSupportNum());
		return r;
	}
   
}
