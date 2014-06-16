package com.xtrainning.hop.request.mobile;

import com.sun.istack.internal.NotNull;

public class GetQuestionDetailRequest extends MobileBaseRequest{
    @NotNull
    private Long questionId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}

