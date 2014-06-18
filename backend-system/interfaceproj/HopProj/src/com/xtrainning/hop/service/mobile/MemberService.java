package com.xtrainning.hop.service.mobile;

import org.springframework.beans.factory.annotation.Autowired;

import com.rop.annotation.HttpAction;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetProfileRequest;
import com.xtrainning.hop.request.mobile.LoginRequest;
import com.xtrainning.hop.request.mobile.SignUpRequest;
import com.xtrainning.hop.resolver.MemberResolver;
import com.xtrainning.hop.response.mobile.LoginResponse;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.ProfileResponse;

@ServiceMethodBean
public class MemberService extends MobileBaseService{
	@Autowired private MemberResolver memberResolver;

	@ServiceMethod(method = "member.getMemberId",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getMemberId(GetMemberIdRequest request) {
		Member m = memberResolver.getMemberByUUID(request.getOpenuuid());
		if(m == null){
			m = memberResolver.addNonRegisteredMember(request);
		}
		MemberIdResponse response = new MemberIdResponse();
		response.setMemberId(m.getId());
        return response;
	}
	
	@ServiceMethod(method = "member.signUp",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object signUp(SignUpRequest request) {
//		Member m = memberResolver.getMemberById(request.getMemberId());			
//		boolean emailExist = memberResolver.checkEmails(request.getEmail());
//		if(emailExist){
//			MemberResponse response = new MemberResponse(2, "The Email already existing.");
//			return response;
//		}
//		memberResolver.signUp(request, m);		
//		SysSession session = sessionResolver.buildMemberSession( m);
//		request.getRopRequestContext().addSession(session.getSessionid(), session.toSession());
//		MemberResponse response = new MemberResponse();
//		response.setSessionId(session.getSessionid());
//		response.setMemberId(m.getId());
		LoginResponse response = new LoginResponse();
		response.setFlag(0);
		response.setMsg(Constants.SUCCESS);
		response.setSessionId("JASHFIUEOBLKJAHFUELAJDFEU");
		response.setMemberId(3L);
		return response;
	}
	
	@ServiceMethod(method = "member.login",version = "1.0", needInSession = NeedInSessionType.NO, httpAction = HttpAction.POST)
    public Object login(LoginRequest request) {		
		LoginResponse response = new LoginResponse();
		response.setFlag(0);
		response.setMsg(Constants.SUCCESS);
		response.setSessionId("JASHFIUEOBLKJAHFUELAJDFEU");
		response.setMemberId(3L);
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
