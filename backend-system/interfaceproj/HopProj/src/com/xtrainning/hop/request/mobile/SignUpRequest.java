package com.xtrainning.hop.request.mobile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class SignUpRequest extends MobileBaseRequest{
	@NotNull
    @Pattern(regexp = "^[1-9]\\d{10}$")
    private String phoneNumber;
    
    @NotNull
    @Pattern(regexp = "\\w{6,100}")
    private String password;
    
    @NotNull
    private Integer sex;
    
    @NotNull
    @Pattern(regexp = "\\w{1,40}")
    private String nickName;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	

    
}

