package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "answerListResponse")
public class AnswerListResponse extends MobileBaseResponse {
	@XmlElement
	private List<AnswerResponse> answerList;

	public List<AnswerResponse> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<AnswerResponse> answerList) {
		this.answerList = answerList;
	}

	
}
