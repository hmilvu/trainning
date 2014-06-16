package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "newsListResponse")
public class NewsListResponse extends MobileBaseResponse {
	@XmlElement
	private List<NewsResponse> newsList;

	public List<NewsResponse> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsResponse> newsList) {
		this.newsList = newsList;
	}

	
}
