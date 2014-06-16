package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "topicListResponse")
public class TopicListResponse extends MobileBaseResponse {
	@XmlElement
	private List<TopicResponse> topicList;

	public List<TopicResponse> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<TopicResponse> topicList) {
		this.topicList = topicList;
	}


	
}
