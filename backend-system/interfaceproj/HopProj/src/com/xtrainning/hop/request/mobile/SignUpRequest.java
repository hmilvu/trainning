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
    
    @NotNull
    private String vcode;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

    
}

