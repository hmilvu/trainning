package com.xtrainning.hop.resolver;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.common.Constants.MEMBER_GENDER;
import com.xtrainning.hop.common.Constants.MEMBER_REGISTER_STATUS;
import com.xtrainning.hop.common.Constants.MEMBER_STATUS;
import com.xtrainning.hop.common.Constants.MEMBER_TYPE;
import com.xtrainning.hop.common.Constants.PUSH_STATUS;
import com.xtrainning.hop.dao.MemberDAO;
import com.xtrainning.hop.dao.MemberExpandDAO;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.MemberExpand;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
@Service
public class MemberResolver {

	@Autowired private MemberDAO memberDao;
	@Autowired private MemberExpandDAO memberExpandDao;
	public Member getMemberByUUID(String openuuid) {
		MemberExpand memberExpand = memberExpandDao.getByOpenuuid(openuuid);
		if(memberExpand == null){
			return null;
		}
		return memberExpand.getMember();
	}
	public Member addNonRegisteredMember(GetMemberIdRequest request) {
		Member m = new Member();
		m.setType(MEMBER_TYPE.PUBLIC.getValue());
		m.setStatus(MEMBER_STATUS.ACTIVE.getValue());
		m.setRegisterStatus(MEMBER_REGISTER_STATUS.NON_REGISTERED.getValue());
		m.setSex(MEMBER_GENDER.UNKNOW.getValue());
		m.setCreateTime(new Timestamp(new Date().getTime()));
		m.setPushStatus(PUSH_STATUS.ON.getValue());
		m.setCodeTime(m.getCreateTime());
		return null;
	}
    
    


}
