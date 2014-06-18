package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;



public class GetMemberIdRequest extends MobileBaseRequest{
    @NotNull
    private String openuuid;

	public String getOpenuuid() {
		return openuuid;
	}

	public void setOpenuuid(String openuuid) {
		this.openuuid = openuuid;
	}
	

}

