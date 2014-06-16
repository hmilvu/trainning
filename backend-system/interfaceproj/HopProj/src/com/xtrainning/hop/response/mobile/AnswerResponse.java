package com.xtrainning.hop.response.mobile;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "newsResponse")
public class AnswerResponse extends MobileBaseResponse {
	@XmlElement
	private Long answerId;
	@XmlElement
	private Long memberId;
	@XmlElement
	private String nickName;
	@XmlElement
	private String memberIntroduction;
	@XmlElement
	private String answerContent;
	@XmlElement
	private Integer supportNum;
	@XmlElement
	private String createTime;
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
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

	public String getMemberIntroduction() {
		return memberIntroduction;
	}
	public void setMemberIntroduction(String memberIntroduction) {
		this.memberIntroduction = memberIntroduction;
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

	
}
