package com.xtrainning.hop.common;


public class Constants {
	
	public static final String SUCCESS = "success";
	public enum METHOD {
		GET_MEMBER_ID("member.getMemberId"),
		LOGIN("member.login"),
		GET_PROFILE("member.getProfile"),
		
		GET_NEWS_LIST("news.getNewsList"),
		
		GET_QUESTION_DETAIL("question.getQuestionDetail"),
		GET_ANSWER_DETAIL("question.getAnswerList"),
		
		GET_TOPIC_DETAIL("topic.getTopicDetail"),
		GET_TOPIC_LIST("topic.getTopicList");
		private String value;
		private METHOD(String value) {
			this.value = value;
		}
		public String getValue(){
			return this.value;
		}
	}
	
	public enum ACCESS_LOG_TYPE {
		REQUEST(1), RESPONSE(2);
		private int value;
		private ACCESS_LOG_TYPE(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum CLIENT_APPKEY_STATUS {
		ACTIVE(0), DELETED(1);
		private int value;
		private CLIENT_APPKEY_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum SYS_SESSION_STATUS {
		ACTIVE(0), INACTIVE(1);
		private int value;
		private SYS_SESSION_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_STATUS {
		ACTIVE(0), DELETED(1), LOCKED(2);
		private int value;
		private MEMBER_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_REGISTER_STATUS {
		NON_REGISTERED(0), REGISTERED(1);
		private int value;
		private MEMBER_REGISTER_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_TYPE {
		PUBLIC(0), SYS_MEMBER(1);
		private int value;
		private MEMBER_TYPE(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_GENDER {
		MALE(1), FEMALE(0), UNKNOW(2);
		private int value;
		private MEMBER_GENDER(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum PUSH_STATUS {
		ON(1), OFF(0);
		private int value;
		private PUSH_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
}
