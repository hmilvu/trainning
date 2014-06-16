package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.Pattern;

import com.rop.annotation.IgnoreSign;
import com.sun.istack.internal.NotNull;

public class SignUpRequest extends MobileBaseRequest{
    @NotNull
    private Long memberId;
    @NotNull
    @Pattern(regexp = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
    private String email;
    @Pattern(regexp = "\\w{6,30}")
    private String password;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

    
}

