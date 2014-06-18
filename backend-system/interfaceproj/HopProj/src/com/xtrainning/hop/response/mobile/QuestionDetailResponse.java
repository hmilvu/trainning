package com.xtrainning.hop.response.mobile;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "questionDetailResponse")
public class QuestionDetailResponse extends QuestionResponse {
	@XmlElement
	private Long memberId = 0L;
	@XmlElement
	private String nickName;
	@XmlElement
	private String description;
	@XmlElement
	private Integer followedNum;
	@XmlElement
	private Integer followedFlag;
	@XmlElement
	private Integer commentNum;
	@XmlElement
	private Integer warningFlag;
	@XmlElement
	private String createTime;
	@XmlElement
	private List<TopicResponse>topicList;
	@XmlElement
	private List<String>imageList;
	@XmlElement
	private List<AnswerResponse> answerList;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getFollowedNum() {
		return followedNum;
	}
	public void setFollowedNum(Integer followedNum) {
		this.followedNum = followedNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public List<AnswerResponse> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<AnswerResponse> answerList) {
		this.answerList = answerList;
	}
	public List<TopicResponse> getTopicList() {
		return topicList;
	}
	public void setTopicList(List<TopicResponse> topicList) {
		this.topicList = topicList;
	}
	public List<String> getImageList() {
		return imageList;
	}
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}
	public Integer getWarningFlag() {
		return warningFlag;
	}
	public void setWarningFlag(Integer warningFlag) {
		this.warningFlag = warningFlag;
	}
	public Integer getFollowedFlag() {
		return followedFlag;
	}
	public void setFollowedFlag(Integer followedFlag) {
		this.followedFlag = followedFlag;
	}
	
	
}
