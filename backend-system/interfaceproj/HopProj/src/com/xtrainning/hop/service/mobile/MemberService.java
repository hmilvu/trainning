package com.xtrainning.hop.service.mobile;
import java.util.ArrayList;
import java.util.List;

import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.request.mobile.SignUpRequest;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.MemberResponse;
import com.xtrainning.hop.response.mobile.NewsListResponse;
import com.xtrainning.hop.response.mobile.NewsResponse;

@ServiceMethodBean
public class MemberService extends MobileBaseService{
//	@Autowired private MemberResolver memberResolver;

	@ServiceMethod(method = "member.getMemberId",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getMemberId(GetMemberIdRequest request) {
//		Member m = memberResolver.fetchMemberByUUID(request);
//		MemberIdResponse response = new MemberIdResponse();
//		response.setMemberId(m.getId());
		MemberIdResponse response = new MemberIdResponse();
        return response;
	}
	
	@ServiceMethod(method = "member.getMemberById",version = "1.0",needInSession = NeedInSessionType.NO)
    public Object getMemberById(GetMemberIdRequest request) {
//		Member m = memberResolver.getMemberById(request.getMemberId());
//		if(m == null){
//			return new MemberResponse(1, "The member not existing.");
//		}
		MemberResponse response = new MemberResponse();
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
		MemberResponse response = new MemberResponse();
        return response;
	}
}
