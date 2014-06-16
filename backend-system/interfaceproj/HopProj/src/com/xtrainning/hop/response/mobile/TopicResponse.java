package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "newsResponse")
public class TopicResponse extends MobileBaseResponse {
	@XmlElement
	private Long topicId = 0L;
	@XmlElement
	private String topicName;
	@XmlElement
	private Long followedNum = 0L;
	@XmlElement
	private List<QuestionResponse> questionList;
	public Long getTopicId() {
		return topicId == null ? 0 : topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public Long getFollowedNum() {
		return followedNum == null ? 0 : followedNum;
	}
	public void setFollowedNum(Long followedNum) {
		this.followedNum = followedNum;
	}
	public List<QuestionResponse> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<QuestionResponse> questionList) {
		this.questionList = questionList;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
	
}
