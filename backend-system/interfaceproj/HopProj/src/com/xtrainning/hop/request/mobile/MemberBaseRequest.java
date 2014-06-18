package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class MemberBaseRequest extends MobileBaseRequest{
	@NotNull
    private Long memberId;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}


	
}
