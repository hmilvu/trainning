package com.xtrainning.hop.service.mobile;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import junit.framework.TestCase;

import org.junit.Test;

import com.rop.MessageFormat;
import com.rop.client.CompositeResponse;
import com.rop.client.DefaultRopClient;
import com.xtrainning.hop.common.Constants.METHOD;
import com.xtrainning.hop.request.mobile.CreateAnswerRequest;
import com.xtrainning.hop.request.mobile.CreateQuestionRequest;
import com.xtrainning.hop.request.mobile.GetAnswerListRequest;
import com.xtrainning.hop.request.mobile.GetQuestionDetailRequest;
import com.xtrainning.hop.response.mobile.AnswerListResponse;
import com.xtrainning.hop.response.mobile.QuestionDetailResponse;
import com.xtrainning.hop.response.mobile.SimpleResponse;

public class QuestionServiceTest extends TestCase{
    public static final String SERVER_URL = "http://localhost:8080/hop/service";
    public static final String APP_KEY = "iphone_user";
    public static final String APP_VERSION = "V0.5.0.0";
    public static final String APP_SECRET = "b3rl8DPBrc0ka4wxhisVrT4nMUL2Crtk";
    private static DefaultRopClient ropClient = new DefaultRopClient(SERVER_URL, APP_KEY, APP_SECRET);
    private static final String sessionId = "A4A4C64C-58A9-4CD0-82B1-1E7581DC0895";
    @SuppressWarnings("rawtypes")
	@Test
	public void testGetQuestionDetail() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetQuestionDetailRequest ropRequest = new GetQuestionDetailRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setQuestionId(6L);
        ropRequest.setMemberId(3L);
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
	public void testGetQuestionDetail2() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
    	GetQuestionDetailRequest ropRequest = new GetQuestionDetailRequest();
        ropRequest.setAppVersion(APP_VERSION);
        ropRequest.setQuestionId(6L);
        ropRequest.setMemberId(4L);
        ropClient.setSessionId(sessionId);
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
                                   .post(ropRequest, AnswerListResponse.class, METHOD.GET_ANSWER_List.getValue(), "1.0");
        assertNotNull(response);
        assertTrue(response.isSuccessful());
        assertNotNull(response.getSuccessResponse());
        assertTrue(response.getSuccessResponse() instanceof AnswerListResponse);
	}
    
    @SuppressWarnings("rawtypes")
   	@Test
   	public void testCreateQuestion() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
       	CreateQuestionRequest ropRequest = new CreateQuestionRequest();
           ropRequest.setAppVersion(APP_VERSION);
           ropRequest.setMemberId(1L);
           ropRequest.setDescription("des");
           ropRequest.setName("name");
           ropRequest.setNewTopicName("新topic");
           ropRequest.setTopicIds("1");
           ropClient.setMessageFormat(MessageFormat.json);
           ropClient.setSessionId(sessionId);
           CompositeResponse response = ropClient.buildClientRequest()
                                      .post(ropRequest, SimpleResponse.class, METHOD.CREATE_QUESTION.getValue(), "1.0");
           assertNotNull(response);
           assertTrue(response.isSuccessful());
           assertNotNull(response.getSuccessResponse());
           assertTrue(response.getSuccessResponse() instanceof SimpleResponse);
   	}
    
    @SuppressWarnings("rawtypes")
   	@Test
   	public void testCreateAnswer() throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
       	CreateAnswerRequest ropRequest = new CreateAnswerRequest();
           ropRequest.setAppVersion(APP_VERSION);
           ropRequest.setContent("answer");
           ropRequest.setMemberId(3L);
           ropRequest.setQuestionId(6L);
           ropClient.setMessageFormat(MessageFormat.json);
           ropClient.setSessionId(sessionId);
           CompositeResponse response = ropClient.buildClientRequest()
                                      .post(ropRequest, SimpleResponse.class, METHOD.CREATE_ANSWER.getValue(), "1.0");
           assertNotNull(response);
           assertTrue(response.isSuccessful());
           assertNotNull(response.getSuccessResponse());
           assertTrue(response.getSuccessResponse() instanceof SimpleResponse);
   	}
}
