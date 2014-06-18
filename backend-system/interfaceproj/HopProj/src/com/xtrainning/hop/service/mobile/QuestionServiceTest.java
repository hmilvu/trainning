package com.xtrainning.hop.service.mobile;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.junit.Test;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.xtrainning.hop.common.Constants.METHOD;
import com.xtrainning.hop.request.mobile.GetAnswerListRequest;
import com.xtrainning.hop.request.mobile.GetQuestionDetailRequest;
import com.xtrainning.hop.response.mobile.AnswerListResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;

public class QuestionServiceTest extends TestCase{
    public static final String SERVER_URL = "http://localhost:8080/hop/service";
    public static final String APP_KEY = "iphone_user";
    public static final String APP_VERSION = "V0.5.0.0";
    public static final String APP_SECRET = "b3rl8DPBrc0ka4wxhisVrT4nMUL2Crtk";
    private static DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetQuestionDetail() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetQuestionDetailRequest ropRequest = new GetQuestionDetailRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setQuestionId(3L);
        ropRequest.setMemberId(4L);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, QuestionDetailResponse.class, METHOD.GET_QUESTION_DETAIL.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof QuestionDetailResponse);
	}
    
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetAnswerList() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetAnswerListRequest ropRequest = new GetAnswerListRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setQuestionId(3L);
        ropRequest.setMemberId(3L);
        ropRequest.setPageNumber(1);
        ropRequest.setPageSize(10);
        ropClient.setMessageFormat(MessageFormat.json);
        CompositeResponse response = ropClient.buildClientRequest()
                                   .post(ropRequest, AnswerListResponse.class, METHOD.GET_ANSWER_DETAIL.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof AnswerListResponse);
	}
}
