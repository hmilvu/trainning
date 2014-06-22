package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;




public class FollowTopicRequest extends MemberBaseRequest{
	@NotNull
	private Long topicId;

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
    
}

