package com.xtrainning.hop.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;


/**
 * AbstractMember entity provides the base persistence definition of the Member entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMember extends BaseEntity implements java.io.Serializable {


    // Fields    

     private Long id;
     private SysUser sysUser;
     private String nickName;
     private String phoneNumber;
     private String email;
     private String password;
     private String avatarUrl;
     private Integer type;
     private Integer status;
     private String thirdPartyId;
     private Integer thirdPartyType;
     private Integer registerStatus;
     private Integer followQaNum = 0;
     private Integer followTopicNum = 0;
     private Integer askQaNum = 0;
     private Integer answerQaNum = 0;
     private Integer isDefault;
     private Timestamp createTime;
     private String introduction;
     private Integer sex;
     private Integer supportNum = 0;
     private Integer pushStatus;
     private String code;
     private Timestamp codeTime;
     private Timestamp lastAccessTime;
     private Set<Answer> answers = new HashSet<Answer>(0);
     private Set<Question> questions = new HashSet<Question>(0);
     private Set<MemberSmsHistory> memberSmsHistories = new HashSet<MemberSmsHistory>(0);
     private Set<MemberFollowQuestion> memberFollowQuestions = new HashSet<MemberFollowQuestion>(0);
     private Set<MemberFollowTopic> memberFollowTopics = new HashSet<MemberFollowTopic>(0);
     private Set<MemberShareHistory> memberShareHistories = new HashSet<MemberShareHistory>(0);
     private Set<Comment> comments = new HashSet<Comment>(0);
     private Set<MemberWarning> memberWarnings = new HashSet<MemberWarning>(0);
     private Set<News> newses = new HashSet<News>(0);
     private Set<MemberExpand> memberExpands = new HashSet<MemberExpand>(0);
     private Set<PushMessage> pushMessages = new HashSet<PushMessage>(0);
     private Set<MemberSupportAnswer> memberSupportAnswers = new HashSet<MemberSupportAnswer>(0);
     private Set<SysSession> sysSessions = new HashSet<SysSession>(0);


    // Constructors

    /** default constructor */
    public AbstractMember() {
    }

	/** minimal constructor */
    public AbstractMember(Integer type, Integer status, Integer registerStatus, Integer followQaNum, Integer followTopicNum, Integer askQaNum, Integer answerQaNum, Timestamp createTime, Integer sex, Integer supportNum, Integer pushStatus, Timestamp codeTime) {
        this.type = type;
        this.status = status;
        this.registerStatus = registerStatus;
        this.followQaNum = followQaNum;
        this.followTopicNum = followTopicNum;
        this.askQaNum = askQaNum;
        this.answerQaNum = answerQaNum;
        this.createTime = createTime;
        this.sex = sex;
        this.supportNum = supportNum;
        this.pushStatus = pushStatus;
        this.codeTime = codeTime;
    }
    
    /** full constructor */
    public AbstractMember(SysUser sysUser, String nickName, String phoneNumber, String email, String password, String avatarUrl, Integer type, Integer status, String thirdPartyId, Integer thirdPartyType, Integer registerStatus, Integer followQaNum, Integer followTopicNum, Integer askQaNum, Integer answerQaNum, Integer isDefault, Timestamp createTime, String introduction, Integer sex, Integer supportNum, Integer pushStatus, String code, Timestamp codeTime, Set<Answer> answers, Set<Question> questions, Set<MemberSmsHistory> memberSmsHistories, Set<MemberFollowQuestion> memberFollowQuestions, Set<MemberFollowTopic> memberFollowTopics, Set<MemberShareHistory> memberShareHistories, Set<Comment> comments, Set<MemberWarning> memberWarnings, Set<News> newses, Set<MemberExpand> memberExpands, Set<PushMessage> pushMessages, Set<MemberSupportAnswer> memberSupportAnswers, Set<SysSession> sysSessions) {
        this.sysUser = sysUser;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.type = type;
        this.status = status;
        this.thirdPartyId = thirdPartyId;
        this.thirdPartyType = thirdPartyType;
        this.registerStatus = registerStatus;
        this.followQaNum = followQaNum;
        this.followTopicNum = followTopicNum;
        this.askQaNum = askQaNum;
        this.answerQaNum = answerQaNum;
        this.isDefault = isDefault;
        this.createTime = createTime;
        this.introduction = introduction;
        this.sex = sex;
        this.supportNum = supportNum;
        this.pushStatus = pushStatus;
        this.code = code;
        this.codeTime = codeTime;
        this.answers = answers;
        this.questions = questions;
        this.memberSmsHistories = memberSmsHistories;
        this.memberFollowQuestions = memberFollowQuestions;
        this.memberFollowTopics = memberFollowTopics;
        this.memberShareHistories = memberShareHistories;
        this.comments = comments;
        this.memberWarnings = memberWarnings;
        this.newses = newses;
        this.memberExpands = memberExpands;
        this.pushMessages = pushMessages;
        this.memberSupportAnswers = memberSupportAnswers;
        this.sysSessions = sysSessions;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="sys_user_id")

    public SysUser getSysUser() {
        return this.sysUser;
    }
    
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
    
    @Column(name="nick_name", length=50)

    public String getNickName() {
        return this.nickName;
    }
    
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    @Column(name="phone_number", unique=true, length=20)

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Column(name="email", unique=true, length=60)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="password", length=100)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="avatar_url", length=1024)

    public String getAvatarUrl() {
        return this.avatarUrl;
    }
    
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    
    @Column(name="type", nullable=false)

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    
    @Column(name="status", nullable=false)

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    @Column(name="third_party_id", length=100)

    public String getThirdPartyId() {
        return this.thirdPartyId;
    }
    
    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }
    
    @Column(name="third_party_type")

    public Integer getThirdPartyType() {
        return this.thirdPartyType;
    }
    
    public void setThirdPartyType(Integer thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }
    
    @Column(name="register_status", nullable=false)

    public Integer getRegisterStatus() {
        return this.registerStatus;
    }
    
    public void setRegisterStatus(Integer registerStatus) {
        this.registerStatus = registerStatus;
    }
    
    @Column(name="follow_qa_num", nullable=false)

    public Integer getFollowQaNum() {
        return this.followQaNum;
    }
    
    public void setFollowQaNum(Integer followQaNum) {
        this.followQaNum = followQaNum;
    }
    
    @Column(name="follow_topic_num", nullable=false)

    public Integer getFollowTopicNum() {
        return this.followTopicNum;
    }
    
    public void setFollowTopicNum(Integer followTopicNum) {
        this.followTopicNum = followTopicNum;
    }
    
    @Column(name="ask_qa_num", nullable=false)

    public Integer getAskQaNum() {
        return this.askQaNum;
    }
    
    public void setAskQaNum(Integer askQaNum) {
        this.askQaNum = askQaNum;
    }
    
    @Column(name="answer_qa_num", nullable=false)

    public Integer getAnswerQaNum() {
        return this.answerQaNum;
    }
    
    public void setAnswerQaNum(Integer answerQaNum) {
        this.answerQaNum = answerQaNum;
    }
    
    @Column(name="is_default")

    public Integer getIsDefault() {
        return this.isDefault;
    }
    
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    
    @Column(name="create_time", nullable=false, length=19)

    public Timestamp getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="introduction", length=500)

    public String getIntroduction() {
        return this.introduction;
    }
    
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
    @Column(name="sex", nullable=false)

    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    @Column(name="support_num", nullable=false)

    public Integer getSupportNum() {
        return this.supportNum;
    }
    
    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }
    
    @Column(name="push_status", nullable=false)

    public Integer getPushStatus() {
        return this.pushStatus;
    }
    
    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }
    
    @Column(name="code", length=6)

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @Column(name="code_time", nullable=false, length=19)

    public Timestamp getCodeTime() {
        return this.codeTime;
    }
    
    public void setCodeTime(Timestamp codeTime) {
        this.codeTime = codeTime;
    }
    @Column(name="last_access_time", nullable=false, length=19)
    public Timestamp getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Timestamp lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<Answer> getAnswers() {
        return this.answers;
    }
    
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<Question> getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberSmsHistory> getMemberSmsHistories() {
        return this.memberSmsHistories;
    }
    
    public void setMemberSmsHistories(Set<MemberSmsHistory> memberSmsHistories) {
        this.memberSmsHistories = memberSmsHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberFollowQuestion> getMemberFollowQuestions() {
        return this.memberFollowQuestions;
    }
    
    public void setMemberFollowQuestions(Set<MemberFollowQuestion> memberFollowQuestions) {
        this.memberFollowQuestions = memberFollowQuestions;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberFollowTopic> getMemberFollowTopics() {
        return this.memberFollowTopics;
    }
    
    public void setMemberFollowTopics(Set<MemberFollowTopic> memberFollowTopics) {
        this.memberFollowTopics = memberFollowTopics;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberShareHistory> getMemberShareHistories() {
        return this.memberShareHistories;
    }
    
    public void setMemberShareHistories(Set<MemberShareHistory> memberShareHistories) {
        this.memberShareHistories = memberShareHistories;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<Comment> getComments() {
        return this.comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberWarning> getMemberWarnings() {
        return this.memberWarnings;
    }
    
    public void setMemberWarnings(Set<MemberWarning> memberWarnings) {
        this.memberWarnings = memberWarnings;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<News> getNewses() {
        return this.newses;
    }
    
    public void setNewses(Set<News> newses) {
        this.newses = newses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberExpand> getMemberExpands() {
        return this.memberExpands;
    }
    
    public void setMemberExpands(Set<MemberExpand> memberExpands) {
        this.memberExpands = memberExpands;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<PushMessage> getPushMessages() {
        return this.pushMessages;
    }
    
    public void setPushMessages(Set<PushMessage> pushMessages) {
        this.pushMessages = pushMessages;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<MemberSupportAnswer> getMemberSupportAnswers() {
        return this.memberSupportAnswers;
    }
    
    public void setMemberSupportAnswers(Set<MemberSupportAnswer> memberSupportAnswers) {
        this.memberSupportAnswers = memberSupportAnswers;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="member")

    public Set<SysSession> getSysSessions() {
        return this.sysSessions;
    }
    
    public void setSysSessions(Set<SysSession> sysSessions) {
        this.sysSessions = sysSessions;
    }
   








}