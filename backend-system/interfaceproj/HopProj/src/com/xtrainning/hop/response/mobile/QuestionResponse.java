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
	@XmlElement
	private Integer answerSupportNum;
	@XmlElement
	private Long answerId;
	@XmlElement
	private String answerContent;
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
	public Integer getAnswerSupportNum() {
		return answerSupportNum;
	}
	public void setAnswerSupportNum(Integer answerSupportNum) {
		this.answerSupportNum = answerSupportNum;
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
	
}
