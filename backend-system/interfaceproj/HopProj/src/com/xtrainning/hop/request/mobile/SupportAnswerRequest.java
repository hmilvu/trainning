package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;




public class SupportAnswerRequest extends MemberBaseRequest{
	@NotNull
	private Long answerId;
	
	@NotNull
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
}

