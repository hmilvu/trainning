package com.xtrainning.hop.response.mobile;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "newsResponse")
public class NewsResponse extends MobileBaseResponse {
	@XmlElement
	private Long newId;
	@XmlElement
	private Long memberId;
	@XmlElement
	private String nickName;
	@XmlElement
	private String actionType;
	@XmlElement
	private Long questionId;
	@XmlElement
	private String questionTopic;
	@XmlElement
	private Long answerId;
	@XmlElement
	private String answerContent;
	@XmlElement
	private Integer supportNum;
	@XmlElement
	private String createTime;
	@XmlElement
	private Integer followedMark;
	public Long getNewId() {
		return newId;
	}
	public void setNewId(Long newId) {
		this.newId = newId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTopic() {
		return questionTopic;
	}
	public void setQuestionTopic(String questionTopic) {
		this.questionTopic = questionTopic;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Integer getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(Integer supportNum) {
		this.supportNum = supportNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getFollowedMark() {
		return followedMark;
	}
	public void setFollowedMark(Integer followedMark) {
		this.followedMark = followedMark;
	}
	
	
}
