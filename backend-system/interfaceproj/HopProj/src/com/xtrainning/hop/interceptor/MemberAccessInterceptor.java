package com.xtrainning.hop.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.rop.AbstractInterceptor;
import com.rop.RopRequestContext;

@Component
public class MemberAccessInterceptor extends AbstractInterceptor{
//	@Autowired private MemberResolver memberResolver;
	@Override
	public void beforeService(RopRequestContext ropRequestContext) {
//		if(isMatch(ropRequestContext)){
//			
//		}
	}

	@Override
	public boolean isMatch(RopRequestContext ropRequestContext) {
		String methodName = ropRequestContext.getMethod();
		if(!StringUtils.equals(methodName, "member.getMemberId") && methodName.startsWith("member.")){
			return true;
		} else {
			return false;
		}
		
	}

}
