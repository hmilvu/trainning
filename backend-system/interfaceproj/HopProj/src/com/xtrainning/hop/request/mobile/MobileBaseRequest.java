package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;

import com.rop.AbstractRopRequest;

public class MobileBaseRequest extends AbstractRopRequest{
	@NotNull
    private String appVersion;

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
}
