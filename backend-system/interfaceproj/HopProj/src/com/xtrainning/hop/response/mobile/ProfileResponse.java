package com.xtrainning.hop.response.mobile;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "profileResponse")
public class ProfileResponse extends MobileBaseResponse {
	@XmlElement
	private Long memberId;
	@XmlElement
	private String nickName;
	@XmlElement
	private String memberIntroduction;
	@XmlElement
	private String avatarUrl;
	@XmlElement
	private Integer sex;
	@XmlElement
	private Integer supportNum = 0;
	@XmlElement
	private Integer askNum = 0;
	@XmlElement
	private Integer answerNum = 0;
	@XmlElement
	private Integer followQuestionNum = 0;
	@XmlElement
	private Integer followTopicNum = 0;
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
	public String getMemberIntroduction() {
		return memberIntroduction;
	}
	public void setMemberIntroduction(String memberIntroduction) {
		this.memberIntroduction = memberIntroduction;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public Integer getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(Integer supportNum) {
		this.supportNum = supportNum;
	}
	public Integer getAskNum() {
		return askNum;
	}
	public void setAskNum(Integer askNum) {
		this.askNum = askNum;
	}
	public Integer getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}
	public Integer getFollowQuestionNum() {
		return followQuestionNum;
	}
	public void setFollowQuestionNum(Integer followQuestionNum) {
		this.followQuestionNum = followQuestionNum;
	}
	public Integer getFollowTopicNum() {
		return followTopicNum;
	}
	public void setFollowTopicNum(Integer followTopicNum) {
		this.followTopicNum = followTopicNum;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	
}
