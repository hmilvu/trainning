package com.xtrainning.hop.service.mobile;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.junit.Test;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.xtrainning.hop.common.Constants.METHOD;
import com.xtrainning.hop.request.mobile.GetMemberIdRequest;
import com.xtrainning.hop.request.mobile.GetNewsListRequest;
import com.xtrainning.hop.response.mobile.MemberIdResponse;
import com.xtrainning.hop.response.mobile.NewsListResponse;

public class MemberServiceTest extends TestCase{
    public static final String SERVER_URL = "http://localhost:8080/hop/service";
    public static final String APP_KEY = "iphone_user";
    public static final String APP_VERSION = "V0.5.0.0";
    public static final String APP_SECRET = "b3rl8DPBrc0ka4wxhisVrT4nMUL2Crtk";
    private static DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
    private static final String OPENUUID = "12345678917";
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
    /*@SuppressWarnings("rawtypes")
	@Test
	public void testSignUp() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		SignUpRequest ropRequest = new SignUpRequest();
        ropRequest.setMemberId(1L);
        ropRequest.setEmail("a@a.com");
        ropRequest.setPassword("123456");
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, MemberResponse.class, "member.signUp", "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof MemberResponse);
        MemberResponse successResponse = (MemberResponse)response.getSuccessResponse();
        ropClient.setSessionId(successResponse.getSessionId());
	}
	@SuppressWarnings("rawtypes")
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
}
