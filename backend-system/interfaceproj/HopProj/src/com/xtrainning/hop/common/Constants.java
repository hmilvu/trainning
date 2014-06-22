package com.xtrainning.hop.common;


public class Constants {
	
	public static final String SUCCESS = "success";
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	public static final String SMS_SIGN_UP_TEMPLATE = "sms_sign_up_template";
	public static final String SMS_RESET_PASSWORD_TEMPLATE = "sms_reset_password_template";
	public static final String MAX_SMS_SIGN_UP_NUM = "max_sms_sign_up_num";
	public static final String MAX_SMS_RESET_PASSWORD_NUM = "max_sms_reset_password_num";
	public enum METHOD {
		GET_MEMBER_ID("member.getMemberId"),
		PRE_SIGN_UP("member.preSignUp"),
		SIGN_UP("member.signUp"),
		LOGIN("member.login"),
		LOGOFF("member.logoff"),
		THIRD_LOGIN("member.thirdLogin"),
		GET_PROFILE("member.getProfile"),
		
		GET_NEWS_LIST("news.getNewsList"),
		
		GET_QUESTION_DETAIL("question.getQuestionDetail"),
		GET_ANSWER_List("question.getAnswerList"),
		CREATE_QUESTION("question.createQuestion"),
		CREATE_ANSWER("question.createAnswer"),
		
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
	
	public enum NEWS_STATUS {
		ACTIVE(0), DELETED(1);
		private int value;
		private NEWS_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum TOPIC_STATUS {
		ACTIVE(0), DELETED(1);
		private int value;
		private TOPIC_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum QUESTION_STATUS {
		ACTIVE(0), DELETED(1);
		private int value;
		private QUESTION_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum NEWS_ACTION_TYPE {
		QUESTION(0), ANSWER(1);
		private int value;
		private NEWS_ACTION_TYPE(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum SMS_TYPE {
		SIGN_UP(0), RESET_PWD(1);
		private int value;
		private SMS_TYPE(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum SMS_STATUS {
		SENT_SUCCESS(0), SENT_FAILED(1);
		private int value;
		private SMS_STATUS(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum THIRD_PARTY_TYPE {
		WEIBO(0), WEIXIN(1), QQ(2);
		private int value;
		private THIRD_PARTY_TYPE(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_QUESTION {
		FOLLOWED(1), WARNING(1);
		private int value;
		private MEMBER_QUESTION(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
	
	public enum MEMBER_TOPIC {
		NOT_FOLLOWED(0), FOLLOWED(1);
		private int value;
		private MEMBER_TOPIC(int value) {
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
	}
}
