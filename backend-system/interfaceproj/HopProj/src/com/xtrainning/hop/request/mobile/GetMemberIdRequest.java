package com.xtrainning.hop.request.mobile;

import com.sun.istack.internal.NotNull;

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

