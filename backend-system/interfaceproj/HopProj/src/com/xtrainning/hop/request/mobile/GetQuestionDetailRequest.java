package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class GetQuestionDetailRequest extends MemberBaseRequest{
    @NotNull
    private Long questionId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}

