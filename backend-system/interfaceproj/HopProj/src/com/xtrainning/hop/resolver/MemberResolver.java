package com.xtrainning.hop.resolver;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xtrainning.hop.common.Config;
import com.xtrainning.hop.common.Constants;
import com.xtrainning.hop.common.Constants.MEMBER_GENDER;
import com.xtrainning.hop.common.Constants.MEMBER_REGISTER_STATUS;
import com.xtrainning.hop.common.Constants.MEMBER_STATUS;
import com.xtrainning.hop.common.Constants.MEMBER_TYPE;
import com.xtrainning.hop.common.Constants.PUSH_STATUS;
import com.xtrainning.hop.common.Constants.SMS_TYPE;
import com.xtrainning.hop.dao.MemberDAO;
import com.xtrainning.hop.dao.MemberExpandDAO;
import com.xtrainning.hop.dao.MemberSmsHistoryDAO;
import com.xtrainning.hop.entity.Member;
import com.xtrainning.hop.entity.MemberExpand;
import com.xtrainning.hop.entity.MemberSmsHistory;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.SignUpRequest;
import com.xtrainning.hop.request.mobile.ThirdLoginRequest;
@Service
public class MemberResolver extends BaseResolver{

	@Autowired private MemberDAO memberDao;
	@Autowired private MemberExpandDAO memberExpandDao;
	@Autowired private ClientAppkeyResolver appKeyResolver;
	@Autowired private MemberSmsHistoryDAO memberSmsHistoryDao;
	
    @Cacheable(value="MemberResolver.getMemberByUUID")
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
		m.setLastAccessTime(m.getCreateTime());
		memberDao.save(m);
		
		MemberExpand ex = new MemberExpand();
		ex.setAppVersion(request.getAppVersion());
		ex.setMember(m);
		ex.setOsType(appKeyResolver.getOsTypeByAppkey(request.getRopRequestContext().getAppKey()));
		ex.setUuid(request.getOpenuuid());
		memberExpandDao.save(ex);
		return m;
	}
	
	public void updateLastAccessTime(Long memberId) {
		memberDao.updateLastAccessTime(memberId);
		
	}
	
	@Cacheable(value="MemberResolver.getMemberById")
	public Member getMemberById(Long memberId) {
		return memberDao.findById(memberId);
	}

	public Long checkMemberByPhoneNumber(String phoneNumber) {
		Long memberId = memberDao.getByPhoneNumber(phoneNumber);
		return memberId;
	}

	public MemberSmsHistory createVcode(String phoneNumber) {
		Random random = new Random();
		String vcode = "";
		for(int i = 0; i < 6; i++){
			vcode += random.nextInt(10);
		}
		String content = Config.getProperty(Constants.SMS_SIGN_UP_TEMPLATE);
		content = StringUtils.replace(content, "{vcode}", vcode);
		MemberSmsHistory h = new MemberSmsHistory();
		h.setPhoneNumber(phoneNumber);
		h.setContent(content);
		h.setCreateTime(new Timestamp(new Date().getTime()));
		h.setType(SMS_TYPE.SIGN_UP.getValue());
		h.setVcode(vcode);
		memberSmsHistoryDao.save(h);
		return h;
	}

	public Long signUp(SignUpRequest request) {
		Member m = new Member();
		m.setType(MEMBER_TYPE.PUBLIC.getValue());
		m.setStatus(MEMBER_STATUS.ACTIVE.getValue());
		m.setRegisterStatus(MEMBER_REGISTER_STATUS.REGISTERED.getValue());
		m.setSex(request.getSex());
		m.setCreateTime(new Timestamp(new Date().getTime()));
		m.setPushStatus(PUSH_STATUS.ON.getValue());
		m.setCodeTime(m.getCreateTime());
		m.setLastAccessTime(m.getCreateTime());
		m.setPassword(request.getPassword());
		m.setPhoneNumber(request.getPhoneNumber());
		m.setNickName(request.getNickName());
		memberDao.save(m);
		
		MemberExpand ex = new MemberExpand();
		ex.setAppVersion(request.getAppVersion());
		ex.setMember(m);
		ex.setOsType(appKeyResolver.getOsTypeByAppkey(request.getRopRequestContext().getAppKey()));
		memberExpandDao.save(ex);
		
		return m.getId();
	}

	public int checkVcode(String phoneNumber, String vcode) {
		MemberSmsHistory h = memberSmsHistoryDao.getLastestHistory(SMS_TYPE.SIGN_UP, phoneNumber);
		if(h != null){
			long timeDifference = System.currentTimeMillis() - h.getCreateTime().getTime();
			if(timeDifference > 75 * 1000){
				return 1; //超时
			}
			if(StringUtils.equals(h.getVcode(), vcode)){
				return 0; //验证码正确
			} else {
				return 2; //验证码不正确
			}
		}
		return 2;//验证码不正确
	}

	public int checkMemberSmsNum(SMS_TYPE type, String phoneNumber) {
		Long count = memberSmsHistoryDao.getTodayMaxSms(type, phoneNumber);
		int maxNum = 0;
		if(type == SMS_TYPE.SIGN_UP){
			maxNum = Integer.valueOf(Config.getProperty(Constants.MAX_SMS_SIGN_UP_NUM));
		} else if(type == SMS_TYPE.RESET_PWD){
			maxNum = Integer.valueOf(Config.getProperty(Constants.MAX_SMS_RESET_PASSWORD_NUM));
		}
		if(count == null || count <= maxNum){
			return 0;
		} else {
			return 1; //超过了发送短信的条数
		}
	}

	public Long checkMemberByCredentials(String phoneNumber, String password) {
		Long memberId = memberDao.getByCredentials(phoneNumber, password);
		return memberId;
	}

	public Long checkMemberByThirdPartyId(String thirdPartyId, Integer type) {
		Long memberId = memberDao.checkMemberByThirdPartyId(thirdPartyId, type);
		return memberId;
	}

	public Long thirdSignUp(ThirdLoginRequest request) {
		Member m = new Member();
		m.setType(MEMBER_TYPE.PUBLIC.getValue());
		m.setStatus(MEMBER_STATUS.ACTIVE.getValue());
		m.setRegisterStatus(MEMBER_REGISTER_STATUS.REGISTERED.getValue());
		m.setSex(request.getSex());
		m.setCreateTime(new Timestamp(new Date().getTime()));
		m.setPushStatus(PUSH_STATUS.ON.getValue());
		m.setCodeTime(m.getCreateTime());
		m.setLastAccessTime(m.getCreateTime());
		m.setNickName(request.getNickName());
		m.setAvatarUrl(request.getAvatarUrl());
		m.setThirdPartyId(request.getThirdPartyId());
		m.setThirdPartyType(request.getType());
		memberDao.save(m);
		
		MemberExpand ex = new MemberExpand();
		ex.setAppVersion(request.getAppVersion());
		ex.setMember(m);
		ex.setOsType(appKeyResolver.getOsTypeByAppkey(request.getRopRequestContext().getAppKey()));
		memberExpandDao.save(ex);
		
		return m.getId();
	}
    
    


}
