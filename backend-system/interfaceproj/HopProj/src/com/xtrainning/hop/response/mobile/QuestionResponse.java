package com.xtrainning.hop.response.mobile;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "questionResponse")
public class QuestionResponse extends MobileBaseResponse {
	@XmlElement
	private Long questionId = 0L;
	@XmlElement
	private String questionTopic;
	public Long getQuestionId() {
		return questionId == null ? 0 : questionId;
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
	
}
