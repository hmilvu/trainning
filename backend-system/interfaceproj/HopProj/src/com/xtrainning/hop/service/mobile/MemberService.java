package com.xtrainning.hop.service.mobile;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.RopRequest;
import com.rop.annotation.HttpAction;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.rop.response.BusinessServiceErrorResponse;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.common.Constants.SMS_TYPE;
import com.xtrainning.hop.common.Constants.THIRD_PARTY_TYPE;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.MemberSmsHistory;
import com.xtrainning.hop.entity.SysSession;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetProfileRequest;
import com.xtrainning.hop.request.mobile.GetVcodeRequest;
import com.xtrainning.hop.request.mobile.LoginRequest;
import com.xtrainning.hop.request.mobile.SignUpRequest;
import com.xtrainning.hop.request.mobile.ThirdLoginRequest;
import com.xtrainning.hop.resolver.MemberResolver;
import com.xtrainning.hop.resolver.SmsResolver;
import com.xtrainning.hop.resolver.SysSessionResolver;
import com.xtrainning.hop.response.mobile.LoginResponse;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.ProfileResponse;
import com.xtrainning.hop.response.mobile.SimpleResponse;

@ServiceMethodBean
public class MemberService extends MobileBaseService{
	@Autowired private MemberResolver memberResolver;
	@Autowired private SmsResolver smsResolver;
	@Autowired private SysSessionResolver sessionResolver;
	@ServiceMethod(method = "member.getMemberId",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getMemberId(GetMemberIdRequest request) {
		Member m = memberResolver.getMemberByUUID(request.getOpenuuid());
		if(m == null){
			m = memberResolver.addNonRegisteredMember(request);
		} else {
			memberResolver.updateLastAccessTime(m.getId());
		}
		MemberIdResponse response = new MemberIdResponse();
		response.setMemberId(m.getId());
        return response;
	}
	
	@ServiceMethod(method = "member.preSignUp", version = "1.0", needInSession = NeedInSessionType.NO, httpAction = HttpAction.POST)
    public Object preSignUp(GetVcodeRequest request) {
		//check whether the phone number already exists or not.
		Long memberId = memberResolver.checkMemberByPhoneNumber(request.getPhoneNumber());
		SimpleResponse r = new SimpleResponse();
		if(memberId != null && memberId > 0){
			r.setFlag(1);
			r.setMsg("The phone number is already registered.");
			return r;
		} 
		
		int smsNumResult = memberResolver.checkMemberSmsNum(SMS_TYPE.SIGN_UP, request.getPhoneNumber());
		if(smsNumResult != 0){
			r.setFlag(2);
			r.setMsg("The phone number already exceeds max sign up sms num.");
			return r;
		}
		
		MemberSmsHistory msg = memberResolver.createVcode(request.getPhoneNumber());
		r.setFlag(0);
		r.setMsg("The phone number is already registered.");
		smsResolver.sendVcode(msg);
		return r;
	}
	
	@ServiceMethod(method = "member.signUp",version = "1.0",needInSession = NeedInSessionType.NO, httpAction = HttpAction.POST)
    public Object signUp(SignUpRequest request) {
		LoginResponse response = new LoginResponse();
		//check whether the phone number already exists or not.
		Long memberId = memberResolver.checkMemberByPhoneNumber(request.getPhoneNumber());
		if(memberId != null && memberId > 0){
			response.setFlag(1);
			response.setMsg("The phone number is already being used.");
			return response;
		}
		//check vcode
		int vcodeVerify = 0;//memberResolver.checkVcode(request.getPhoneNumber(), request.getVcode());
		if(vcodeVerify == 1){
			response.setFlag(2);
			response.setMsg("The vcode is already expired.");
			return response;
		} else if(vcodeVerify == 2){
			response.setFlag(3);
			response.setMsg("The vcode is incorrect.");
			return response;
		}
		memberResolver.signUp(request);		
		response = setupLoginSuccessResponse(request, memberId);
		return response;
	}

	private LoginResponse setupLoginSuccessResponse(RopRequest request, Long memberId) {
		LoginResponse response = new LoginResponse();
		SysSession session = sessionResolver.buildMemberSession(memberId);
		request.getRopRequestContext().addSession(session.getSessionId(), session.toSession());
		
		response.setFlag(0);
		response.setMsg(Constants.SUCCESS);
		response.setSessionId(session.getSessionId());
		response.setMemberId(memberId);
		return response;
	}
	
	@ServiceMethod(method = "member.login",version = "1.0", needInSession = NeedInSessionType.NO, httpAction = HttpAction.POST)
    public Object login(LoginRequest request) {	
		Long memberId = memberResolver.checkMemberByCredentials(request.getPhoneNumber(), request.getPassword());	
		if(memberId != null && memberId > 0){
			LoginResponse response = new LoginResponse();
			response.setFlag(1);
			response.setMsg("User name and password are incorrect.");
			return response;
		}
		LoginResponse response = setupLoginSuccessResponse(request, memberId);
		return response;
	}
	
	@ServiceMethod(method = "member.thirdLogin",version = "1.0", needInSession = NeedInSessionType.NO, httpAction = HttpAction.POST)
    public Object thirdLogin(ThirdLoginRequest request) {	
		if(request.getType() != THIRD_PARTY_TYPE.WEIBO.getValue() && request.getType() != THIRD_PARTY_TYPE.WEIXIN.getValue()
				&& request.getType() != THIRD_PARTY_TYPE.QQ.getValue() ){
			return new BusinessServiceErrorResponse(
        			request.getRopRequestContext().getMethod(), "NOT_SUPPORTED_THIRD_PARTY_TYPE",
        			request.getRopRequestContext().getLocale(), request.getType());
		}
		Long memberId = memberResolver.checkMemberByThirdPartyId(request.getThirdPartyId(), request.getType());	
		if(memberId != null && memberId > 0){
			LoginResponse response = setupLoginSuccessResponse(request, memberId);
			return response;
		}
		Long newMemberId = memberResolver.thirdSignUp(request);		
		LoginResponse response = setupLoginSuccessResponse(request, newMemberId);
		return response;
	}
	
	@ServiceMethod(method = "member.getProfile",version = "1.0", needInSession = NeedInSessionType.YES)
    public Object getProfile(GetProfileRequest request) {		
		ProfileResponse response = new ProfileResponse();
		response.setMemberId(3L);
		response.setMemberIntroduction("好好学习天天向上");
		response.setNickName("爽爽");
		response.setSex(0);
		return response;
	
	}
}
