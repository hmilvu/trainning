package com.xtrainning.hop.service.mobile;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.rop.utils.RopUtils;
import com.xtrainning.hop.common.Constants.METHOD;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetProfileRequest;
import com.xtrainning.hop.request.mobile.GetVcodeRequest;
import com.xtrainning.hop.request.mobile.LoginRequest;
import com.xtrainning.hop.request.mobile.LogoffRequest;
import com.xtrainning.hop.request.mobile.SignUpRequest;
import com.xtrainning.hop.request.mobile.ThirdLoginRequest;
import com.xtrainning.hop.response.mobile.LoginResponse;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.MemberResponse;
import com.xtrainning.hop.response.mobile.ProfileResponse;
import com.xtrainning.hop.response.mobile.SimpleResponse;
import com.xtrainning.hop.utils.HttpUtil;

public class MemberServiceTest extends TestCase{
    public static final String SERVER_URL = "http://localhost:8080/hop/service";
    public static final String APP_KEY = "iphone_user";
    public static final String APP_VERSION = "V0.5.0.0";
    public static final String APP_SECRET = "b3rl8DPBrc0ka4wxhisVrT4nMUL2Crtk";
    private static DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
    private static final String OPENUUID = "22345678917";
    private static String sessionId;
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetMemberId() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetMemberIdRequest ropRequest = new GetMemberIdRequest();
        ropRequest.setOpenuuid(OPENUUID);
        ropRequest.setAppVersion(APP_VERSION);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, MemberIdResponse.class, METHOD.GET_MEMBER_ID.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof MemberIdResponse);
	}
    
    @Test
    public void testGetMemberId2() throws JsonParseException, JsonMappingException, IOException {
    	Map <String, String>map = new HashMap<String, String>();
    	map.put("appKey", APP_KEY); //第二个参数为AppKey, 有O2O系统分配
    	map.put("method", "member.getMemberId"); 
    	map.put("v", "1.0");
    	map.put("appVersion", APP_VERSION);
    	map.put("format", "json");
    	map.put("openuuid", OPENUUID);
    	String sign = RopUtils.sign(map, APP_SECRET); //第二个参数为SecretKey, 有O2O系统分配
    	map.put("sign", sign);
    	String response = HttpUtil.postServer(SERVER_URL, map);
    	assertNotNull(response);
    }
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testPreSignUp() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetVcodeRequest ropRequest = new GetVcodeRequest();
    	ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setPhoneNumber("22345678901");
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, SimpleResponse.class, METHOD.PRE_SIGN_UP.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof SimpleResponse);
	}
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testSignUp() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		SignUpRequest ropRequest = new SignUpRequest();
		ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setPhoneNumber("22345678901");
        ropRequest.setNickName("zzp");
        ropRequest.setSex(1);
        ropRequest.setPassword("123456");
        ropRequest.setVcode("968117");
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, MemberResponse.class, METHOD.SIGN_UP.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof MemberResponse);
        LoginResponse successResponse = (LoginResponse)response.getSuccessResponse();
        ropClient.setSessionId(successResponse.getSessionId());
	}
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testLogin() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	LoginRequest ropRequest = new LoginRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setPhoneNumber("22345678901");
        ropRequest.setPassword("123456");
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, LoginResponse.class, METHOD.LOGIN.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LoginResponse);
        sessionId = ((LoginResponse)response.getSuccessResponse()).getSessionId();
	}
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testThirdLogin() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	ThirdLoginRequest ropRequest = new ThirdLoginRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setThirdPartyId("thirdPartyId");
        ropRequest.setNickName("steven");
        ropRequest.setAvatarUrl("url");
        ropRequest.setSex(1);
        ropRequest.setType(1);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, LoginResponse.class, METHOD.THIRD_LOGIN.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LoginResponse);
	}
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetProfile() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetProfileRequest ropRequest = new GetProfileRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setMemberId(3L);
        ropClient.setSessionId(sessionId);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, ProfileResponse.class, METHOD.GET_PROFILE.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof ProfileResponse);
	}
    
    /*@SuppressWarnings("rawtypes")
	@Test
	public void testUpdateProfile() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		ropClient.setSessionId("31ECEBC9-EA9E-4839-80C8-CFF98BCC3A3A");
		SaveMemberRequest ropRequest = new SaveMemberRequest();
        ropRequest.setMemberId(1L);
        ropRequest.setFirstName("steven");
        ropRequest.setLastName("zhang");
        ropRequest.setDisplayName("hmilvu");
        ropRequest.setPhoneNumber("136");
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, BaseAdminResponse.class, "member.updateProfile", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof BaseAdminResponse);
        BaseAdminResponse successResponse = (BaseAdminResponse)response.getSuccessResponse();
        assertTrue(successResponse.getFlag() == 0);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testRecommendAccount() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		ropClient.setSessionId("31ECEBC9-EA9E-4839-80C8-CFF98BCC3A3A");
		RecommendAccountRequest ropRequest = new RecommendAccountRequest();
        ropRequest.setMemberId(1L);
        ropRequest.setAccountName("7-11");
        ropRequest.setAddress("shanghai");
        ropRequest.setPhoneNumber("133");
        ropRequest.setAreaId(1);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, BaseAdminResponse.class, "member.recommendAccount", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof BaseAdminResponse);
        BaseAdminResponse successResponse = (BaseAdminResponse)response.getSuccessResponse();
        assertTrue(successResponse.getFlag() == 0);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testAddComment() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		ropClient.setSessionId("31ECEBC9-EA9E-4839-80C8-CFF98BCC3A3A");
		SaveReviewRequest ropRequest = new SaveReviewRequest();
        ropRequest.setMemberId(1L);
        ropRequest.setContent("张志鹏");
        ropRequest.setDealId(2L);
        ropRequest.setLevel(1);
        ropRequest.setTopic("ccc");        
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, BaseAdminResponse.class, "member.addComment", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof BaseAdminResponse);
        BaseAdminResponse successResponse = (BaseAdminResponse)response.getSuccessResponse();
        assertTrue(successResponse.getFlag() == 0);
	}*/
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testLogoff() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	LogoffRequest ropRequest = new LogoffRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setMemberId(3L);
        ropRequest.setOpenuuid(OPENUUID);
        ropClient.setSessionId(sessionId);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, LoginResponse.class, METHOD.LOGOFF.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof LoginResponse);
	}
}
