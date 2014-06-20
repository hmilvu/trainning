package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class CreateQuestionRequest extends MemberBaseRequest{
    @NotNull
    private String name;
    private String description;
    private String newTopicName;
    private String topicIds;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNewTopicName() {
		return newTopicName;
	}
	public void setNewTopicName(String newTopicName) {
		this.newTopicName = newTopicName;
	}
	public String getTopicIds() {
		return topicIds;
	}
	public void setTopicIds(String topicIds) {
		this.topicIds = topicIds;
	}

}

