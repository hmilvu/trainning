package com.xtrainning.hop.common;

import java.io.File;

public class Constants {
	
	public static final String SUCCESS = "success";
	public enum METHOD {
		GET_MEMBER_ID("member.getMemberId"),
		GET_NEWS_LIST("news.getNewsList"),
		
		GET_QUESTION_DETAIL("question.getQuestionDetail"),
		
		GET_TOPIC_LIST("topic.getTopicList");
		private String value;
		private METHOD(String value) {
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
	}
	
	
}
