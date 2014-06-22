package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;




public class CreateCommentRequest extends MemberBaseRequest{
	@NotNull
	private Long questionId;
	@NotNull
	@Pattern(regexp = "\\w{5,2000}")
	private String content;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

