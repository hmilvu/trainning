package com.xtrainning.hop.request.mobile;

import com.rop.AbstractRopRequest;
import com.sun.istack.internal.NotNull;

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
